import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {

    SelenideElement removeTshirtRedButton = $(By.id("remove-test.allthethings()-t-shirt-(red)"));

    SelenideElement removeBikeLight = $(By.id("remove-sauce-labs-bike-light"));

    SelenideElement removeBackpack = $(By.id("remove-sauce-labs-backpack"));

    SelenideElement continueShoppingButton = $(By.id("remove-sauce-labs-backpack"));

    SelenideElement checkoutButton  = $(By.id("checkout"));

    SelenideElement menuButton  = $(By.id("menu_button_container"));

    ElementsCollection productsInBasket = $$(byXpath("//div[@class='cart_item']"));
    public void deleteAllProducts() {
        for (int i = productsInBasket.size() - 1; i >= 0; i--) {
            productsInBasket.get(i).$("button[class=\"btn btn_secondary btn_small cart_button\"]").click();
        }

    }

}
