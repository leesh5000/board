package me.leesh.board

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringSpecSampleTest : StringSpec({
    "1 + 1 should equal 2" {
        val result = 1 + 1
        result shouldBe 2
    }
})
