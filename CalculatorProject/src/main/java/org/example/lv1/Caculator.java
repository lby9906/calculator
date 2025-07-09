package org.example.lv1;

import java.util.Scanner;

public class Caculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result, num1, num2 = 0;
        char operation;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = in.nextInt();
            while (num1 < 0) {
                System.out.println("양의 정수만 입력 가능합니다.");
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = in.nextInt();
            }


            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = in.nextInt();
            while (num2 < 0) {
                System.out.println("양의 정수만 입력 가능합니다.");
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = in.nextInt();
            }


            System.out.print("사칙 연산 기호를 입력하세요(+, -, *, /): ");
            operation = in.next().charAt(0);

            while (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                System.out.println("올바른 사칙 연산 기호가 아닙니다.");
                System.out.print("사칙 연산 기호를 입력하세요(+, -, *, /): ");
                operation = in.next().charAt(0);
            }

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    System.out.println("결과: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("결과: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("결과: " + result);
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    } else {
                        result = num1 / num2;
                        System.out.println("결과: " + result);
                        break;
                    }
            }
            System.out.println("더 계산하시겠습니까?(y/exit): ");
            String type = in.next();
            if (type.equals("exit")) {
                break;
            }
        }
    }
}
