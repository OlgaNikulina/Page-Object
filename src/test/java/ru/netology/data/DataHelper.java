package ru.netology.data;

import lombok.Value;
import lombok.val;

public class DataHelper {
    private DataHelper() {
    }

   @Value
    public static class AuthInfo {
        private String login;
        private String password;

       public String getLogin() {
           return null;
       }

       public String getPassword() {
           return null;
       }
   }

    public static val getAuthInfo() {
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

        public CartInfo(String s, String s1) {
        }

        public String getCardNumber1() {
            return null;
        }

        public String getCardNumber2() {
            return null;
        }
    }

    public static CartInfo getCardsInfo() {
        return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002");
    }
}
