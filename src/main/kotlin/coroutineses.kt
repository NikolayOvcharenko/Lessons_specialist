//class coroutineses {
//}

import javafx.application.Application.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay

fun main() = runBlocking {
    // println(::delay.name)
    for (i in 200..1000 step 200) {
        launch {
            delay(1000L - i)
            print(i)
        }
    }
}