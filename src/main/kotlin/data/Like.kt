package data

data class Like(
    val count: Int = 0,
    val userLikes: Boolean? = null,
    val canLike: Boolean? = null,
    val canPublish: Boolean? = null
)
