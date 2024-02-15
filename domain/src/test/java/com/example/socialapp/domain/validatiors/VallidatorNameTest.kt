package com.example.socialapp.domain.validatiors

import org.junit.Test

class NameValidatorTest {
    val nameValidator: BaseValidator = NameValidator()

    @Test
    fun `should return false if value empty`() {
        val name = ""
        val result = nameValidator.validate(name)
        assertFalse(result)
    }

    @Test
    fun `should return false if value contains symbols`() {
        val name = ""
        val result = nameValidator.validate(name)
        assertFalse(result)
    }

    @Test
    fun `should return false if value first letter in not capital`() {
        val name = ""
        val result = nameValidator.validate(name)
        assertFalse(result)
    }

    @Test
    fun `should return false if value length more then NAME_MAX_LENGTH`() {
        val name = ""
        val result = nameValidator.validate(name)
        assertFalse(result)
    }

    @Test
    fun `should return false if value all conditionals true`() {
        val name = ""
        val result = nameValidator.validate(name)
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