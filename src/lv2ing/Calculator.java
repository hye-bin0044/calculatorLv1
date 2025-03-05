package lv2ing;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 속성
    private List<Integer> results;

    // 생성자
    public Calculator() {
        results = new ArrayList<>();
    }

    // 기능
    public int calculate(int num1, int num2, String operator) {
        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) { // 0으로 나누는 경우 예외 처리
                    throw new ArithmeticException("오류: 0으로 나눌 수 없습니다.");
                    // ArithmeticException 연산, 변환 작업에서 오류가 발생했을때 발생하는 예외처리
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("오류: 잘못된 연산자입니다.");
                // IllegalArgumentException 값이 잘못 입력 됐을때 발생하는 예외처리
        }

        setResult(result); // 연산 결과 저장
        return result; // 연산 결과 반환
    }

    // 리스트 복사본 정보 받음
    public List<Integer> getResults() {
//      return results; > 원본 리스트를 직접 반환함! 외부에서 수정할 수 있음
        return new ArrayList<>(results);
    }

    // 리스트에 결과 추가
    public void setResult(int result) {
        results.add(result);
        // int(기본형) → Integer(객체)로 자동 변환됨
    }
}
