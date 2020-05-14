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
  private SelenideElement buttonReplenish = $("span.button__text");
  private SelenideElement transferPage = $("div.App_appContainer__3jRx1");
  private SelenideElement amountField = $("[data-test-id='amount'] input");
  private SelenideElement fromField = $("[data-test-id='from'] input");
  private SelenideElement replenishFinalButton = $$("button").find(exactText("пополнить"));
  private SelenideElement cartsInfoPage = $("div.App_appContainer__3jRx1");


  public VerificationPage validLogin(DataHelper.AuthInfo info) {
    loginField.setValue(info.getLogin());
    passwordField.setValue(info.getPassword());
    loginButton.click();
    buttonContinue.click();
    return new VerificationPage();
  }

  public DataHelper transferMoneyBetweenCart(DataHelper.CartInfo dataHelper) {
    buttonReplenish.click();
    transferPage.shouldBe(visible);
    amountField.setValue(String.valueOf(dataHelper.getAmount()));
    fromField.setValue(dataHelper.getCartNumber1());
    replenishFinalButton.click();
    cartsInfoPage.shouldBe(visible);
    return (DataHelper) cartsInfoPage;
  }
}
