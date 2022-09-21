@file:Suppress("NAME_SHADOWING")

package task_1

import java.text.SimpleDateFormat

data class Like(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Repost(val count: Int = 0, val userReposted: Boolean = false)

data class Comment(
    val count: Int = 0,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Post(
    var id: Int = 0,
    val ownerId: Int = 0,
    val date: Long = 0,
    val text: String = "",
    val likes: Like = Like(),
    val reposts: Repost = Repost(),
    val views: Int = 0,
    val comments: Comment = Comment(),
    val isFriendsOnly: Boolean = false,
    val isFavorite: Boolean = false
)

fun createPost(): Post = Post(
    0,
    1,
    date = System.currentTimeMillis(), text = "Hello Kotlin!",
    likes = Like(),
    reposts = Repost(),
    views = 1,
    comments = Comment(),
    isFriendsOnly = false,
    isFavorite = false
)

object WallService {
    private var posts = emptyArray<Post>()
    private var id: Int = 0

    fun clear() {
        posts = emptyArray()
    }

    fun add(post: Post): Post {
        posts += post.copy(id = id++)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                val originalPost = posts[index]
                posts[index] = post.copy(ownerId = originalPost.ownerId, date = originalPost.date)
                return true
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
            val dataFormat = SimpleDateFormat("Дата поста: dd:MM:yy, время поста:  HH:mm:ss")
            val data = dataFormat.format(post.date)
            println("${post.text}\n Id автора: ${post.ownerId}\n Id поста: ${post.id}\n $data\n Количество лайков: ${post.likes.count}\n Количество репостов: " "

            )
            post.text + ", Идентификатор поста: " + post.id +
                    ", Идентификатор автора поста: " + post.ownerId +
                    ", $data " + "Лайки: " + post.likes.count + "\n"
        }
    }
}

fun main() {
    val likes = Like()
    val reposts = Repost()
    val comments = Comment()
    val post = createPost()
    val post1 = post.copy(
        likes = likes.copy(count = likes.count + 200, canPublish = true),
        reposts = reposts.copy(count = reposts.count + 53),
        date = System.currentTimeMillis(),
        ownerId = 1,
        views = 500,
        comments = comments.copy(count = 50, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
    )
    val update = post.copy(
        likes = likes.copy(count = likes.count + 200, canPublish = true),
        reposts = reposts.copy(count = reposts.count + 53),
        date = System.currentTimeMillis(),
        ownerId = 1,
        views = 500,
        comments = comments.copy(count = 50, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
    )
    WallService.add(post1)
    WallService.printPosts()
}

