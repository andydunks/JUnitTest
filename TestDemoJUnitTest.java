
package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
    void assertThatTwoPositiveNumbersAreSubtractedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.subtractPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.subtractPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            Arguments.arguments(2, 4, 6, false),
            Arguments.arguments(1, 3, 4, false),
            Arguments.arguments(0, 5, 0, true),
            Arguments.arguments(5, 0, 0, true),
            Arguments.arguments(-1, 4, 0, true),
            Arguments.arguments(3, -2, 0, true),
            Arguments.arguments(-3, -2, 0, true)
        );
    }
    
    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        assertThat(testDemo.addPositive(1, 2)).isEqualTo(3);
        assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
        assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
    }
    @Test
    void assertThatPairsOfPositiveNumbersAreSubtractedCorrectly() {
        assertThat(testDemo.subtractPositive(4, 5)).isEqualTo(-1);
        assertThat(testDemo.subtractPositive(40, 50)).isEqualTo(-10);
        assertThat(testDemo.subtractPositive(1, 2)).isEqualTo(-1);
        assertThat(testDemo.subtractPositive(10, 20)).isEqualTo(-10);
        assertThat(testDemo.subtractPositive(100, 200)).isEqualTo(-100);
    }
  
 
    
    @Test
    void assertThatNumberSquaredIsCorrect() {
        
        TestDemo mockDemo = spy(testDemo);

      
        doReturn(5).when(mockDemo).getRandomInt();

     
        int fiveSquared = mockDemo.randomNumberSquared();

        assertThat(fiveSquared).isEqualTo(25);
    }
}
