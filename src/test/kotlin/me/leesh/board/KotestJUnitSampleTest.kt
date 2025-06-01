package me.leesh.board

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class KotestJUnitSampleTest {

    @Test
    fun `sample test with kotest assertions`() {
        // This is a sample test that always passes using Kotest assertions
        val result = 1 + 1
        result shouldBe 2
    }
}
