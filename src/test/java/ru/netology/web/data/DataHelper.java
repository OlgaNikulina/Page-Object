package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
  private DataHelper() {}

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  public static AuthInfo getAuthInfo() {
    return new AuthInfo("vasya", "qwerty123");
  }

  public static AuthInfo getOtherAuthInfo(AuthInfo original) {
    return new AuthInfo("petya", "123qwerty");
  }

  @Value
  public static class VerificationCode {
    private String code;
  }

  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
    return new VerificationCode("12345");
  }

  @Value
  public static class CartInfo{
    private String cartNumber;
    private String balance;
    private String amount;
  }

  public static CartInfo transferMoney(){
return new CartInfo("5559 0000 0000 0001", "10 000 RUB", "100" );
  }

  public static CartInfo getBalance1(){
    return new CartInfo("5559 0000 0000 0001", "10 000 RUB", "100");
  }

  public static CartInfo getBalance2(){
    return new CartInfo("5559 0000 0000 0002", "10 000 RUB", "100");
  }
}
