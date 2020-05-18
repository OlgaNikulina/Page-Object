package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferMoney {
    private SelenideElement firstCardInfo = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardInfo = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement transferPage = $("div.App_appContainer__3jRx1");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement replenishFinalButton = $("[data-test-id='action-transfer']");
    private SelenideElement notificationError = $("[data-test-id='error-notification'] .notification__title");

    public int getBalanceFirstCardBeforeTransaction(){
        String cardInfoString = firstCardInfo.getText();
        return Integer.parseInt(cardInfoString.substring(29,cardInfoString.indexOf(" ",29)));
    }

    public int getBalanceSecondCardBeforeTransaction(){
        String cardInfoString = secondCardInfo.getText();
        return  Integer.parseInt(cardInfoString.substring(29, cardInfoString.indexOf(" ", 29)));
    }

    public void transferMoneyFrom01Cart(DataHelper.CartInfo dataHelper) {
        transferPage.shouldBe(visible);
        amountField.setValue(String.valueOf(dataHelper.getAmount()));
        fromField.setValue(dataHelper.getCartNumber1());
        fromField.sendKeys(Keys.TAB);
        replenishFinalButton.click();
    }

    public void transferMoneyFrom02Cart(DataHelper.CartInfo dataHelper) {
        transferPage.shouldBe(visible);
        amountField.setValue(String.valueOf(dataHelper.getAmount()));
        fromField.setValue(dataHelper.getCartNumber2());
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
