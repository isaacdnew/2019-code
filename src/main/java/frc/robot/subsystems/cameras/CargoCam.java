package frc.robot.subsystems.cameras;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.HumanCamPipeline;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionThread;

/**
 * The camera that looks at the cube from the claw (for human use only)
 */
public class CargoCam extends Subsystem {
	UsbCamera cargoCam;
	final int imgWidth = 160;
	final int imgHeight = 120;
	final int fps = 30;
	final int brightness = 20;
	final int exposure = 50;
	final int whiteBalance = 1000;

	VisionThread visionThread;

	public CargoCam(int port) {
		cargoCam = new UsbCamera("ClawCam", port);
	}

	public void startRecording() {
		cargoCam.setResolution(imgWidth, imgHeight);
		cargoCam.setFPS(fps);
		cargoCam.setBrightness(brightness);
		cargoCam.setExposureAuto();
		cargoCam.setWhiteBalanceManual(whiteBalance);
		CameraServer.getInstance().startAutomaticCapture(cargoCam);
	}

	public void startProcessing() {
		startRecording();
		CvSource outputStream = CameraServer.getInstance().putVideo("CargoCam", imgWidth, imgHeight);
		visionThread = new VisionThread(cargoCam, new HumanCamPipeline(), pipeline -> {
			outputStream.putFrame(pipeline.resizeImageOutput());
		});
		visionThread.start();
	}

	public void initDefaultCommand() {
	}
}