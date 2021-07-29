package Metod;

import Constant.ConstantLocator;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.Driver.driver;

public class RepitMetod implements ConstantLocator {
    //private final static WebDriver driver = Driver.getChromeDriver() ;

    public static void click(By locator) {

        driver.findElement(locator).click();

    }
    public static void clear (By locator) {

        driver.findElement(locator).clear();

    }

    public static void type(By locator, String testData) {
        driver.findElement(locator).sendKeys(testData);
    }

    public static void switchTo() {
        driver.switchTo().alert().accept();
    }

    public static void quit() {
        driver.findElement(SING_OUT).click();
    }

    public static void quitDriver() {
        driver.quit();
    }

}
