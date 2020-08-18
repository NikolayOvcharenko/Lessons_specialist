package mockito

import bookservice.BookService
import bookservice.LendBookManager
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import java.lang.IllegalStateException

class TestBookService {

    @Test
    fun testLendBookServ() {
        val bookService100 = Mockito.mock(BookService::class.java)
        // bookService.inStock(100)
        `when`(bookService100.inStock(100)).thenReturn(true)

        var lendBookManager = LendBookManager(bookService100)

        lendBookManager.checkout(100,200)

        verify(bookService100).lend(100,200)

        val bookService200 = Mockito.mock(BookService::class.java)
        `when`(bookService200.inStock(200)).thenReturn(false)
        lendBookManager = LendBookManager(bookService200)
        val thrown = assertThrows<IllegalStateException> {
            lendBookManager.checkout(200,200)
        }
        assertEquals(thrown.message, "Book is not available")


    }

}