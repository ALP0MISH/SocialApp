package com.example.socialapp.presentation.extensions

/**
 * Данный метод предназначен для того чтобы -
 * первую букву строки делать заглавной а остальные буквы маленькими
 */
fun String?.firstLetterIsCapitalizedRestSmall(): String =
    if (this == null) String()
    else if (length > 1) substring(0, 1).uppercase() + substring(1).lowercase()
    else if (isNotBlank()) substring(0, 1).uppercase()
    else this