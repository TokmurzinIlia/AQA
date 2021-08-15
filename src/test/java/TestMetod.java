import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMetod {
    @BeforeAll
    public void setup() {

        Configuration.startMaximized = true;

    }
    @Test
    @Order(1)
    @DisplayName("Login")

    public void Login() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.login();
        PurchasePage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", PurchasePage.products.getText(), "User is not log in");

    }

    @Test
    @Order(2)
    @DisplayName("Shopping")

    public void shopping() {

        LoginPage loginPage = new LoginPage();
        PurchasePage purchasePage = new PurchasePage();
        BasketPage basketPage = new BasketPage();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        CheckoutYourInformation checkoutYourInformation = new CheckoutYourInformation();
        FinishPage finishPage = new FinishPage();
        loginPage.openLoginPage();
        loginPage.login();
        purchasePage.purchaseBackpack();
        purchasePage.purchaseTshirtRedButton();
        purchasePage.goBasket();
        basketPage.checkoutButton.click();
        checkoutYourInformation.firstNameField.setValue(checkoutYourInformation.FIRST_NAME);
        checkoutYourInformation.lastNameField.setValue(checkoutYourInformation.LAST_NAME);
        checkoutYourInformation.zipPostalCodeField.setValue(checkoutYourInformation.ZIP_POSTAL_CODE);
        checkoutYourInformation.continueButton.click();
        checkoutOverviewPage.finishButton.click();
        $("h2[class=\"complete-header\"]").shouldBe(visible);
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", $("h2[class=\"complete-header\"]").getText(), "Error: order not completed");
        finishPage.backButton.click();
    }

    @Test
    @Order(3)
    @DisplayName("Clear Basket")
    public void clearBasket(){
        LoginPage loginPage = new LoginPage();
        PurchasePage purchasePage = new PurchasePage();
        BasketPage basketPage = new BasketPage();
        loginPage.openLoginPage();
        loginPage.login();
        purchasePage.purchaseBackpack();
        purchasePage.purchaseTshirtRedButton();
        purchasePage.goBasket();
        basketPage.deleteAllProducts();
        Assertions.assertEquals($$(byXpath("//div[@class='cart_item']")).size(),0);
    }

    @Test
    @Order(4)
    @DisplayName("cancellation of purchases")

    public void cancellationOfPurchases() {

        LoginPage loginPage = new LoginPage();
        PurchasePage purchasePage = new PurchasePage();
        BasketPage basketPage = new BasketPage();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        CheckoutYourInformation checkoutYourInformation = new CheckoutYourInformation();
        loginPage.openLoginPage();
        loginPage.login();
        purchasePage.purchaseBackpack();
        purchasePage.purchaseTshirtRedButton();
        purchasePage.goBasket();
        basketPage.checkoutButton.click();
        checkoutYourInformation.firstNameField.setValue(checkoutYourInformation.FIRST_NAME);
        checkoutYourInformation.lastNameField.setValue(checkoutYourInformation.LAST_NAME);
        checkoutYourInformation.zipPostalCodeField.setValue(checkoutYourInformation.ZIP_POSTAL_CODE);
        checkoutYourInformation.continueButton.click();
        checkoutOverviewPage.cancelButton.click();

        PurchasePage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", PurchasePage.products.getText(), "User is not log in");
    }

    @Test
    @Order(5)
    @DisplayName("cancellation of purchase")

    public void cancellationOfPurchase() {

        LoginPage loginPage = new LoginPage();
        PurchasePage purchasePage = new PurchasePage();
        loginPage.openLoginPage();
        loginPage.login();
        purchasePage.purchaseBackpack();
        purchasePage.purchaseTshirtRedButton();
        sleep(5000);
        ElementsCollection purchaseCollection = $$("Remove");
        int purchaseCollectionBefore = purchaseCollection.size();
        purchasePage.removeBackpack.click();
        int purchaseCollectionAfter = purchaseCollection.size();
        Assertions.assertEquals(purchaseCollectionBefore, purchaseCollectionAfter );
        System.out.println(purchaseCollectionBefore);
        System.out.println(purchaseCollectionAfter);
    }



}

