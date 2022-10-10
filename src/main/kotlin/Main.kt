import WallService.add
import WallService.createComment
import WallService.printPosts
import WallService.update
import data.*

fun main() {
    val likes = Like()
    val reposts = Repost()
    val post = createPost()
    val comment = Comment()
    val post1 = post.copy(
        text = "Это мой первый пост",
        likes = likes.copy(count = likes.count + 200, canPublish = true),
        reposts = reposts.copy(count = reposts.count + 53),
        date = System.currentTimeMillis(),
        ownerId = 1,
        views = 500,
        comments = mutableListOf(),
        fromId = 1,
        createdBy = 0,
        replyOwnerId = 0,
        replyPostId = 0,
        isFriendsOnly = false,
        copyright = Copyright(),
        postType = "post",
        attachments = emptyList(),
        postSource = PostSource(),
        geo = Geo(),
        signer_id = 0,
        canPin = false,
        canEdit = false,
        isPinned = false,
        isMarkedAsAds = false,
        isFavorite = false,
        donut = Donut(),
        postponedId = 0,
        repost = null
    )
    val post2 = post.copy(
        text = "Это мой второй пост",
        likes = likes.copy(count = likes.count + 100, canPublish = true),
        reposts = reposts.copy(count = reposts.count + 93),
        date = System.currentTimeMillis(),
        ownerId = 1,
        views = 300,
        comments = mutableListOf(),
        fromId = 1,
        createdBy = 0,
        replyOwnerId = 0,
        replyPostId = 0,
        isFriendsOnly = false,
        copyright = Copyright(),
        postType = "post",
        attachments = listOf(
            Photo(123, 222, 32, 21, "Saint-Petersburg", date = System.currentTimeMillis()),
            Video(
                223,
                220,
                "Nevsky Prospect",
                "Our trip on the central street of Saint-Petersburg",
                324,
                date = System.currentTimeMillis(),
                320
            ),
            Audio(
                984,
                872,
                "Смысловые галлюцинации",
                "Вечно молодой",
                200,
                "www.itunes.com/smislovie_gallutsinatsii/songs",
                2,
                date = System.currentTimeMillis()
            ),
        ),
        postSource = PostSource(),
        geo = Geo(),
        signer_id = 0,
        canPin = false,
        canEdit = false,
        isPinned = false,
        isMarkedAsAds = false,
        isFavorite = false,
        donut = Donut(),
        postponedId = 0,
        repost = null
    )
    val updatedPost = post.copy(
        id = 1,
        text = "Обновление первого поста",
        likes = likes.copy(count = likes.count + 320, canPublish = true),
        reposts = reposts.copy(count = reposts.count + 33),
        date = System.currentTimeMillis(),
        ownerId = 1,
        views = 760,
        comments = mutableListOf(),
        fromId = 1,
        createdBy = 0,
        replyOwnerId = 0,
        replyPostId = 0,
        isFriendsOnly = false,
        copyright = Copyright(),
        postType = "post",
        attachments = emptyList(),
        postSource = PostSource(),
        geo = Geo(),
        signer_id = 0,
        canPin = false,
        canEdit = false,
        isPinned = false,
        isMarkedAsAds = false,
        isFavorite = false,
        donut = Donut(),
        postponedId = 0,
        repost = null
    )
    val comment1 =
        comment.copy(postId = 1, date = System.currentTimeMillis(), text = "Всем привет!", attachment = emptyList())
    val comment2 =
        comment.copy(postId = 2, date = System.currentTimeMillis(), text = "Классные фото!", attachment = emptyList())
    val comment3 =
        Comment(postId = 1, date = System.currentTimeMillis(), text = "Отличный пост!", attachment = emptyList())
    add(post1)
    add(post2)
    update(updatedPost)
    createComment(comment1)
    createComment(comment2)
    createComment(comment3)
    printPosts()


}

