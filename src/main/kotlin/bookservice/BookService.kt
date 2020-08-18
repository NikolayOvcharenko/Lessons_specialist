package bookservice

import java.lang.IllegalStateException

class LendBookManager(val bookService: BookService) {
    fun checkout(bookId: Int, memberId: Int) {
        if (bookService.inStock(bookId)) {
            bookService.lend(bookId, memberId)
        } else {
            throw IllegalStateException("Book is not available")
        }
    }
}

interface BookService {
    fun inStock(bookId: Int): Boolean
    fun lend(bookId: Int, memberId: Int)
}

fun main() {

   // val book : BookService(bookId = 100, memberId = 1)
}