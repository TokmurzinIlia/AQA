package Metod;

import Constant.ConstantLocator;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Utils.Driver.driver;

public class Metods implements ConstantLocator {


    public void openSite() {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String baseUrl = "http://a.testaddressbook.com/";

        driver.get(baseUrl);
    }

    public void singIn(){
        RepitMetod.click(SING_IN);
        RepitMetod.type(By.id("session_email"), "ilia@gmail.com");
        RepitMetod.type(By.id("session_password"), "rfkmrekznjh");
        RepitMetod.click(By.cssSelector("input[value=\"Sign in\"]"));

    }
    public void addAdress(){

        RepitMetod.click(ADRESSES);
        RepitMetod.click(NEW_ADRESSES);
        RepitMetod.type(FIRST_NAME, "Ilya");
        RepitMetod.type(LAST_NAME, "Petrov");
        RepitMetod.type(STREET_ADRESS, "Mira 9, 75");
        RepitMetod.type(SECONDARY_ADRESS,"Gay 3, 82");
        RepitMetod.type(CITY,"Grodno");
        RepitMetod.click(STATE);
        RepitMetod.click(By.cssSelector("option[value=\"IN\"]"));
        RepitMetod.type(ZIP_CODE,"230010");
        RepitMetod.click(COUNTRY_US);
        RepitMetod.type(BIRTHDAY,"14.07.1987");
//        repitMetod.click(COLOR);
//        repitMetod.type(COLOR,"25.25.45");
        RepitMetod.type(AGE,"34");
        RepitMetod.type(WEBSITE,"https://vk.com/");
        RepitMetod.type(PHONE,"+375293548978");
        RepitMetod.click(CLIMB);
        RepitMetod.type(NOTE,"Hello World");
        RepitMetod.click(CREATE_ADRESS);
    }

    public void changeAdress() {
        RepitMetod.click(ADRESSES);
        RepitMetod.click(By.xpath("//a[(text()='Edit')][1]"));
        RepitMetod.clear(FIRST_NAME);
        RepitMetod.type(FIRST_NAME,"Vasia");
        RepitMetod.clear(LAST_NAME);
        RepitMetod.type(LAST_NAME,"Ivanow");
        RepitMetod.clear(STREET_ADRESS);
        RepitMetod.type(STREET_ADRESS,"Popovicha 82");
        RepitMetod.clear(SECONDARY_ADRESS);
        RepitMetod.type(SECONDARY_ADRESS,"Popovicha 82");
        RepitMetod.clear(CITY);
        RepitMetod.type(CITY,"Vitebsk");
        RepitMetod.click(STATE);
        RepitMetod.click(By.cssSelector("option[value=\"CT\"]"));
        RepitMetod.clear(ZIP_CODE);
        RepitMetod.type(ZIP_CODE, "230009");
        RepitMetod.click(By.id("address_country_us"));
        RepitMetod.clear(BIRTHDAY);
        RepitMetod.type(BIRTHDAY,"30.08.1980");
//        repitMetod.click(COLOR);
//        repitMetod.clear(COLOR);
//        repitMetod.type(COLOR,"245.75.45");
        RepitMetod.clear(AGE);
        RepitMetod.type(AGE,"40");
        RepitMetod.clear(WEBSITE);
        RepitMetod.type(WEBSITE,"https://vk.com/");
        RepitMetod.clear(PHONE);
        RepitMetod.type(PHONE,"+3755565478954");
        RepitMetod.click(DANCE);
        RepitMetod.clear(NOTE);
        RepitMetod.type(NOTE,"Hello World World");
        RepitMetod.click(By.cssSelector("input[value=\"Update Address\"]"));
    }
    public void delAdress(){
        RepitMetod.click(ADRESSES);
        RepitMetod.click(By.xpath("//a[(text()='Destroy')][1]"));
        RepitMetod.switchTo();
    }

    public void quit() {
        RepitMetod.click(SING_OUT);
    }

}
