package org.example.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> arrayList = new ArrayList<>();
    private int result;

    public int plus(int num1, int num2, char operation) {
        if (operation == '+') {
            return num1 + num2;
        }
        return 0;
    }

    public int minus(int num1, int num2, char operation) {
        if (operation == '-') {
            return num1 - num2;
        }
        return 0;
    }

    public int multiplied(int num1, int num2, char operation) {
        if (operation == '*') {
            return num1 * num2;
        }
        return 0;
    }

    public int divided(int num1, int num2, char operation) {
        if (operation == '/') {
            while (true){
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    return 0;
                } else {
                    return num1 / num2;
                }
            }
        }
        return 0;
    }

    public int removeResult() {
        if (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        return result;
    }

    public List<Integer> getArrayList() {
        System.out.println("연산 누적 결과: " + arrayList);
        return arrayList;
    }

    public void setArrayList(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }
}
