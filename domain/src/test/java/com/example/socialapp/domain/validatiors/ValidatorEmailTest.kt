package com.example.socialapp.domain.validatiors

import org.junit.Test

class ValidatorEmailTest {
    val emailValidator: BaseValidator = EmailValidator()


    @Test
    fun `should return false if value empty`() {
        val name = ""
        val result = emailValidator.validate(name)
        assertFalse(result)
    }

    @Test
    fun `should return false if value is not contains @gmail com`() {
        val name = ""
        val result = emailValidator.validate(name)
        assertFalse(result)
    }

    @Test
    fun `should return false if value length more then NAME_MAX_LENGTH`() {
        val name = ""
        val result = emailValidator.validate(name)
        assertFalse(result)
    }

    @Test
    fun `should return false if value all conditionals true`() {
        val name = "cwewv"
        val result = emailValidator.validate(name)
        assertTrue(result)
    }

}

private fun assertFalse(condition: Boolean, message: String? = null) {
    if (condition) {
        throw IllegalStateException(message)
    }
}

private fun assertTrue(condition: Boolean, message: String? = null) {
    if (condition) {
        throw IllegalStateException(message)
    }
}