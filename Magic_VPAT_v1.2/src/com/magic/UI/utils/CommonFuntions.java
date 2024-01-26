package com.magic.UI.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFuntions {

	public static void getTableData() {

	}

	public static void updateTableDataFromDoc() {

	}

	/**
	 * <strong>Uses of Function:</strong> This function is used to download the VPAT
	 * @param vpatName
	 * @return
	 * @throws Exception
	 */
	public static String downloadVPAT(String vpatName) throws Exception {
		String message = "";
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		List<String> arguments = new ArrayList<String>();
        // Configure Chrome options for file download
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        // Launch Chrome browser with configured options
        WebDriver driver = new ChromeDriver(options);
        // launch the url in the chrome browser.
		driver.get("https://www.itic.org/policy/accessibility/vpat");
		// check page ready or not
		CommonFuntions.checkPageIsReady(driver);
		// this line of code is deleting the provided file if it is exist.
		CommonFuntions.deleteFile("C:\\Users\\"+System.getProperty("user.name")+"\\Downloads",vpatName);
		String sElement = "//ul[@class='relationship-entries-list']//li//a[contains(text(),'" + vpatName + "')]";
		// scrolling till element.
		CommonFuntions.jsScrollInMid(driver, driver.findElement(By.xpath(sElement)));
		try {
			// click on element
			driver.findElement(
					By.xpath("//ul[@class='relationship-entries-list']//li//a[contains(text(),'" + vpatName + "')]"))
					.click();
			//this line of code is checking file is getting downloaded or not
			message=CommonFuntions.isFileDownload("C:\\Users\\"+System.getProperty("user.name")+"\\Downloads", vpatName);
		} catch (Exception e) {

		}
		// Quit the WebDriver.
		driver.quit();
		return message;
	}

	/**
	 * <strong>Uses of Function:</strong> This function is used to scroll till element
	 * @param driver
	 * @param element
	 * @throws Exception
	 */
	private static void jsScrollInMid(WebDriver driver, WebElement element) throws Exception {
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	}

	private static void checkPageIsReady(WebDriver driver) throws Exception {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Initially bellow given if condition will check ready state of page.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
//				System.out.println("Page Is loaded.");
				return;
			}

			// This loop will iterate for 50 times to check If page Is ready after
			// every 1 second.
			// If the page loaded successfully, it will terminate the for loop
			for (int i = 0; i < 50; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}

				// To check page ready state.
				if (js.executeScript("return document.readyState").toString().equals("complete")) {
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	private static String isFileDownload(String filePath, String partialFileName) throws InterruptedException {
		Thread.sleep(5000);
		File directory = new File(filePath);
        File[] files = directory.listFiles((dir, name) -> name.startsWith(partialFileName));
        File fileName = null;
        if (files != null && files.length > 0) {
        	fileName=files[0];
        }else {
        	files = directory.listFiles((dir, name) -> name.startsWith(partialFileName.replaceAll(" ", "")));
            if (files != null && files.length > 0) {
            	fileName=files[0];
            }
        }
		FluentWait<File> wait = new FluentWait<File>(fileName).withTimeout(java.time.Duration.ofMinutes(10))
				.pollingEvery(java.time.Duration.ofSeconds(5)).ignoring(Exception.class)
				.withMessage("File is not downloaded");
		boolean isDownloaded = wait.until(f -> f.exists() && f.canRead());
		if (isDownloaded) {
			return fileName.toString();
		} else {
			return fileName.toString();
		}
	}
	
	private static void deleteFile(String filePath,String partialFileName) {
		File directory = new File(filePath);
        File[] files = directory.listFiles((dir, name) -> name.startsWith(partialFileName));
        File fileName = null;
        if (files != null && files.length > 0) {
        	fileName=files[0];
        	fileName.delete();
        }else {
        	files = directory.listFiles((dir, name) -> name.startsWith(partialFileName.replaceAll(" ", "")));
        	if (files != null && files.length > 0) {
            	fileName=files[0];
            	fileName.delete();
            }
        }
       
	}
}
