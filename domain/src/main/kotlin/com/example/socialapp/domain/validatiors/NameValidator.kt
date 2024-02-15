package com.example.socialapp.domain.validatiors

import com.example.socialapp.domain.extention.isTitleCase

/**
 * Класс для валидации имени в приложении:
 *
 * - Не должен быть пустым
 * - Не должен сожержать
 * - Максимальное количество символов [NAME_MAX_LENGTH]
 */

private const val NAME_MAX_LENGTH = 25
private val NAME_REGEX = "[0-9!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex()

class NameValidator : BaseValidator {
    override fun validate(value: String): Boolean {
        return when {
            value.isEmpty() -> false
            value.matches(NAME_REGEX) -> false
            !value.isTitleCase() -> false
            value.length > NAME_MAX_LENGTH -> false
            else -> true
        }
    }
}