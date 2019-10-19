package com.alyndroid.architecturepatternstutorialshomework.UI;


class NumbersPresenter {
    private NumbersView view;

    NumbersPresenter(NumbersView view) {
        this.view = view;
    }

    void getData(int num1, int num2) {
        int result;
        // used try-catch block in case if num2==0
        try {
            result = num1 / num2;
        } catch (ArithmeticException e) {
            result = 0;
        }
        view.onDataFound(result);
    }
}
