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


    public CheckoutYourInformation(String FIRST_NAME, String LAST_NAME, String ZIP_POSTAL_CODE) {
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.ZIP_POSTAL_CODE = ZIP_POSTAL_CODE;
    }

    public CheckoutYourInformation() {

    }

    public void checkoutYourInformation()
    {

        firstNameField.setValue(FIRST_NAME);
        lastNameField.setValue(LAST_NAME);
        zipPostalCodeField.setValue(ZIP_POSTAL_CODE);
    }

}
