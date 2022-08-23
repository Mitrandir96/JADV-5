package ru.netology;

public class CalcCredit {

    public static double monthlyPayment (int amount, int month, double rate) {
        return amount * (rate / 100 / 12 * Math.pow((1 + rate / 100 / 12), month)) / (Math.pow((1 + rate / 100 / 12), month) - 1);
    }

    public static double amountReturn (int amount, int month, double rate) {
        return amount * (rate / 100 / 12 * Math.pow((1 + rate / 100 / 12), month)) /
                (Math.pow((1 + rate / 100 / 12), month) - 1) * month;
    }

    public static double overPayment (int amount, int month, double rate) {
        return amount * (rate / 100 / 12 * Math.pow((1 + rate / 100 / 12), month)) /
                (Math.pow((1 + rate / 100 / 12), month) - 1) * month - amount;
    }
}
