package data

sealed class Attachment(val type: String)

data class Photo(
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String = "",
    val date: Long = 0,
) : Attachment("photo")

data class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val description: String = "",
    val duration: Int = 0,
    val date: Long = 0,
    val views: Int = 0,
) : Attachment("video")

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val genreId: Int,
    val date: Long,
) : Attachment("audio")

data class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val fileType: Int
) : Attachment("file")

data class Graffiti(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
) : Attachment("Graffiti")

data class Comment(
val count: Int = 0,
val canPost: Boolean? = null,
val groupsCanPost: Boolean? = null,
val canClose: Boolean? = null,
val canOpen: Boolean? = null,
val id: Int,
val postId: Int,
val date: Int,
val text: String,
val attachment: List<Attachment>
) : Attachment("comment")

