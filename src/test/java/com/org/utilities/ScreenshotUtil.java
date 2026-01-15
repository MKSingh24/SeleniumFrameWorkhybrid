package com.org.utilities;

import com.org.base.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtil {

//    public static String captureScreenshot(String status, String testName) {
//        try {
//            File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
//            String path = "reports/Screenshots/" + status + "/" + testName + ".png";
//            FileUtils.copyFile(src, new File(path));
//            return path;
//        } catch (Exception e) {
//            return null;
//       }
//    }
public static String captureScreenshot(String status, String testName) {

    try {

        TakesScreenshot ts = (TakesScreenshot)DriverFactory.getDriver();;

        // Byte array for Base64 and file saving
        byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
        String base64 = ts.getScreenshotAs(OutputType.BASE64);

        // Folder
        String folderPath = System.getProperty("user.dir") + "/reports/Screenshots/" + status;
        File folder = new File(folderPath);
        if (!folder.exists()) folder.mkdirs();

        // Physical file
        String filePath = folderPath + "/" + testName + ".png";
        File file = new File(filePath);
        FileUtils.writeByteArrayToFile(file, bytes);

        // Return Base64 for Extent report
        return base64;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}
