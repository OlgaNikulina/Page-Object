package ru.netology.data;

public class DataHelper {
    private DataHelper() {
    }

    public static class AuthInfo {
        private String login;
        private String password;

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public AuthInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static class VerificationCode {
        private String code;

        public String getCode() {
            return code;
        }

        public VerificationCode(String code) {
            this.code = code;
        }
    }

    public static VerificationCode getVerificationCodeFor() {
        return new VerificationCode("12345");
    }

    public static class CartInfo {
        private String cartNumber1;
        private String cartNumber2;

        public String getCartNumber1() {
            return cartNumber1;
        }


        public String getCartNumber2() {
            return cartNumber2;
        }

        public CartInfo(String cartNumber1, String cartNumber2) {
            this.cartNumber1 = cartNumber1;
            this.cartNumber2 = cartNumber2;
        }
    }

    public static CartInfo getCardsInfo() {
        return new CartInfo("5559 0000 0000 0001", "5559 0000 0000 0002");
    }
}
