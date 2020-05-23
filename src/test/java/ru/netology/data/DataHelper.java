package ru.netology.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   @Value
    public static class AuthInfo {
       private String login;
       private String password;
   }

    public static AuthInfo getAuthInfo(AuthInfo original) {
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
