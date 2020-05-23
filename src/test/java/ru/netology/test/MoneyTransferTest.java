package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CardInfoPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferMoney;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {

    @Test
    void shouldTransfer100From01Cart() {
        int amount = 100;
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor();
        val cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        val transferMoney = cardInfoPage.cardInfoPageIfReplenishSecondCard();
        DataHelper.CardInfo cardInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromFirstCart(cardInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction - amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction + amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldTransfer100From02Cart() {
        int amount = 100;
        LoginPage loginPage = open("http://localhost:9999", LoginPage.class);
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = loginPage.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor();
        CardInfoPage cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        TransferMoney transferMoney = cardInfoPage.cardInfoPageIfReplenishFirstCard();
        DataHelper.CardInfo cardsInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromSecondCart(cardsInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction + amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction - amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldTransfer10000From01Cart() {
        int amount = 1000;
        LoginPage loginPage = open("http://localhost:9999", LoginPage.class);
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = loginPage.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor();
        CardInfoPage cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        TransferMoney transferMoney = cardInfoPage.cardInfoPageIfReplenishSecondCard();
        DataHelper.CardInfo cardsInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromFirstCart(cardsInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction - amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction + amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldTransfer10000From02Cart() {
        int amount = 1000;
        LoginPage loginPage = open("http://localhost:9999", LoginPage.class);
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = loginPage.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor();
        CardInfoPage cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        TransferMoney transferMoney = cardInfoPage.cardInfoPageIfReplenishFirstCard();
        DataHelper.CardInfo cardsInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromSecondCart(cardsInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction + amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction - amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldTransfer0From01Cart() {
        int amount = 0;
        LoginPage loginPage = open("http://localhost:9999", LoginPage.class);
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = loginPage.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor();
        CardInfoPage cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        TransferMoney transferMoney = cardInfoPage.cardInfoPageIfReplenishSecondCard();
        DataHelper.CardInfo cardsInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromFirstCart(cardsInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction - amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction + amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldTransfer0From02Cart() {
        int amount = 0;
        LoginPage loginPage = open("http://localhost:9999", LoginPage.class);
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = loginPage.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor();
        CardInfoPage cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        TransferMoney transferMoney = cardInfoPage.cardInfoPageIfReplenishFirstCard();
        DataHelper.CardInfo cardsInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromSecondCart(cardsInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction - amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction + amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldNotTransferMoneyWithEmptyFields() {
        LoginPage loginPage = open("http://localhost:9999", LoginPage.class);
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        VerificationPage verificationPage = loginPage.validLogin(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor();
        CardInfoPage cardInfoPage = verificationPage.validVerify(verificationCode);
        TransferMoney transferMoney = cardInfoPage.cardInfoPageIfReplenishFirstCard();
        transferMoney.shouldNotTransferMoneyWithEmptyFields();
    }
}
