package me.leesh.board.post.interfaces.rest

import me.leesh.board.common.interfaces.rest.response.PageResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class GetPostsController {

    @GetMapping("/api/posts")
    fun searchPosts(
        @RequestParam param: PostSearchParameter,
    ): PageResponse<PostSummaryResponse> {
        // Implement logic to retrieve the post by ID
        return PageResponse(
            content = listOf(
                PostSummaryResponse(
                    id = 1L,
                    title = "Sample Post Title",
                    createdBy = "testUser",
                    createdAt = LocalDateTime.now().toString()
                ),
                PostSummaryResponse(
                    id = 2L,
                    title = "Another Sample Post Title",
                    createdBy = "anotherUser",
                    createdAt = LocalDateTime.now().toString()
                )
            ),
            page = param.page,
            size = param.size,
            totalElements = 2,
            totalPages = 1
        )
    }

    data class PostSearchParameter(
        val page: Int = 0,
        val size: Int = 10,
        val title: String?,
        val createdBy: String?,
    )

    data class PostSummaryResponse(
        val id: Long,
        val title: String,
        val createdBy: String,
        val createdAt: String,
    )
}
