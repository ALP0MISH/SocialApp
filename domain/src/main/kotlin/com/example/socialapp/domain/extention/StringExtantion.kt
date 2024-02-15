package com.example.socialapp.domain.extention

fun String.isTitleCase() = isNotEmpty() && this[0].isUpperCase() && drop(1).all{ it.isLowerCase() }