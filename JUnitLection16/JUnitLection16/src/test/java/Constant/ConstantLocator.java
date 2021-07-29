package Constant;


import org.openqa.selenium.By;

public interface ConstantLocator {
    By SING_IN = new By.ByCssSelector("[href=\"/sign_in\"]");
    By ADRESSES = new By.ByCssSelector("[href=\"/addresses\"");
    By NEW_ADRESSES = new By.ByCssSelector("[href=\"/addresses/new\"");
    By FIRST_NAME = new By.ById("address_first_name");
    By LAST_NAME = new By.ById("address_last_name");
    By STREET_ADRESS = new By.ById("address_street_address");
    By SECONDARY_ADRESS = new By.ById("address_secondary_address");
    By CITY = new By.ById("address_city");
    By STATE = new By.ById("address_state");
    By ZIP_CODE = new By.ById("address_zip_code");
    By COUNTRY_US = new By.ById("address_country_us");
    By BIRTHDAY = new By.ById("address_birthday");
    By COLOR = new By.ById("address_color");
    By WEBSITE = new By.ById("address_website");
    By PHONE = new By.ById("address_phone");
    By CLIMB = new By.ById("address_interest_climb");
    By NOTE = new By.ById("address_note");
    By CREATE_ADRESS = new By.ByCssSelector("input[value=\"Create Address\"]");
    By AGE = new By.ById("address_age");
    By DANCE = new By.ById("address_interest_dance");
    By SING_OUT = new By.ByCssSelector("[href=\"/sign_out\"");





}

