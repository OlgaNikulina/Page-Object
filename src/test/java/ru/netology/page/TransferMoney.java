package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferMoney {
    private SelenideElement transferPage = $("div.App_appContainer__3jRx1");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement replenishFinalButton = $("[data-test-id='action-transfer']");
    private SelenideElement notificationError = $("[data-test-id='error-notification'] .notification__title");

    public void transferMoneyFromFirstCart(DataHelper.CardInfo cardsInfo, int amountToTransfer) {
        transferPage.shouldBe(visible);
        amountField.setValue(String.valueOf(amountToTransfer));
        fromField.setValue(cardsInfo.getCartNumber1());
        fromField.sendKeys(Keys.TAB);
        replenishFinalButton.click();
    }

    public void transferMoneyFromSecondCart(DataHelper.CardInfo cardsInfo, int amountToTransfer) {
        transferPage.shouldBe(visible);
        amountField.setValue(String.valueOf(amountToTransfer));
        fromField.setValue(cardsInfo.getCartNumber2());
        fromField.sendKeys(Keys.TAB);
        replenishFinalButton.click();
    }

    public void shouldNotTransferMoneyWithEmptyFields() {
        transferPage.shouldBe(visible);
        amountField.setValue("");
        fromField.setValue("");
        fromField.sendKeys(Keys.TAB);
        replenishFinalButton.click();
        notificationError.shouldBe(visible);
    }
}
