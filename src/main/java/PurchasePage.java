
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class PurchasePage {

    SelenideElement addToCartTshirtRedButton = $(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));

    SelenideElement addToCartBikeLight = $(By.id("add-to-cart-sauce-labs-bike-light"));

    SelenideElement addToCartBackpack = $(By.id("add-to-cart-sauce-labs-backpack"));

    SelenideElement removeTshirtRedButton = $(By.id("remove-test.allthethings()-t-shirt-(red)"));

    SelenideElement removeBikeLight = $(By.id("remove-sauce-labs-bike-light"));

    SelenideElement removeBackpack = $(By.id("remove-sauce-labs-backpack"));

    SelenideElement basketButton = $(By.id("shopping_cart_container"));

    public static final SelenideElement products = $(".title");

    @Step("Purchase Tshirt Red Button")
    public void purchaseTshirtRedButton  () {

        addToCartTshirtRedButton.click();

    }
    public void purchaseBikeLight  () {

        addToCartBikeLight.click();

    }
    @Step("Purchase Back pack")
    public void purchaseBackpack  () {

        addToCartBackpack.click();

    }

    public void cancelPurchaseTshirtRedButton  () {

        removeTshirtRedButton.click();

    }
    public void cancelPurchaseBikeLight  () {

        removeBikeLight.click();

    }

    public void cancelPurchaseBackpack  () {

        removeBackpack.click();

    }
    @Step("Go Basket")
    public void goBasket () {

        basketButton.click();

    }
}
