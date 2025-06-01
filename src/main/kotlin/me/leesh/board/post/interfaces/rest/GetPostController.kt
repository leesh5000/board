package me.leesh.board.post.interfaces.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class GetPostController {

    @GetMapping("/api/posts/{id}")
    fun getPostById(@PathVariable id: Long): PostResponse {
        // Implement logic to retrieve the post by ID
        return PostResponse(
            id = id,
            title = "Sample Post Title",
            content = "This is a sample post content.",
            createdBy = "testUser",
            createdAt = LocalDateTime.now().toString()
        )
    }

    data class PostResponse(
        val id: Long,
        val title: String,
        val content: String,
        val createdBy: String,
        val createdAt: String,
    )
}
