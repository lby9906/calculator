package org.example.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> arrayList = new ArrayList<>();
    int result;

    public int plus(int num1, int num2, char operation) {
        if (operation == '+') {
            int result = num1 + num2;
            arrayList.add(num1+num2);
            System.out.println("결과: " + result);
        }
        return result;
    }

    public int minus(int num1, int num2, char operation) {
        if (operation == '-') {
            result = num1 - num2;
            arrayList.add(result);
            System.out.println("결과: " + result);
        }
        return result;
    }

    public int multiplied(int num1, int num2, char operation) {
        if (operation == '*') {
            result = num1 * num2;
            arrayList.add(result);
            System.out.println("결과: " + result);
        }
        return result;
    }

    public int divided(int num1, int num2, char operation) {
        if (operation == '/') {
            if (num2 == 0) {
                System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
            } else {
                result = num1 / num2;
                arrayList.add(result);
                System.out.println("결과: " + result);
            }
        }
        return result;
    }

    public void removeResult() {
        if (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
    }

    public List<Integer> getArrayList() {
        System.out.println("연산 누적 결과: " + arrayList);
        return arrayList;
    }

    public void setArrayList(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }
}
