package com.alyndroid.architecturepatternstutorialshomework.Data;

public class NumberModel {
    private int firstNum, secondNum;

    NumberModel(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public int getFirstNum() {
        return firstNum;
    }
    public int getSecondNum() {
        return secondNum;
    }
}
