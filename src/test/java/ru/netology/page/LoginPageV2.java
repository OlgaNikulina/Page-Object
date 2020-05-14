package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class LoginPageV2 {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement buttonContinue = $("span.button__text");
    private SelenideElement balance01CartBefore = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement balance02CartBefore = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement buttonReplenish1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text");
    private SelenideElement buttonReplenish2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text");
    private SelenideElement transferPage = $("div.App_appContainer__3jRx1");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement replenishFinalButton = $$("button").find(exactText("пополнить"));
    private SelenideElement balance01CartAfter = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement balance02CartAfter = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement cartsInfoPage = $("App_appContainer__3jRx1");


    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        buttonContinue.click();
        return new VerificationPage();
    }

    public DataHelper transferMoneyFrom01Cart(DataHelper.CartInfo dataHelper) {
        balance01CartBefore.shouldBe(visible);
        balance02CartBefore.shouldBe(visible);
        buttonReplenish2.click();
        transferPage.shouldBe(visible);
        amountField.setValue(String.valueOf(dataHelper.getAmount()));
        fromField.setValue(dataHelper.getCartNumber1());
        replenishFinalButton.click();
        balance01CartAfter.shouldBe(visible);
        balance02CartAfter.shouldBe(visible);
        return (DataHelper) cartsInfoPage;
    }

    public DataHelper transferMoneyFrom02Cart(DataHelper.CartInfo dataHelper) {
        balance01CartBefore.shouldBe(visible);
        balance02CartBefore.shouldBe(visible);
        buttonReplenish1.click();
        transferPage.shouldBe(visible);
        amountField.setValue(String.valueOf(dataHelper.getAmount()));
        fromField.setValue(dataHelper.getCartNumber2());
        replenishFinalButton.click();
        cartsInfoPage.shouldBe(visible);
        return (DataHelper) cartsInfoPage;
    }
}
