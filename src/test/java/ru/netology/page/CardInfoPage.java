package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CardInfoPage {
    private SelenideElement firstCardInfo = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardInfo = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement cardsInfoPage = $("[data-test-id='dashboard']");
    private SelenideElement buttonReplenish1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text");
    private SelenideElement buttonReplenish2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text");

    public TransferMoney cardInfoPageIfReplenishFirstCard() {
        firstCardInfo.shouldBe(visible);
        secondCardInfo.shouldBe(visible);
        buttonReplenish1.click();
        return page(TransferMoney.class);
    }

    public TransferMoney cardInfoPageIfReplenishSecondCard() {
        firstCardInfo.shouldBe(visible);
        secondCardInfo.shouldBe(visible);
        buttonReplenish2.click();
        return page(TransferMoney.class);
    }

    public void cardInfoPageShouldVerify() {
        firstCardInfo.shouldBe(visible);
        secondCardInfo.shouldBe(visible);
        cardsInfoPage.shouldBe(visible);
    }

    public int getBalanceFirstCard() {
        String cardInfoString = firstCardInfo.getText();
        return Integer.parseInt(cardInfoString.substring(29, cardInfoString.indexOf(" ", 29)));
    }

    public int getBalanceSecondCard() {
        String cardInfoString = secondCardInfo.getText();
        return Integer.parseInt(cardInfoString.substring(29, cardInfoString.indexOf(" ", 29)));
    }
}
