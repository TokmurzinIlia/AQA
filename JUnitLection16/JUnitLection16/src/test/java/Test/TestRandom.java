package Test;

import Metod.Metods;
import Metod.RepitMetod;
import Utils.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestRandom {

    private final WebDriver driver = Driver.getChromeDriver();

    @Test
    public void assertTest(){
        Metods metods = new Metods();
        metods.openSite();
        String pageTitle = driver.getTitle();

        Assertions.assertEquals("Addres Book", pageTitle,
                "Открыта не требуемая страница или название страницы неверно");
        RepitMetod.quitDriver();
    }
}
