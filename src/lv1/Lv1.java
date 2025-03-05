package lv1;

import java.util.Scanner;

public class Lv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean calculator = true;

        do{
            calculator = true; // 해당 변수가 없으면 계산이 완료됨에도 종료되지 않고 계속됨. 왜?
            try{
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                long num1 = scanner.nextLong();

                System.out.print("연산자(+, -, *, /)를 입력하세요 : ");
                String operator = scanner.next();

                System.out.print("두 번째 숫자를 입력하세요 : ");
                long num2 = scanner.nextLong();

                long result = 0; // 왜 result 값을 0으로 줘야지 오류가 안나지?

                switch (operator) {
                    case "+" :
                        result = num1 + num2;
                        break;
                    case "-" :
                        result = num1 - num2;
                        break;
                    case "*" :
                        result = num1 * num2;
                        break;
                    case "/" :
                        if (num2 == 0) {
                            System.out.println("오류 : 정의되지 않은 계산입니다.");
                            System.out.println("0외에 다른 숫자를 입력해주세요.");
                            calculator = false;
                            continue;
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default:
                        System.out.println("오류 : 잘못된 연산자 입니다.");
                        calculator = false;
                        continue;
                }
                System.out.println(num1 + " " + operator +" "+ num2 + " = " + result + " 입니다.");
            } catch (Exception e1) {
                System.out.println("오류 : 숫자를 입력해주세요");
                scanner.nextLine(); // 입력 버퍼 초기화
                calculator = false;
            }

            // 계산기 종료
            System.out.println("계산기를 종료하시겠습니까? (yes/no)");
            String exit = scanner.next();
            switch (exit){
                case "yes":
                    System.out.println("계산기를 종료합니다.");
                    break;
                case "no" :
                    calculator = false;
                    continue;
                default:
                    System.out.println("오류 : yes 혹은 no로 입력해주세요.");
                    exit = scanner.next();
                    if (exit.equals("no")) {
                        calculator = false;
                    } else {
                        System.out.println("계산기를 종료합니다.");
                    }
                    // try-catch로 바꿀 수 있나?
                    // 현재 코드에서 if 조건문이랑 예외처리의 차이가 있나?
                }
        } while (!calculator);
    }
}
