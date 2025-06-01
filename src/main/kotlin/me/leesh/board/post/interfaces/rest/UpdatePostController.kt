package me.leesh.board.post.interfaces.rest

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdatePostController {

    @PutMapping("/api/posts/{id}")
    fun updatePost(
        @PathVariable id: Long,
        @RequestBody request: PostUpdateRequest,
    ): Long {
        return id
    }

    data class PostUpdateRequest(
        val title: String,
        val content: String,
        val updatedBy: String,
    )
}
