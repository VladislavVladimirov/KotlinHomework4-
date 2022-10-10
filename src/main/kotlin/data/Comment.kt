package data

data class Comment(
    var id: Int = 0,
    val postId: Int = 0,
    val date: Long = 0,
    val text: String = "",
    val attachment: List<Attachment> = emptyList()
)