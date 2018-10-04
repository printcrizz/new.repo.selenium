package utils

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import java.awt.Robot
import java.awt.event.KeyEvent
import java.text.DecimalFormat

class GeneralUtils {

    public static String aux= ""

    public static String AmountFormat(Integer amount){
        DecimalFormat formatter = new DecimalFormat("###,###,###.###")
        return formatter.format(amount).toString()
    }

    public static String AddMoneyHeist(String money){
        String auxx = "\$" + money
        return auxx
    }

    public static ZoomOut(){
        Robot robot = new Robot();
        System.out.println("About to zoom out");
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }
    public static void ScrollDownToElement(WebDriver driver, WebElement xpath){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",xpath );

    }
}

