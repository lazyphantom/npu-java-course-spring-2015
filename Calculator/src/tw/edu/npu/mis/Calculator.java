/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends Subject {

    /**
     * The available operators of the calculator.
     */
    public enum Operator {

        CLEAR, // C
        CLEAR_ENTRY, // CE
        BACKSPACE, // ?
        EQUAL, // =
        PLUS, // +
        MINUS, // -
        TIMES, // ×
        OVER, // ?
        PLUS_MINUS, // ±
        RECIPROCAL, // 1/x
        PERCENT, // %
        SQRT, // √
        MEM_CLEAR, // MC
        MEM_SET, // MS
        MEM_PLUS, // M+
        MEM_MINUS, // M-
        MEM_RECALL   // MR
    }

    private String digit, digit_temp;
    private int operationStatus;
    /**
     * 建構子 用來做初始化
     */
    public Calculator() {
        digit = "";
        digit_temp = "";
        operationStatus = 0;

    }
    /**
     * 把按鍵傳來的按鍵編號轉換為功能
     * @param index 按鍵編號
     */
    public void Convert(int index) {
        switch (index) {
            case 0:
                performOperation(Operator.MEM_CLEAR);
                break;
            case 1:
                performOperation(Operator.MEM_RECALL);
                break;
            case 2:
                performOperation(Operator.MEM_PLUS);
                break;
            case 3:
                performOperation(Operator.MEM_MINUS);
                break;
            case 4:
                performOperation(Operator.MEM_SET);
                break;
            case 5:
                performOperation(Operator.SQRT);
                break;
            case 6:
                performOperation(Operator.PERCENT);
                break;
            case 7:
                performOperation(Operator.RECIPROCAL);
                break;
            case 8:
                performOperation(Operator.CLEAR_ENTRY);
                break;
            case 9:
                performOperation(Operator.CLEAR);
                break;
            case 10:
                performOperation(Operator.BACKSPACE);
                break;
            case 11:
                operationStatus = index;
                performOperation(Operator.OVER);
                break;
            case 12:
                appendDigit(7);
                break;
            case 13:
                appendDigit(8);
                break;
            case 14:
                appendDigit(9);
                break;
            case 15:
                operationStatus = index;
                performOperation(Operator.TIMES);
                break;
            case 16:
                appendDigit(4);
                break;
            case 17:
                appendDigit(5);
                break;
            case 18:
                appendDigit(6);
                break;
            case 19:
                operationStatus = index;
                performOperation(Operator.MINUS);
                break;
            case 20:
                appendDigit(1);
                break;
            case 21:
                appendDigit(2);
                break;
            case 22:
                appendDigit(3);
                break;
            case 23:
                operationStatus = index;
                performOperation(Operator.PLUS);
                break;
            case 24:
                performOperation(Operator.PLUS_MINUS);
                break;
            case 25:
                appendDigit(0);
                break;
            case 26:
                appendDot();
                break;
            case 27:
                performOperation(Operator.EQUAL);
                break;
        }
        Notify();
    }
    /**
     * 新增數字
     * @param digit 數字 
     */
    public void appendDigit(int digit) {
        if (!this.digit.equals("0")) {
            this.digit += "" + digit;
        } else {
            this.digit = digit + "";
        }
    }
    /**
     * 新增小數點 若已有小數點則不動作
     */
    public void appendDot() {
        if (digit.indexOf(".") == -1) {
            digit += ".";
        }

    }
    /**
     * 使用運算子
     * @param operator 運算子 
     */
    public void performOperation(Operator operator) {
        switch (operator) {
            case MEM_CLEAR:
                break;
            case MEM_RECALL:
                break;
            case MEM_PLUS:
                break;
            case MEM_MINUS:
                break;
            case MEM_SET:
                break;
            case SQRT:
                digit = Math.sqrt(Double.valueOf(digit)) + "";
                deleteLastDotZero();
                break;
            case PERCENT:
                digit = Double.valueOf(digit_temp) / 100 * Double.valueOf(digit) + "";
                deleteLastDotZero();
                break;
            case RECIPROCAL:
                digit = 1 / Double.valueOf(digit) + "";
                deleteLastDotZero();
                break;
            case CLEAR_ENTRY:
                digit = "";
                break;
            case CLEAR:
                digit_temp = "";
                digit = "";
                break;
            case BACKSPACE:
                if (digit.length() > 0) {
                    if (digit.length() != 1 && digit.length() - digit.indexOf(".") == 2) {
                        digit = digit.substring(0, digit.length() - 2);
                    } else {
                        digit = digit.substring(0, digit.length() - 1);
                    }
                }
                break;
            case OVER:
                equal();
                digit_temp = digit;
                digit = "";
                break;
            case TIMES:
                equal();
                digit_temp = digit;
                digit = "";
                break;
            case MINUS:
                equal();
                digit_temp = digit;
                digit = "";
                break;
            case PLUS:
                equal();
                digit_temp = digit;
                digit = "";
                break;
            case PLUS_MINUS:
                if (!(digit.equals("0") | digit.equals(""))) {
                    if (digit.indexOf("-") == -1) {
                        digit = "-" + digit;
                    } else {
                        digit = digit.substring(1, digit.length());
                    }

                }
                break;
            case EQUAL:
                equal();
                digit_temp = "";
                break;
        }
    }
    /**
     * 回傳數值以供顯示
     * @return 數值
     */
    public String getDisplay() {
        return digit;
    }
    /**
     * 等於 做運算用
     * 加減乘除的運算都在這邊執行
     */
    private void equal() {
        if (digit.equals("") || digit_temp.equals("")) {
            return;
        }
        switch (operationStatus) {
            case 11:
                digit = (Double.valueOf(digit_temp) / Double.valueOf(digit)) + "";
                break;
            case 15:
                digit = (Double.valueOf(digit_temp) * Double.valueOf(digit)) + "";
                break;
            case 19:
                digit = (Double.valueOf(digit_temp) - Double.valueOf(digit)) + "";
                break;
            case 23:
                digit = (Double.valueOf(digit_temp) + Double.valueOf(digit)) + "";
                break;
        }
        deleteLastDotZero();
    }

    /**
     * 刪除最後面的.0
     * 若數字最後有.0的話就把他刪除
     */
    private void deleteLastDotZero() {
        if (digit.length() != 1 && digit.length() - digit.indexOf(".0") == 2) {
            digit = digit.substring(0, digit.length() - 2);
        }
    }
}
