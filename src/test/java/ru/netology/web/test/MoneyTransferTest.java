package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.page.LoginPageV2;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {
    @Test
    void shouldTransfer100From01Cart() {
        open("http://localhost:9999");
        val loginPage = new LoginPageV2();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DataHelper.CartInfo dataHelper = DataHelper.transfer100From01Cart();
        loginPage.transferMoneyFrom01Cart(dataHelper);
    }

    @Test
    void shouldTransfer100From02Cart() {
        open("http://localhost:9999");
        val loginPage = new LoginPageV2();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DataHelper.CartInfo dataHelper = DataHelper.transfer100From02Cart();
        loginPage.transferMoneyFrom02Cart(dataHelper);
    }
}
