package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

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
    public static class CartInfo {
        private String cartNumber1;
        private String cartNumber2;
        private int firstCartBalanceBeforeTransaction;
        private int firstCartBalanceAfterTransaction;
        private int secondCartBalanceBeforeTransaction;
        private int secondCartBalanceAfterTransaction;
        private int amount;
    }

    public static CartInfo transfer100From01Cart() {
        int amount = 100;
        int firstCartBalanceBeforeTransaction = 10000;
        int firstCartBalanceAfterTransaction = 10000 - amount;
        int secondCartBalanceBeforeTransaction = 10000;
        int secondCartBalanceAfterTransaction = 10000 + amount;
        return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", firstCartBalanceBeforeTransaction, firstCartBalanceAfterTransaction, secondCartBalanceBeforeTransaction, secondCartBalanceAfterTransaction, amount);
    }

    public static CartInfo transfer100From02Cart() {
        int amount = 100;
        int firstCartBalanceBeforeTransaction = 9900;
        int firstCartBalanceAfterTransaction = 9900 + amount;
        int secondCartBalanceBeforeTransaction = 10100;
        int secondCartBalanceAfterTransaction = 10100 - amount;
        return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", firstCartBalanceBeforeTransaction, firstCartBalanceAfterTransaction, secondCartBalanceBeforeTransaction, secondCartBalanceAfterTransaction, amount);
    }

    public static CartInfo transfer10000From01Cart() {
        int amount = 10000;
        int firstCartBalanceBeforeTransaction = 10000;
        int firstCartBalanceAfterTransaction = 10000 - amount;
        int secondCartBalanceBeforeTransaction = 10000;
        int secondCartBalanceAfterTransaction = 10000 + amount;
        return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", firstCartBalanceBeforeTransaction, firstCartBalanceAfterTransaction, secondCartBalanceBeforeTransaction, secondCartBalanceAfterTransaction, amount);
    }

    public static CartInfo transfer10000From02Cart() {
        int amount = 10000;
        int firstCartBalanceBeforeTransaction = 0;
        int firstCartBalanceAfterTransaction = 0 + amount;
        int secondCartBalanceBeforeTransaction = 20000;
        int secondCartBalanceAfterTransaction = 20000 - amount;
        return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", firstCartBalanceBeforeTransaction, firstCartBalanceAfterTransaction, secondCartBalanceBeforeTransaction, secondCartBalanceAfterTransaction, amount);
    }

    public static CartInfo transfer0From01Cart() {
        int amount = 0;
        int firstCartBalanceBeforeTransaction = 10000;
        int firstCartBalanceAfterTransaction = 10000 + amount;
        int secondCartBalanceBeforeTransaction = 10000;
        int secondCartBalanceAfterTransaction = 10000 - amount;
        return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", firstCartBalanceBeforeTransaction, firstCartBalanceAfterTransaction, secondCartBalanceBeforeTransaction, secondCartBalanceAfterTransaction, amount);
    }

    public static CartInfo transfer0From02Cart() {
        int amount = 0;
        int firstCartBalanceBeforeTransaction = 10000;
        int firstCartBalanceAfterTransaction = 10000 - amount;
        int secondCartBalanceBeforeTransaction = 10000;
        int secondCartBalanceAfterTransaction = 10000 + amount;
        return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002", firstCartBalanceBeforeTransaction, firstCartBalanceAfterTransaction, secondCartBalanceBeforeTransaction, secondCartBalanceAfterTransaction, amount);
    }
}
