package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Null 값을 입력했을 경우 0을 반환한다.")
    public void checkNull() {
        //given
        String input = null;

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 0);
    }

    @Test
    @DisplayName("빈 문자열인 경우, 0을 반환한다,")
    public void checkEmpty() {
        //given
        String input = "";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void returnOneNumber() throws Exception {
        //given
        String input = "1";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("숫자를 띄어쓰기로 구분한다.")
    public void checkSum() throws Exception {
        //given
        String input = "1 + 3";

        //when
        String[] result = calculator.parseInput(input);

        //then
        assertEquals(result.length, 3);
    }

    @Test
    @DisplayName("숫자 판별을 검증한다.")
    public void checkNum() {
        //given
        String oper = "+";
        String number = "3";

        //when
        boolean result1 = calculator.isNumber(oper);
        boolean result2 = calculator.isNumber(number);
        //then
        assertAll(
                () -> assertFalse(result1),
                () -> assertTrue(result2)
        );
    }

    @Test
    @DisplayName("두 개의 연산자에 대해 +를 계산할 수 있다.")
    public void addTest() throws Exception {
        //given
        String input = "1 + 3";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 4);
    }

    @Test
    @DisplayName("두 개의 연산자에 대해 -를 계산할 수 있다.")
    public void subTest() throws Exception {
        //given
        String input = "1 - 3";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, -2);
    }

    @Test
    @DisplayName("두 개의 연산자에 대해 *를 계산할 수 있다.")
    public void mulTest() throws Exception {
        //given
        String input = "2 * 3";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 6);
    }


    @Test
    @DisplayName("두 개의 연산자에 대해 /를 계산할 수 있다.")
    public void divTest() throws Exception {
        //given
        String input = "6 / 3";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 2);
    }

    @Test
    @DisplayName("세 개 이상의 항에 대해서 연산에 성공한다.")
    public void multipleCalculate() throws Exception {
        //given
        String input = "2 + 3 * 4 / 2";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 10);
    }

}