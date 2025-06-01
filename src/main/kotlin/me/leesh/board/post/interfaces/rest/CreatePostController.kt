package me.leesh.board.post.interfaces.rest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreatePostController {

    @PostMapping("/api/posts")
    fun createPost(
        @RequestBody request: PostCreateRequest,
    ): Long {
        return 1L
    }

    data class PostCreateRequest(
        val title: String,
        val content: String,
        val createdBy: String,
    )
}
