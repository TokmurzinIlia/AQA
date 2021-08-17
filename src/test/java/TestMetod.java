import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.*;
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
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test")
    @Feature("Login")
    @Test
    @Order(1)


    public void Login() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        PurchasePage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", PurchasePage.products.getText(), "User is not log in");

    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Shopping test")
    @Feature("Shopping")
    @Test
    @Order(2)


    public void shopping() {

        LoginPage loginPage = new LoginPage();
        PurchasePage purchasePage = new PurchasePage();
        BasketPage basketPage = new BasketPage();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        CheckoutYourInformation checkoutYourInformation = new CheckoutYourInformation();
        FinishPage finishPage = new FinishPage();
        loginPage.login();
        purchasePage.purchaseBackpack();
        purchasePage.purchaseTshirtRedButton();
        purchasePage.goBasket();
        basketPage.checkoutButton.click();
        checkoutYourInformation.checkoutYourInformation();
        checkoutYourInformation.continueButton.click();
        checkoutOverviewPage.finishButton.click();
        $("h2[class=\"complete-header\"]").shouldBe(visible);
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", $("h2[class=\"complete-header\"]").getText(), "Error: order not completed");
        finishPage.backButton.click();
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Clear basket")
    @Feature("Basket")
    @Test
    @Order(3)

    public void clearBasket(){
        LoginPage loginPage = new LoginPage();
        PurchasePage purchasePage = new PurchasePage();
        BasketPage basketPage = new BasketPage();
        loginPage.login();
        purchasePage.purchaseBackpack();
        purchasePage.purchaseTshirtRedButton();
        purchasePage.goBasket();
        basketPage.deleteAllProducts();
        Assertions.assertEquals($$(byXpath("//div[@class='cart_item']")).size(),0);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Cancellation of purchases")
    @Feature("Cancellation of purchases")
    @Test
    @Order(4)


    public void cancellationOfPurchases() {

        LoginPage loginPage = new LoginPage();
        PurchasePage purchasePage = new PurchasePage();
        BasketPage basketPage = new BasketPage();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        CheckoutYourInformation checkoutYourInformation = new CheckoutYourInformation();
        loginPage.login();
        purchasePage.purchaseBackpack();
        purchasePage.purchaseTshirtRedButton();
        purchasePage.goBasket();
        basketPage.checkoutButton.click();
        checkoutYourInformation.checkoutYourInformation();
        checkoutYourInformation.continueButton.click();
        checkoutOverviewPage.cancelButton.click();

        PurchasePage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", PurchasePage.products.getText(), "User is not log in");
    }
    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Description("Cancellation of purchases")
    @Feature("Cancellation of purchases")
    @Issue("OXZL-9")
    @Link("https://iliatokmurzin.atlassian.net/browse")
    @Test
    @Order(5)


    public void cancellationOfPurchase() {

        LoginPage loginPage = new LoginPage();
        PurchasePage purchasePage = new PurchasePage();
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

