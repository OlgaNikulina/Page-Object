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
    private String cartNumber1;
    private String cartNumber2;
    private int balance1;
    private int balance2;
    private int amount;
  }

  public static CartInfo getBalanceBeforeTransaction(){
    int balance1 = 10000;
    int balance2 = 10000;
    return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", balance1, balance2, 100);
  }

  public static CartInfo transfer100From01Cart(){
    int amount = 100;
    int balance1 = 10000 - amount;
    int balance2 = 10000 + amount;
    return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", balance1, balance2, amount);
  }

  public static CartInfo transfer100From02Cart(){
    int amount = 100;
    int balance1 = 9900 + amount;
    int balance2 = 10100 - amount;
    return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", balance1, balance2, amount);
  }

  public static CartInfo transfer10000From01Cart(){
    int amount = 10000;
    int balance1 = 10000 - amount;
    int balance2 = 10000 + amount;
    return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", balance1, balance2, amount);
  }

  public static CartInfo transfer10000From02Cart(){
    int amount = 10000;
    int balance1 = 0 + amount;
    int balance2 = 20000 - amount;
    return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", balance1, balance2, amount);
  }

  public static CartInfo transfer0From01Cart(){
    int amount = 0;
    int balance1 = 10000 - amount;
    int balance2 = 10000 + amount;
    return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", balance1, balance2, amount);
  }

  public static CartInfo transfer0From02Cart() {
    int amount = 0;
    int balance1 = 10000 + amount;
    int balance2 = 10000 - amount;
    return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", balance1, balance2, amount);
  }
}
