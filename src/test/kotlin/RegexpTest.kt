import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RegexpTest {

    @Test
    fun regexpTest() {
        assertTrue(date ("10 MAR 2020"))

        assertFalse(date ("10 03 2020"))
    }
}