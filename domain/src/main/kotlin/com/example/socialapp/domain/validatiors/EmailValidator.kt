package com.example.socialapp.domain.validatiors

import com.example.socialapp.domain.extention.isTitleCase

/**
 * Класс для валидации имени в приложении:
 * - Не должен быть пустым
 * - Не должен сожержать
 * - Максимальное количество символов [NAME_MAX_LENGTH]
 */

private const val NAME_MAX_LENGTH = 25
private val EMAIL_REGEX = "[a-zA-Z0-9]+@(gmail\\\\.com|mail\\\\.ru)".toRegex()

class EmailValidator : BaseValidator {
    override fun validate(value: String): Boolean {
        return when {
            value.isEmpty() -> false
            value.matches(EMAIL_REGEX) -> false
            !value.isTitleCase() -> false
            value.length > NAME_MAX_LENGTH -> false
            else -> true
        }
    }

}