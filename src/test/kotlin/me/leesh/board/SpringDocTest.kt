package me.leesh.board

import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class SpringDocTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `OpenAPI endpoint should be accessible`() {
        // Test that the OpenAPI endpoint is accessible
        val result = mockMvc.perform(get("/v3/api-docs"))
            .andExpect(status().isOk)
            .andReturn()

        // Verify that the response contains OpenAPI content
        val content = result.response.contentAsString
        content shouldNotBe null
        assert(content.contains("openapi")) { "Response should contain OpenAPI specification" }
    }

    @Test
    fun `Swagger UI should be accessible`() {
        // Test that the Swagger UI endpoint is accessible
        val result = mockMvc.perform(get("/swagger-ui/index.html"))
            .andExpect(status().isOk)
            .andReturn()

        // Verify that the response contains Swagger UI content
        val content = result.response.contentAsString
        content shouldNotBe null
        assert(content.contains("swagger-ui")) { "Response should contain Swagger UI" }
    }
}
