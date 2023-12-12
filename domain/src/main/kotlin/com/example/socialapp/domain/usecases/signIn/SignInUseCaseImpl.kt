package com.example.socialapp.domain.usecases.signIn

import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.UserDomain
import com.example.socialapp.domain.repositories.LoginRepository
import java.util.regex.Pattern

class SignInUseCaseImpl constructor(
    private val repository: LoginRepository
) : SignInUseCase {


    override suspend fun invoke(
        email: String, password: String
    ): Result<UserDomain> {
        if (email.isEmpty()) {
            return Result.Error(message = "First fill in email")
        }
        if (password.isEmpty()) {
            return Result.Error(message = "First fill in password")
        }
//        if (email.isValidString()) {
//            return Result.Error(message = "Incorrect fill email")
//        }
        if (password.length < 0) {
            return Result.Error(message = "Incorectfill password")
        }
        return repository.signIn(
            email = email,
            password = password
        )
    }
}

internal fun String.isValidString(): Boolean {
    val emailPattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a" +
                "-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
    )
    return emailPattern.matcher(this).matches()
}