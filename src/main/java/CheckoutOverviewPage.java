import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {

    SelenideElement finishButton = $(By.id("finish"));

    SelenideElement cancelButton = $(By.id("cancel"));

    SelenideElement cartItemPrice = $(".inventory_item_price");

    SelenideElement cartItemTotalPrice = $(".summary_total_label");

}
