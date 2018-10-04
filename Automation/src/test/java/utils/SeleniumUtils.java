package utils;

import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.support.ui.Select;
public class SeleniumUtils {

    public WebDriver driver;
    private static ChromeDriverService service;
    public XpathEnum xp=new XpathEnum();

    public void OpenBrowser(String url)throws Exception {

        System.setProperty("webdriver.chrome.driver", System.getProperty("MyBrowser"));
        driver = new ChromeDriver();
        driver.get(url);
    }
    public void maximizeBrowser(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, java.util.concurrent.TimeUnit.SECONDS);
    }
    public void CloseBrowser() {
        driver.close();
    }
    public void changeIFrame(){
        driver.switchTo().frame("iframe_runner");
    }
    public String validateValueinXPath(String path)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        return driver.findElement(By.xpath(path)).getText();
    }
    public void clickButtonInXPath(String path)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        driver.findElement(By.xpath(path)).click();
    }
    public void sendValuesXpath(String xpath, String value) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }
    public String validateTextInCss(String css)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        return driver.findElement(By.cssSelector(css)).getText();
    }
    public boolean CompareXpathWithValue(String xpath, String value)throws Throwable{
        return validateValueinXPath(xpath).equals(value);
    }
    public void clickOnCSS(String css){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        driver.findElement(By.cssSelector(css)).click();
    }
    public String getCSSColor(String path)throws Throwable{
        Thread.sleep(2000);
        return driver.findElement(By.xpath(path)).getCssValue("background-color");
    }
    public int getCardLocationInList(String bin, String path){
        int xpath =driver.findElements(By.xpath(path)).size();
        int result= 0;
        if(xpath==1)
            return 0;
        else {
            for (int i = 1; i <= xpath; i++) {
                String pathx = path + "[" + i + "]/strong/small";
                WebDriverWait wait = new WebDriverWait(driver, 3);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathx)));
                String value = driver.findElement(By.xpath(pathx)).getText();
                if (value.contains(bin)) {
                    result = i;
                }
            }
        }
         return result;
    }
    public boolean containsValueInXPath(String xpath, String value){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String path = driver.findElement(By.xpath(xpath)).getText();
        return path.contains(value);
    }
    public void containsSameImage(String path, String imageName) throws IOException {
        BufferedImage expectedImage = ImageIO.read(new File("src/test/resources/images/"+imageName));
        WebElement logo = driver.findElement(By.xpath(path));
        String logoSRC = logo.getAttribute("src");

        URL imageURL = new URL(logoSRC);
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(saveImage, expectedImage);
        Assert.assertFalse(diff.hasDiff());
    }
    public boolean compareStringsInXpath(String xpath, String value) throws Throwable{
        Thread.sleep(4000);
        String path = driver.findElement(By.xpath(xpath)).getText();
        return value.equals(path);
    }
    public void SelectDropDown(String type, String element){
      //  Select droplist = new Select(driver.findElement(By.xpath(searchXpathinArray(type))));
        //droplist.selectByVisibleText(element);
    }
    public void GotoURL(String url){
        driver.get(url);
    }
    public void MouseHover(String pathToHover, String pathToClick){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath(pathToHover));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath(pathToClick))).click().build().perform();
    }
    public WebDriver returnDriver(){
        return driver;
    }
    public WebElement returnElement(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}
