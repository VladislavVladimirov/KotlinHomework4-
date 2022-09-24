import data.*

fun createPost(): Post = Post(
    0,
    1,
    fromId = 0,
    createdBy = 0,
    date = System.currentTimeMillis(),
    text = "",
    replyOwnerId = 0,
    replyPostId = 0,
    isFriendsOnly = null,
    comments = emptyList(),
    copyright = Copyright(),
    likes = Like(),
    reposts = Repost(),
    views = 1,
    postType = "",
    attachments = emptyList(),
    postSource = PostSource(),
    geo = Geo(),
    signer_id = 0,
    canPin = null,
    canEdit = null,
    isPinned = null,
    isMarkedAsAds = null,
    isFavorite = null,
    donut = Donut(),
    postponedId = 0,
    repost = null
)

fun main() {
    val likes = Like()
    val reposts = Repost()
    val post = createPost()
    val post1 = post.copy(
        text = "Это мой первый пост",
        likes = likes.copy(count = likes.count + 200, canPublish = true),
        reposts = reposts.copy(count = reposts.count + 53),
        date = System.currentTimeMillis(),
        ownerId = 1,
        views = 500,
        comments = emptyList(),
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
        comments = emptyList(),
        fromId = 1,
        createdBy = 0,
        replyOwnerId = 0,
        replyPostId = 0,
        isFriendsOnly = false,
        copyright = Copyright(),
        postType = "post",
        attachments = listOf(Photo(123,222,32,21,"Saint-Petersburg", date = System.currentTimeMillis()),
        Video(223,220,"Nevsky Prospect","Our trip on the central street of Saint-Petersburg", 324,date = System.currentTimeMillis(),320), Audio(984,872,"Смысловые галлюцинации","Вечно молодой", 200,"www.itunes.com/smislovie_gallutsinatsii/songs",2, date = System.currentTimeMillis() ),),
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
        comments = emptyList(),
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
    WallService.add(post1)
    WallService.add(post2)
    WallService.update(updatedPost)
    WallService.printPosts()
}

