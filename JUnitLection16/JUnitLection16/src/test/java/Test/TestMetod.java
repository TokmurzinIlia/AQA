package Test;
import Constant.ConstantLocator;
import Metod.RepitMetod;
import Utils.Driver;
import Utils.Log;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMetod implements ConstantLocator {




    private final WebDriver driver = Driver.getChromeDriver();


    @BeforeAll
    public void openSite() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Log.info("Открываем страницу http://a.testaddressbook.com/");

        String baseUrl = "http://a.testaddressbook.com/";

        driver.get(baseUrl);

        Log.info("Проверяем, что открылась корректная страница http://a.testaddressbook.com/");

        String pageCurrentUrl = driver.getCurrentUrl();

        Assertions.assertEquals("http://a.testaddressbook.com/", pageCurrentUrl,
                "Открыта не a.testaddressbook.com или название страницы неверно");

    }

    @BeforeEach
    void singIn() {

        Log.info("Нажимаем кнопку Sing In");

        RepitMetod.click(SING_IN);

        Log.info("Вводим email");

        RepitMetod.type(By.id("session_email"), "ilia@gmail.com");

        Log.info("Вводим пароль");

        RepitMetod.type(By.id("session_password"), "rfkmrekznjh");

        Log.info("Нажимаем кнопку Sing In");

        RepitMetod.click(By.cssSelector("input[value=\"Sign in\"]"));

        String pageTitle = driver.getTitle();

        Assertions.assertEquals("Address Book", pageTitle,
                "Открыта не требуемая страница или название страницы неверно");

    }
    @Order(2)
    @RepeatedTest(5)
    @DisplayName("Тест, который проверяет, добавление нового адреса")

    public void addAdress(){

        Log.info("Нажимаем кнопку Addresses");

        RepitMetod.click(ADRESSES);

        Log.info("Нажимаем кнопку New Address");

        RepitMetod.click(NEW_ADRESSES);

        Log.info("Заполняем поле" + "'" +  "Имя" + "'");

        RepitMetod.type(FIRST_NAME, "Ilya");

        Log.info("Заполняем поле" + "'" +  "Фамилия" + "'");

        RepitMetod.type(LAST_NAME, "Petrov");

        Log.info("Заполняем поле" + "'" +  "Адрес" + "'");

        RepitMetod.type(STREET_ADRESS, "Mira 9, 75");

        Log.info("Заполняем поле" + "'" +  "Второй Адрес" + "'");

        RepitMetod.type(SECONDARY_ADRESS,"Gay 3, 82");

        Log.info("Заполняем поле" + "'" +  "Город" + "'");

        RepitMetod.type(CITY,"Grodno");

        Log.info("Нажимаем кнопку Штат");

        RepitMetod.click(STATE);

        Log.info("Выбираем из списка нужный штат");

        RepitMetod.click(By.cssSelector("option[value=\"IN\"]"));

        Log.info("Заполняем поле" + "'" +  "Индекс" + "'");

        RepitMetod.type(ZIP_CODE,"230010");

        Log.info("Ставим маркер в поле" + "'" +  "Соединенные Штаты" + "'");

        RepitMetod.click(COUNTRY_US);

        Log.info("Заполняем поле" + "'" +  "Дата рождения" + "'");

        RepitMetod.type(BIRTHDAY,"14.07.1987");


//        repitMetod.click(By.id(COLOR));
//        repitMetod.type(By.id(COLOR),"25.25.45");

        Log.info("Заполняем поле" + "'" +  "Возраст" + "'");

        RepitMetod.type(AGE,"34");

        Log.info("Заполняем поле" + "'" +  "Сайт" + "'");

        RepitMetod.type(WEBSITE,"https://vk.com/");

        Log.info("Заполняем поле" + "'" +  "Телефон" + "'");

        RepitMetod.type(PHONE,"+375293548978");

        Log.info("Заполняем поле" + "'" +  "Хобби" + "'");

        RepitMetod.click(CLIMB);

        Log.info("Заполняем поле" + "'" +  "Сообщение" + "'");

        RepitMetod.type(NOTE,"Hello World");

        Log.info("Нажимаем кнопку 'Создать адрес'");

        RepitMetod.click(CREATE_ADRESS);
    }

    @Disabled
    @Order(1)
    @Test
    @DisplayName("Тест, который проверяет, изменение адреса, расположенного на первой строке")
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
//        repitMetod.click(By.id(COLOR));
//        repitMetod.clear(By.id(COLOR));
//        repitMetod.type(By.id(COLOR),"245.75.45");
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


    @Order(3)
    @Test
    @DisplayName("Тест, который проверяет, удаление адреса, расположенного на первой строке")
    public void delAdress(){
        RepitMetod.click(ADRESSES);
        RepitMetod.click(By.xpath("//a[(text()='Destroy')][1]"));
        RepitMetod.switchTo();
    }
    @AfterAll

    public void quitDriver() {

        driver.quit();
    }

    @AfterEach
    public void quit() {

        RepitMetod.click(SING_OUT);

        String baseUrl = "http://a.testaddressbook.com/";

        driver.get(baseUrl);

    }




}
