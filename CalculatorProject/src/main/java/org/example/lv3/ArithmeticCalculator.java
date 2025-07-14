package org.example.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T> {
    private List<T> calculatorList = new ArrayList<>();
    private Number result;

    public <T extends Number> List<T> getNumberMaxList(int number, List<T> operationRequestList) {

        if (operationRequestList.isEmpty()) {
            throw new NoSuchElementException("List가 비어있습니다.");
        }else {
            List<T> maxList = operationRequestList.stream().filter(list -> list.doubleValue() > number).collect(Collectors.toList());
            System.out.println("결과: " + maxList);
            return maxList;
        }
    }


    public <S extends Number> Number calculate(S num1, S num2, OperatorType operation) {
        if (operation == OperatorType.DIV && num2.doubleValue() == 0.0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
        }
        return result = switch (operation) {
            case SUM -> num1.doubleValue() + num2.doubleValue();
            case SUB -> num1.doubleValue() - num2.doubleValue();
            case MUI -> num1.doubleValue() * num2.doubleValue();
            case DIV -> num1.doubleValue() / num2.doubleValue();
        };
    }

    public Number removeResult() {
        if (!calculatorList.isEmpty()) {
            calculatorList.remove(0);
        }
        return result;
    }


    public List<T> getCalculatorList() {
        System.out.println("연산 누적 결과: " + calculatorList);
        return calculatorList;
    }

    public void setCalculatorList(List<T> calculatorList) {
        this.calculatorList = calculatorList;
    }
}
