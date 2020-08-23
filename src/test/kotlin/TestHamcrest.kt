import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test


class TestHamcrest {


    @Test
    fun testHamcrest() {
        assertThat("hello", endsWith("o"))
        assertThat("hello", not("world"))
        /* allOf, anyOf, not
        assertThat(greetings(), allOf(
            'is'("Hello World!"),
            endsWith("Id!")
        )) */
    }
}