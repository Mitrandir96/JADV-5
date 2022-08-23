import org.junit.jupiter.api.*;
import ru.netology.CalcCredit;

import java.util.Random;

public class Test {

    @BeforeAll
    public static void initSuite() {
        System.out.println("Tests started");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new Test");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete");
    }

    @AfterAll
    public static void completeSuit() {
        System.out.println("Tests complete");
    }

    Random random = new Random();

    @org.junit.jupiter.api.Test
    public void testMonthlyPayment() {
        CalcCredit calcCredit = new CalcCredit();
        int amount = random.nextInt();
        int month = random.nextInt(100000);
        double rate = random.nextDouble();
        double annuityRatio = (rate / 100 / 12 * Math.pow((1 + rate / 100 / 12), month)) / (Math.pow((1 + rate / 100 / 12), month) - 1);
        double monthlyPayment = calcCredit.monthlyPayment(amount, month, rate);
        Assertions.assertTrue(amount * annuityRatio == monthlyPayment, "Неверный расчет ежемесячного платежа");
    }

    @org.junit.jupiter.api.Test
    public void AmountReturn() {
        CalcCredit calcCredit = new CalcCredit();
        int amount = random.nextInt();
        int month = random.nextInt(100000);
        double rate = random.nextDouble();
        double amountReturn = calcCredit.amountReturn(amount, month, rate);
        Assertions.assertTrue(amount * (rate / 100 / 12 * Math.pow((1 + rate / 100 / 12), month)) /
                (Math.pow((1 + rate / 100 / 12), month) - 1) * month == amountReturn, "Неверный расчет суммы к возврату");
    }

    @org.junit.jupiter.api.Test
    public void OverPayment() {
        CalcCredit calcCredit = new CalcCredit();
        int amount = random.nextInt();
        int month = random.nextInt(100000);
        double rate = random.nextDouble();
        double overPayment = calcCredit.overPayment(amount, month, rate);
        Assertions.assertTrue(amount * (rate / 100 / 12 * Math.pow((1 + rate / 100 / 12), month)) /
                (Math.pow((1 + rate / 100 / 12), month) - 1) * month - amount == overPayment, "Неверный расчет суммы переплаты");


    }

}
