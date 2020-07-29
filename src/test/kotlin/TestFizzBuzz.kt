import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestFizzBuzz {
    @Test
    fun testFizzBuzz() {
        assertEquals("41:",              FizzBuzz(41))
        assertEquals("55: Buzz",        FizzBuzz(55))
        assertEquals("33: Fizz",        FizzBuzz(33))
        assertEquals("150: FizzBuzz",   FizzBuzz(150))

    }
}