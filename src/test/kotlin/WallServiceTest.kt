import WallService.add
import WallService.createComment
import data.*
import exception.PostNotFoundException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

internal class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
    @Test
    fun add() {
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
        add(post1)
        val posts = WallService.getAll()
        assertEquals(1, posts[0].id)

    }

    @Test
    fun updateTrue() {
        val post = createPost()
        val likes = Like()
        val reposts = Repost()
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
        add(post1)
        val result = WallService.update(updatedPost)
        assertTrue(result)
    }

    @Test
    fun createCommentTrue() {
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
        val comment1 =
            comment.copy(postId = 1, date = System.currentTimeMillis(), text = "Всем привет!", attachment = emptyList())
        add(post1)
        val result = createComment(comment1)
        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowComment() {
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
        val comment1 =
            comment.copy(postId = 4, date = System.currentTimeMillis(), text = "Всем привет!", attachment = emptyList())
        add(post1)
        createComment(comment1)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowUpdate() {
        val post = createPost()
        val likes = Like()
        val reposts = Repost()
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
        val updatedPost = post.copy(
            id = 3,
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
        add(post1)
        WallService.update(updatedPost)
    }

}