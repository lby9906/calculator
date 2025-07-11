package org.example.lv3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Number> calculatorList = new ArrayList<>();
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        Number num1, num2;
        OperatorType operation;
        String oper;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            while (true) {
                try {
                    String setInput1 = in.next();
                    num1 = Double.parseDouble(setInput1);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("정수,실수 외엔 다른 것은 입력할 수 없습니다.");
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                }
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            while (true) {
                try {
                    String strInput2 = in.next();
                    num2 = Double.parseDouble(strInput2);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("정수,실수 외엔 다른 것은 입력 할 수 없습니다.");
                    System.out.print("두 번째 숫자를 입력하세요: ");
                }
            }


            System.out.print("사칙 연산 기호를 입력하세요(+, -, *, /): ");
            oper = in.next();
            operation = OperatorType.fromContent(oper);


            while (operation != OperatorType.SUM && operation != OperatorType.SUB && operation != OperatorType.MUI && operation != OperatorType.DIV) {
                System.out.println("올바른 사칙 연산 기호가 아닙니다.");
                System.out.print("사칙 연산 기호를 입력하세요(+, -, *, /): ");
                oper = in.next();
                operation = OperatorType.fromContent(oper);
            }

            Number calculate = calculator.calculate(num1, num2, operation);


            System.out.println("계산 결과: " + calculate);
            calculatorList.add(calculate);
            calculator.setCalculatorList(calculatorList);

            System.out.println("더 계산하시겠습니까?(y/exit): ");
            String type = in.next();
            if (type.equals("exit")) {
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }
        }
        calculator.getCalculatorList();

        System.out.println();

        System.out.println(":::가장 먼저 저장된 데이터 삭제:::");
        calculator.removeResult();
        List calculatorListResult = calculator.getCalculatorList();

        System.out.println();

        System.out.println("::: 입력받은 값보다 큰 결과값을 출력 :::");
        System.out.print("정수를 입력해주세요: ");
        int number = in.nextInt();

        calculator.getNumberMaxList(number, calculatorListResult);
    }
}
