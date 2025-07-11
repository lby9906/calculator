package org.example.lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        List<Integer> calculatorList = new ArrayList<>();
        Calculator2 calculator123 = new Calculator2();

        Scanner in = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        char operation;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            while (true) {
                try {
                    num1 = Integer.parseInt(in.next());
                    if (num1 < 0) {
                        System.out.println("양의 정수만 입력 가능합니다.");
                        System.out.print("첫 번째 숫자를 입력하세요: ");
                        continue;
                    }
                    break;
                } catch (NumberFormatException | InputMismatchException e) {
                    System.out.println("정수 외엔 다른 것은 입력할 수 없습니다.");
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                }
            }


            System.out.print("두 번째 숫자를 입력하세요: ");
            while (true) {
                try {
                    num2 = Integer.parseInt(in.next());
                    if (num2 < 0) {
                        System.out.println("양의 정수만 입력 가능합니다.");
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        continue;
                    }
                    break;
                } catch (NumberFormatException | InputMismatchException e) {
                    System.out.println("정수 외엔 다른 것은 입력 할 수 없습니다.");
                    System.out.print("두 번째 숫자를 입력하세요: ");
                }
            }


            System.out.print("사칙 연산 기호를 입력하세요(+, -, *, /): ");
            operation = in.next().charAt(0);

            while (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                System.out.println("올바른 사칙 연산 기호가 아닙니다.");
                System.out.print("사칙 연산 기호를 입력하세요(+, -, *, /): ");
                operation = in.next().charAt(0);
            }

            int result = switch (operation) {
                case '+' -> calculator123.plus(num1, num2, operation);
                case '-' -> calculator123.minus(num1, num2, operation);
                case '*' -> calculator123.multiplied(num1, num2, operation);
                case '/' -> calculator123.divided(num1, num2, operation);
                default -> throw new IllegalStateException("switch에 도달할 수 없는 연산자입니다.");
            };
            System.out.println("계산 결과: " + result);
            calculatorList.add(result);
            calculator123.setArrayList(calculatorList);

            System.out.println("더 계산하시겠습니까?(y/exit): ");
            String type = in.next();
            if (type.equals("exit")) {
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }
        }
        calculator123.getArrayList();

        System.out.println();

        System.out.println(":::가장 먼저 저장된 데이터 삭제:::");
        calculator123.removeResult();
        calculator123.getArrayList();
    }
}
