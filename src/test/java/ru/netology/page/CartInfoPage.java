package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartInfoPage {
    private SelenideElement balance01CartAfter = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement balance02CartAfter = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement cartsInfoPage = $("[data-test-id='dashboard']");

    public void cartInfoPageShouldVerify() {
        balance01CartAfter.shouldBe(visible);
        balance02CartAfter.shouldBe(visible);
        cartsInfoPage.shouldBe(visible);
    }
}
