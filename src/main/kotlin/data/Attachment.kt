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
    val id: Int = 0,
    val ownerId: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0,
    val url: String ="",
    val genreId: Int = 0,
    val date: Long = 0,
) : Attachment("audio")

data class File(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
    val url: String = "",
    val date: Int = 0,
    val fileType: Int = 0
) : Attachment("file")

data class Graffiti(
    val id: Int = 0,
    val ownerId: Int = 0,
    val url: String = "",
    val width: Int = 0,
    val height: Int = 0
) : Attachment("Graffiti")



