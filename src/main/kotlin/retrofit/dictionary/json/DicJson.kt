package retrofit.dictionary.json

data class DicJson(
    val def: List<Def>,
    val head: Head
)

data class Def(
    val pos: String,
    val text: String,
    val tr: List<Tr>
)

data class Ex(
    val text: String,
    val tr: List<TrX>
)

class Head(
)

data class Mean(
    val text: String
)

data class Syn(
    val text: String
)

data class Tr(
    val ex: List<Ex>,
    val mean: List<Mean>,
    val pos: String,
    val syn: List<Syn>,
    val text: String
)

data class TrX(
    val text: String
)
