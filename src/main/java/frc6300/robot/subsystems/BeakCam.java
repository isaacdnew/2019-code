package frc6300.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc6300.robot.BeakCamPipeline;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionThread;

/**
 * The camera that looks at the cube from the claw (for human use only)
 */
public class BeakCam extends Subsystem {
	UsbCamera beakCam;
	final int imgWidth = 160;
	final int imgHeight = 120;
	final int fps = 20;
	final int brightness = 20;
	final int exposure = 50;
	final int whiteBalance = 1000;

	VisionThread visionThread;
	final Object turnAngleSync = new Object();
	double centerX = 0.0;
	double lastTurnAngle = 0.0;
	double turnAngle = 0.0;

	public BeakCam(int port) {
		beakCam = new UsbCamera("ClawCam", port);
	}

	public void startRecording() {
		beakCam.setResolution(imgWidth, imgHeight);
		beakCam.setFPS(fps);
		beakCam.setBrightness(brightness);
		beakCam.setExposureAuto();
		beakCam.setWhiteBalanceManual(whiteBalance);
		CameraServer.getInstance().startAutomaticCapture(beakCam);
	}

	public void startProcessing() {
		startRecording();
		CvSource outputStream = CameraServer.getInstance().putVideo("BeakCam", imgWidth, imgHeight);
		visionThread = new VisionThread(beakCam, new BeakCamPipeline(), pipeline -> {
			outputStream.putFrame(pipeline.blurOutput());
		});
		visionThread.start();
	}

	public void initDefaultCommand() {
	}
}