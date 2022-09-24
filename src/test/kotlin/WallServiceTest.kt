import data.*
import org.junit.Before
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


internal class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
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
        val result = WallService.update(updatedPost)
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
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
        val updatedPost = post.copy(
            id = 3,
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
        val result = WallService.update(updatedPost)
        assertFalse(result)
    }

}