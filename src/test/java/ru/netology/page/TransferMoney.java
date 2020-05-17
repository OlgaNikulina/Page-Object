package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferMoney {
    private SelenideElement balance01CartBefore = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement balance02CartBefore = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement buttonReplenish1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text");
    private SelenideElement buttonReplenish2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text");
    private SelenideElement transferPage = $("div.App_appContainer__3jRx1");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement replenishFinalButton = $("#root > div > form > button.button.button_view_extra.button_size_s.button_theme_alfa-on-white > span > span");
    private SelenideElement notificationError = $("[data-test-id='error-notification'] .notification__title");


    public void transferMoneyFrom01Cart(DataHelper.CartInfo dataHelper) {
        balance01CartBefore.shouldBe(visible);
        balance02CartBefore.shouldBe(visible);
        buttonReplenish2.click();
        transferPage.shouldBe(visible);
        amountField.setValue(String.valueOf(dataHelper.getAmount()));
        fromField.setValue(dataHelper.getCartNumber1());
        fromField.sendKeys(Keys.TAB);
        replenishFinalButton.click();
        notificationError.shouldBe(visible);
    }

    public void transferMoneyFrom02Cart(DataHelper.CartInfo dataHelper) {
        balance01CartBefore.shouldBe(visible);
        balance02CartBefore.shouldBe(visible);
        buttonReplenish1.click();
        transferPage.shouldBe(visible);
        amountField.setValue(String.valueOf(dataHelper.getAmount()));
        fromField.setValue(dataHelper.getCartNumber2());
        replenishFinalButton.click();
    }

    public void shouldNotTransferMoneyWithEmptyFields() {
        balance01CartBefore.shouldBe(visible);
        balance02CartBefore.shouldBe(visible);
        buttonReplenish2.click();
        transferPage.shouldBe(visible);
        amountField.setValue("");
        fromField.setValue("");
        replenishFinalButton.click();
    }
}
