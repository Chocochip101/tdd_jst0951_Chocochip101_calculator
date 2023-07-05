package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup(){
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
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    public void checkSum() throws Exception {
        //given
        String input = "1,2";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    public void useColon() throws Exception {
        //given
        String input = "1,2:3";

        //when
        int result = calculator.calculate(input);

        //then
        assertEquals(result, 6);
    }

}