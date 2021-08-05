import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutYourInformation {

    SelenideElement cancelButton = $(By.id("cancel"));

    SelenideElement continueButton = $(By.id("continue"));

    SelenideElement firstNameField = $(By.id("first-name"));

    SelenideElement lastNameField = $(By.id("last-name"));

    SelenideElement zipPostalCodeField = $(By.id("postal-code"));

    String FIRST_NAME = "ILia";

    String LAST_NAME = "Ivanow";

    String ZIP_POSTAL_CODE = ("23009");



}
