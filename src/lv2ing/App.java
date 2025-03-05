package lv2ing;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                // 내용 입력
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = scanner.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = scanner.nextInt();

                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                String operator = scanner.next();

                // Calculator 클래스를 사용하여 결과가 자동으로 저장됨
                int result = calculator.calculate(num1, num2, operator);
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                continue;
            } catch (Exception e) {
                System.out.println("오류: 숫자를 올바르게 입력하세요.");
                scanner.nextLine(); // 입력 초기화
                continue;
            }

            // 종료 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, 계속 진행을 원할 시 아무거나 입력)");
            String exit = scanner.next();
            if (exit.equalsIgnoreCase("exit")) {
                // equalsIgnoreCase 대소문자 구분 없이 문자열 비교
                // equals 대소문자 구분 하여 문자열 비교
                // 문자열이 같은 경우 true, 다른 경우 false
                running = false;
            }
        }
        // 결과 출력
        System.out.println("현재까지 계산된 결과 목록: " + calculator.getResults());
        System.out.println("계산기를 종료합니다.");
    }
}