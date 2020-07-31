package cru

enum class Cru(pro: Int) {
    CRU(80), PREM(90), GRAND(100);

    override fun toString(): String = when (this) {
        CRU -> "Base cru"
        PREM -> "Premier cru"
        GRAND -> "Grand cru"
    }

}

fun main(){
    println(Cru.GRAND)
    val cru = Cru.valueOf("CRU")
    Cru.values().forEach { println(it) }
    println(cru)
}