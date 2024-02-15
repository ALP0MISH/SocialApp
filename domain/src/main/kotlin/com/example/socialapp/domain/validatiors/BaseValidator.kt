package com.example.socialapp.domain.validatiors

interface BaseValidator {
    fun validate(value: String): Boolean
}