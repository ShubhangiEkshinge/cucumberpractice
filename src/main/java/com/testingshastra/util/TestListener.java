package com.testingshastra.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.testingshastra.keywords.UIKeywords;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class TestListener implements ITestListener{
	private static final Logger LOG = Logger.getLogger(TestListener.class);
	
	@Override
	public void onTestFailure(ITestResult result) {
		LOG.info("Test is Failed. Taking screenshot:");
		AShot ashot  = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot sc = ashot.takeScreenshot(UIKeywords.getInstance().driver);
		BufferedImage img = sc.getImage();
		String dir = System.getProperty("user.dir");
		try {
			ImageIO.write(img, "png", new File(dir+"/Screenshots/"+result.getName()+".png"));
		LOG.info("Screenshot is saved successfully");
		} catch (IOException e) {
			LOG.error("Unable to take screenshot");
			e.printStackTrace();
		}
	}

	
}
