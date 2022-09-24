import data.*
import java.text.SimpleDateFormat

object WallService {
    private var posts = emptyArray<Post>()
    private var id: Int = 1

    fun clear() {
        posts = emptyArray()
    }

    fun add(post: Post): Post {
        posts += post.copy(id = id++)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        posts.withIndex().forEach {

            when (it.value.id) {

                post.id -> {
                    val prevPost = posts[it.index]
                    posts[it.index] = post.copy(ownerId = prevPost.ownerId, date = prevPost.date)

                    return true
                }

                else -> Unit
            }

        }
        return false
    }

    fun getAll(): Array<Post> {
        return posts
    }

    fun printPosts() {
        val posts = getAll()
        for (post in posts) {
            val dataFormat = SimpleDateFormat("dd:MM:yy HH:mm")
            val data = dataFormat.format(post.date)
            println(" ${post.text}\n Id автора: ${post.ownerId}\n Id поста: ${post.id}\n $data\n Лайки: ${post.likes.count}\n Репосты: ${post.reposts.count}\n Просмотры: ${post.views}\n")
            if (post.attachments.size != 0) {
                println(" Вложения:")
                for (att: Attachment in post.attachments) {
                    when (att) {
                        is Photo -> println(" Photo\n id = ${att.id}\n albumId = ${att.albumId}\n " +
                                    "ownerId = ${att.ownerId}\n userId = ${att.userId}\n ${att.text}\n")

                        is Audio -> println(" Audio\n id = ${att.id}\n ownerId = ${att.ownerId}\n " +
                                "artist = ${att.artist}\n title = ${att.title}\n duration = ${att.duration}\n" +
                                " url = ${att.url}\n genreId = ${att.genreId} ")
                        is Video -> println(" Video\n id = ${att.id}\n ownerId = ${att.ownerId}\n " +
                                "title = ${att.title}\n ${att.description}\n duration = ${att.duration}\n" +
                                " views = ${att.views}\n")
                        is File -> println(" File\n id = ${att.id}\n ownerId = ${att.ownerId}\n " +
                                "title = ${att.title}\n size = ${att.size}\n" +
                                "ext = ${att.ext}\n fileType = ${att.fileType}\n")
                        is Comment -> println(" Comment\n id = ${att.id}\n postId = ${att.postId}\n  ${att.text}\n")
                        is Graffiti -> println(" Graffiti\n id = ${att.id}\n ownerId = ${att.ownerId}\n url = ${att.url}\n width = ${att.width}\n height = ${att.height}\n")
                    }
                }
            }
        }
    }
}