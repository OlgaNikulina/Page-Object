package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.page.CardInfoPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferMoney;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {

    @Test
    void shouldTransfer100From01Cart() {
        int amount = 100;
        val loginPage = (val) open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        val transferMoney = cardInfoPage.cardInfoPageIfReplenishSecondCard();
        DataHelper.CartInfo cardsInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromFirstCart(cardsInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction - amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction + amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldTransfer100From02Cart() {
        int amount = 100;
        val loginPage = (val) open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        val transferMoney = cardInfoPage.cardInfoPageIfReplenishFirstCard();
        DataHelper.CartInfo cardsInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromSecondCart(cardsInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction - amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction + amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldTransfer10000From01Cart() {
        int amount = 1000;
        val loginPage = (val) open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        val transferMoney = cardInfoPage.cardInfoPageIfReplenishSecondCard();
        DataHelper.CartInfo cardsInfo = DataHelper.getCardsInfo();
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
        val loginPage = (val) open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        val transferMoney = cardInfoPage.cardInfoPageIfReplenishFirstCard();
        DataHelper.CartInfo cardsInfo = DataHelper.getCardsInfo();
        transferMoney.transferMoneyFromSecondCart(cardsInfo, amount);
        cardInfoPage.cardInfoPageShouldVerify();
        int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction - amount;
        int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction + amount;
        Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
        Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
    }

    @Test
    void shouldTransfer0From01Cart() {
        int amount = 0;
        val loginPage = (val) open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        val transferMoney = cardInfoPage.cardInfoPageIfReplenishSecondCard();
        DataHelper.CartInfo cardsInfo = DataHelper.getCardsInfo();
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
            val loginPage = (val) open("http://localhost:9999", LoginPage.class);
            val authInfo = DataHelper.getAuthInfo();
            val verificationPage = loginPage.validLogin(authInfo);
            val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
            val cardInfoPage = verificationPage.validVerify(verificationCode);
            int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
            int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
            val transferMoney = cardInfoPage.cardInfoPageIfReplenishFirstCard();
            DataHelper.CartInfo cardsInfo = DataHelper.getCardsInfo();
            transferMoney.transferMoneyFromSecondCart(cardsInfo, amount);
            cardInfoPage.cardInfoPageShouldVerify();
            int balanceFirstCardAfterTransaction = balanceFirstCardBeforeTransaction - amount;
            int balanceSecondCardAfterTransaction = balanceSecondCardBeforeTransaction + amount;
            Assertions.assertEquals(balanceFirstCardAfterTransaction, cardInfoPage.getBalanceFirstCard());
            Assertions.assertEquals(balanceSecondCardAfterTransaction, cardInfoPage.getBalanceSecondCard());
        }

    @Test
    void shouldNotTransferMoneyWithEmptyFields() {
        val loginPage = (val) open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val cardInfoPage = verificationPage.validVerify(verificationCode);
        int balanceFirstCardBeforeTransaction = cardInfoPage.getBalanceFirstCard();
        int balanceSecondCardBeforeTransaction = cardInfoPage.getBalanceSecondCard();
        val transferMoney = cardInfoPage.cardInfoPageIfReplenishFirstCard();
        DataHelper.CartInfo cardsInfo = DataHelper.getCardsInfo();
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.shouldNotTransferMoneyWithEmptyFields();
    }
}
