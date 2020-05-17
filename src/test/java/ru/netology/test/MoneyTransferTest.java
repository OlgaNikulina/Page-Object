package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.page.CartInfoPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferMoney;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {
    @Test
    void shouldTransfer100From01Cart() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DataHelper.CartInfo dataHelper = DataHelper.transfer100From01Cart();
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.transferMoneyFrom01Cart(dataHelper);
        CartInfoPage cartInfoPage = new CartInfoPage();
        cartInfoPage.cartInfoPageShouldVerify();
    }

    @Test
    void shouldTransfer100From02Cart() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DataHelper.CartInfo dataHelper = DataHelper.transfer100From02Cart();
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.transferMoneyFrom02Cart(dataHelper);
        CartInfoPage cartInfoPage = new CartInfoPage();
        cartInfoPage.cartInfoPageShouldVerify();
    }

    @Test
    void shouldTransfer10000From01Cart() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DataHelper.CartInfo dataHelper = DataHelper.transfer10000From01Cart();
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.transferMoneyFrom01Cart(dataHelper);
        CartInfoPage cartInfoPage = new CartInfoPage();
        cartInfoPage.cartInfoPageShouldVerify();
    }

    @Test
    void shouldTransfer10000From02Cart() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DataHelper.CartInfo dataHelper = DataHelper.transfer10000From02Cart();
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.transferMoneyFrom02Cart(dataHelper);
        CartInfoPage cartInfoPage = new CartInfoPage();
        cartInfoPage.cartInfoPageShouldVerify();
    }

    @Test
    void shouldTransfer0From01Cart() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DataHelper.CartInfo dataHelper = DataHelper.transfer0From01Cart();
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.transferMoneyFrom01Cart(dataHelper);
        CartInfoPage cartInfoPage = new CartInfoPage();
        cartInfoPage.cartInfoPageShouldVerify();
    }

    @Test
    void shouldTransfer0From02Cart() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DataHelper.CartInfo dataHelper = DataHelper.transfer0From02Cart();
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.transferMoneyFrom02Cart(dataHelper);
        CartInfoPage cartInfoPage = new CartInfoPage();
        cartInfoPage.cartInfoPageShouldVerify();
    }

    @Test
    void shouldNotTransferMoneyWithEmptyFields() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.shouldNotTransferMoneyWithEmptyFields();
    }
}
