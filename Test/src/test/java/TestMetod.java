import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestMetod {

    //static {System.setProperty("webdriver.chrome.driver","D:\\ДЗ QA\\Chrome Driver\\chromedriver.exe");}

WebDriver startDriver() {
    System.setProperty("webdriver.chrome.driver", "D:\\ДЗ QA\\Chrome Driver/chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    WebDriver driver = new ChromeDriver(options);

    return driver;
}
    WebDriver driver = startDriver();

    void openSite() {


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String baseUrl = "http://a.testaddressbook.com/";

        driver.get(baseUrl);
    }
    void singIn(){

        driver.findElement(By.cssSelector("[href=\"/sign_in\"]")).click();
        driver.findElement(By.id("session_email")).sendKeys("ilia@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("rfkmrekznjh");
        driver.findElement(By.cssSelector("input[value=\"Sign in\"]")).click();
    }
    void addAdress(){

        driver.findElement(By.cssSelector("[href=\"/addresses\"")).click();
        driver.findElement(By.cssSelector("[href=\"/addresses/new\"")).click();
        driver.findElement(By.id("address_first_name")).sendKeys("Ilya");
        driver.findElement(By.id("address_last_name")).sendKeys("Petrov");
        driver.findElement(By.id("address_street_address")).sendKeys("Mira 9, 75");
        driver.findElement(By.id("address_secondary_address")).sendKeys("Gay 3, 82");
        driver.findElement(By.id("address_city")).sendKeys("Grodno");
        driver.findElement(By.id("address_state")).click();
        driver.findElement(By.cssSelector("option[value=\"IN\"]")).click();
        driver.findElement(By.id("address_zip_code")).sendKeys("230010");
        driver.findElement(By.id("address_country_us")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("14.07.1987");
//        driver.findElement(By.id("address_color")).click();
//        driver.findElement(By.id("address_color")).sendKeys("25 25 45");
        driver.findElement(By.id("address_age")).sendKeys("34");
        driver.findElement(By.id("address_website")).sendKeys("https://vk.com/");
        driver.findElement(By.id("address_phone")).sendKeys("+375293548978");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_note")).sendKeys("Hello World");
        driver.findElement(By.cssSelector("input[value=\"Create Address\"]")).click();
    }
    void changeAdress() {
        driver.findElement(By.cssSelector("[href=\"/addresses\"")).click();
        driver.findElement(By.xpath("//a[(text()='Edit')][1]")).click();
        driver.findElement(By.id("address_first_name")).clear();
        driver.findElement(By.id("address_first_name")).sendKeys("Vasia");
        driver.findElement(By.id("address_last_name")).clear();
        driver.findElement(By.id("address_last_name")).sendKeys("Ivanow");
        driver.findElement(By.id("address_street_address")).clear();
        driver.findElement(By.id("address_secondary_address")).sendKeys("Popovicha 82");
        driver.findElement(By.id("address_street_address")).clear();
        driver.findElement(By.id("address_street_address")).sendKeys("Dekabristow 8");
        driver.findElement(By.id("address_secondary_address")).clear();
        driver.findElement(By.id("address_secondary_address")).sendKeys("Popovicha 82");
        driver.findElement(By.id("address_city")).clear();
        driver.findElement(By.id("address_city")).sendKeys("Vitebsk");
        driver.findElement(By.id("address_state")).click();
        driver.findElement(By.cssSelector("option[value=\"CT\"]")).click();
        driver.findElement(By.id("address_zip_code")).clear();
        driver.findElement(By.id("address_zip_code")).sendKeys("230009");
        driver.findElement(By.id("address_country_us")).click();
        driver.findElement(By.id("address_birthday")).clear();
        driver.findElement(By.id("address_birthday")).sendKeys("30.08.1980");
//        driver.findElement(By.id("address_color")).click();
//        driver.findElement(By.id("address_color")).sendKeys("25 25 45");
        driver.findElement(By.id("address_age")).clear();
        driver.findElement(By.id("address_age")).sendKeys("40");
        driver.findElement(By.id("address_website")).clear();
        driver.findElement(By.id("address_website")).sendKeys("https://vk.com/");
        driver.findElement(By.id("address_phone")).clear();
        driver.findElement(By.id("address_phone")).sendKeys("+3755565478954");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_note")).clear();
        driver.findElement(By.id("address_note")).sendKeys("Hello World World");
        driver.findElement(By.cssSelector("input[value=\"Update Address\"]")).click();
    }
    void delAdress(){
        driver.findElement(By.cssSelector("[href=\"/addresses\"")).click();
        driver.findElement(By.xpath("//a[(text()='Destroy')][1]")).click();
        driver.switchTo().alert().accept();
    }

    void quit() {
        driver.findElement(By.cssSelector("[href=\"/sign_out\"")).click();
    }

    void closeDriver() {
        driver.quit();
    }

}
