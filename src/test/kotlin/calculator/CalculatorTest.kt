package calculator

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.lang.AssertionError
import java.util.stream.Stream


@TestInstance(TestInstance.Lifecycle.PER_CLASS) // один раз создавать класс
class CalculatorTest {
    init {
        println("init")
    }

    @BeforeAll
    fun prepare() {
        println("Prepare")
    }

    @BeforeEach
    fun prepareTest() {
        println("PrepareTest")
    }

    @AfterAll
    fun tearDown() {
        println("tearDown")
    }

    @Test
    fun calcAdd() {
        println("calcAdd")
        val calculator = Calculator(15)
        calculator.add(2)
        assertEquals(17, calculator.get(), "15 + 2 = 17")

    }

    @Test
    @DisplayName("Calculator ADD test Func")
    fun calcMul() {
        println("calcMul")
        val calculator = Calculator(15)
        calculator.mul(2)
        assertEquals(30, calculator.get(), "15 * 2 = 30")
    }


    @ParameterizedTest
    @CsvSource(
        "0, 1, 1",
        "10, 5, 15",
        "1, 100, 101"
    )
    fun paraAdd(f: Int, s: Int, r: Int) {
        println("calcAdd+")
        val calculator = Calculator(f)
        calculator.add(s)
        assertEquals(r, calculator.get(), "$f + $s = $r")
    }

    fun data(): Stream<Arguments> = Stream.of(
        Arguments.of(0, 0, 0),
        Arguments.of(0, 3, 0),
        Arguments.of(12, 6, 72),
        Arguments.of(3, 6, 18)
    )

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @MethodSource("data")
    fun paraMul(f: Int, s: Int, r: Int) {
        println("calcMul+")
        val calculator = Calculator(f)
        calculator.mul(s)
        assertEquals(r, calculator.get(), "$f * $s = $r")
    }

    @Test
    fun divisionByZeroThrowsException() {
        val calculator = Calculator(10)

        val exception = assertThrows<AssertionError> {
            calculator.div(0)
        }
        assertEquals("Division by Zero", exception.message, "Exception should be 'Division by Zero'")
    }

    @Disabled
    @Test
    fun combineAddAndMul() {
        val calculator = Calculator(15)


        assertAll(
            "Проверка + и * ",
            {
                assertEquals(
                    15, calculator.get()
                )
            },
            {
                calculator.add(2)
                assertEquals(
                    17, calculator.get()
                )
            },
            {
                calculator.mul(3)
                assertEquals(
                    51, calculator.get()
                )
            }
        )

    }



}