package org.example.lv3;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp3 {
    public static void main(String[] args) {
        List<Number> calculatorList = new ArrayList<>();
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        Scanner in = new Scanner(System.in);
        Number num1 = 0;
        Number num2 = 0;
        OperatorType operation;
        String oper;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            while (true) {
                String strInput1 = in.next();
                try {
                    num1 = Integer.parseInt(strInput1);
                    break;
                } catch (NumberFormatException | InputMismatchException e) {
                    try {
                        num1 = Double.parseDouble(strInput1);
                        break;
                    }catch (NumberFormatException ex) {

                        System.out.println("정수,실수 외엔 다른 것은 입력할 수 없습니다.");
                        System.out.print("첫 번째 숫자를 입력하세요: ");
                    }
                }
            }


            System.out.print("두 번째 숫자를 입력하세요: ");
            while (true) {
                String strInput2 = in.next();
                try {
                    num2 = Integer.parseInt(strInput2);
                    break;
                } catch (NumberFormatException | InputMismatchException e) {
                    try {
                        num2 = Double.parseDouble(strInput2);
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("정수,실수 외엔 다른 것은 입력 할 수 없습니다.");
                        System.out.print("두 번째 숫자를 입력하세요: ");
                    }
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
        calculator.getCalculatorList();
        calculator.getCalculatorList();
    }
}
