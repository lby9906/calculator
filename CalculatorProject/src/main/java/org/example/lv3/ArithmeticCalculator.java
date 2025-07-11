package org.example.lv3;

import java.util.ArrayList;
import java.util.List;

public class Calculator3<T> {
    private List<T> arrayList = new ArrayList<>();
    private Number result;

    public <S extends Number> Number calculate(S num1, S num2, OperatorType operation) {
        return result = switch (operation) {
            case SUM -> num1.doubleValue() + num2.doubleValue();
            case SUB -> num1.doubleValue() - num2.doubleValue();
            case MUI -> num1.doubleValue() * num2.doubleValue();
            case DIV -> num1.doubleValue() / num2.doubleValue();
        };
    }

    public Number removeResult() {
        if (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        return result;
    }


    public List<T> getArrayList() {
        System.out.println("연산 누적 결과: " + arrayList);
        return arrayList;
    }

    public void setArrayList(List<T> arrayList) {
        this.arrayList = arrayList;
    }
}
