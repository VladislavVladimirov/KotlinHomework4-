import org.junit.Before
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import task_1.*

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
        val comments = Comment()
        val post1 = post.copy(
            text = "Это мой первый пост",
            likes = likes.copy(count = likes.count + 200, canPublish = true),
            reposts = reposts.copy(count = reposts.count + 53),
            date = System.currentTimeMillis(),
            ownerId = 1,
            views = 500,
            comments = comments.copy(count = 50, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
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
        val comments = Comment()
        val post1 = post.copy(
            text = "Это мой первый пост",
            likes = likes.copy(count = likes.count + 200, canPublish = true),
            reposts = reposts.copy(count = reposts.count + 53),
            date = System.currentTimeMillis(),
            ownerId = 1,
            views = 500,
            comments = comments.copy(count = 50, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        )
        val updatedPost = post.copy(
            id = 1,
            text = "Обновление первого поста",
            likes = likes.copy(count = likes.count + 320, canPublish = true),
            reposts = reposts.copy(count = reposts.count + 33),
            date = System.currentTimeMillis(),
            ownerId = 1,
            views = 760,
            comments = comments.copy(count = 50, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
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
        val comments = Comment()
        val post1 = post.copy(
            text = "Это мой первый пост",
            likes = likes.copy(count = likes.count + 200, canPublish = true),
            reposts = reposts.copy(count = reposts.count + 53),
            date = System.currentTimeMillis(),
            ownerId = 1,
            views = 500,
            comments = comments.copy(count = 50, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        )
        val updatedPost = post.copy(
            id = 3,
            text = "Обновление первого поста",
            likes = likes.copy(count = likes.count + 320, canPublish = true),
            reposts = reposts.copy(count = reposts.count + 33),
            date = System.currentTimeMillis(),
            ownerId = 1,
            views = 760,
            comments = comments.copy(count = 50, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        )
        WallService.add(post1)
        val result = WallService.update(updatedPost)
        assertFalse(result)
    }

}