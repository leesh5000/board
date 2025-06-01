package me.leesh.board

import io.kotest.core.spec.style.FunSpec

class SampleTest : FunSpec({
    test("sample test") {
        // This is a sample test that always passes
        val result = 1 + 1
        assert(result == 2) { "Expected 1 + 1 to equal 2" }
    }
})
