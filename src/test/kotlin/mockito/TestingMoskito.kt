package mockito

import net.bytebuddy.asm.Advice
import net.bytebuddy.dynamic.scaffold.MethodGraph
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatcher
import org.mockito.ArgumentMatchers
import org.mockito.Captor
import org.mockito.Mockito.*
import java.util.*

class TestingMoskito {

    @Test
    fun test1() {
        val test: MyKlass = mock(MyKlass::class.java)
        `when`(test.getUniqueId()).thenReturn(43)
        assertEquals(43, test.getUniqueId())
    }

    @Test
    fun testTwoReturnValues() {
        val iter = mock(Iterator::class.java) as Iterator<String>
        `when`(iter.next()).thenReturn("Hello").thenReturn("World")
        val result = iter.next() + " " + iter.next()
        assertEquals("Hello World", result)
    }

    @Test
    fun testComp() {
        val comp = mock(Comparable::class.java) as Comparable<String>
        `when`(comp.compareTo("Hello")).thenReturn(2)
        `when`(comp.compareTo("World")).thenReturn(4)
        assertEquals(2, comp.compareTo("Hello"))
        assertEquals(4, comp.compareTo("World"))
    }

    @Test
    fun testThrows() {
        val props = mock(Properties::class.java)
        `when`(props["Linux"]).thenReturn("OK")
        `when`(props["Android"]).thenThrow(IllegalArgumentException("Typo"))
        assertEquals("OK", props["Linux"])
        val thrown = assertThrows<java.lang.IllegalArgumentException> {
            props["Android"]
        }
        assertEquals(thrown.message, "Typo")
    }

    @Test
    fun testSpyWrong() {
        val list: List<String> = LinkedList()
        val  spy: List<String> = spy(list)
        // `when`(spy[0]).thenReturn("hello")
        doReturn("hello").`when`(spy)[0]
        assertEquals(spy[0], "hello")
    }

    @Test
    fun testVerify() {
        val test = mock (MyKlass::class.java)
        `when`(test.getUniqueId()).thenReturn(43)
        test.testing(12)
        test.getUniqueId()
        test.getUniqueId()
        verify(test).testing(ArgumentMatchers.eq(12))
        verify(test, times(2)).getUniqueId()
        verify(test, atLeastOnce()).getUniqueId()
        verify(test, atLeast(1)).getUniqueId()
        verify(test, atMost(10)).getUniqueId()
        verify(test, never()).someMethod("newer called")
        verifyNoMoreInteractions(test)

    }

    @Captor
    lateinit var stringCaptor: ArgumentCaptor<String>

    class MockitoHelper {
        fun <T> capture (captor: ArgumentCaptor<T>): T = captor.capture()
    }

    @Test
    fun shouldContainString() {
        stringCaptor = ArgumentCaptor.forClass(String::class.java)

        val helper = MockitoHelper()

        var list = LinkedList<String>()
        val spy = spy(list)
        spy.add("hello")
        // verify(spy).add(stringCaptor.capture()) // Если IllegalStateException
        verify(spy).add(helper.capture(stringCaptor))
        assertTrue(stringCaptor.value == "hello")
    }
}