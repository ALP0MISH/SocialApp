package com.example.socialapp.presentation.screens.editProfile

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.socialapp.presentation.extensions.convertToByteArray
import com.example.socialapp.presentation.extensions.firstLetterIsCapitalizedRestSmall
import com.example.socialapp.presentation.models.User
import com.parse.ParseException
import com.parse.ParseFile
import com.parse.ProgressCallback
import com.parse.SaveCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

private const val DEFAULT_IMAGE_TITLE = "image.png"

@HiltViewModel
class EditProfileViewModel @Inject constructor(

) : ViewModel(), SaveCallback, ProgressCallback {
    private val _uiState = MutableStateFlow<EditProfileUiState>(EditProfileUiState.Initial)
    val uiState: StateFlow<EditProfileUiState> = _uiState.asStateFlow()

    private val _uploadProgress = MutableStateFlow<AvatarUploadProgress?>(null)
    val uploadProgress: StateFlow<AvatarUploadProgress?> = _uploadProgress.asStateFlow()

    private var parseFile: ParseFile? = null

    init {
        val user = User.unknown
        _uiState.tryEmit(
            EditProfileUiState.Content(
                user = user,
                name = user.name,
                lastName = user.lastName,
                email = user.email,
                aboutMe = user.bio ?: String()
            )
        )
    }

    fun onEvent(event: EditProfileEvent) {
        when (event) {
            is EditProfileEvent.OnSaveButtonClick -> doSaveButtonClick()
            is EditProfileEvent.OnAboutChange -> doAboutChanged(event.value)
            is EditProfileEvent.OnEmailChange -> doEmailChanged(event.value)
            is EditProfileEvent.OnNameChange -> doNameChanged(event.value)
            is EditProfileEvent.OnLastNameChange -> doLastNameChanged(event.value)
            is EditProfileEvent.OnAvatarChanged -> doAvatarChanged(event.bitmap)
            is EditProfileEvent.OnEducationChange -> TODO()
            is EditProfileEvent.OnPasswordChange -> TODO()
        }
    }

    private fun doSaveButtonClick() {
        startSaveAvatar()
    }

    private fun startSaveAvatar() {
        val file = parseFile ?: return
        file.saveInBackground(this, this)
    }

    private fun doAvatarChanged(bitmap: Bitmap) {
        val byteArray = bitmap.convertToByteArray()
        parseFile = ParseFile(DEFAULT_IMAGE_TITLE, byteArray)

    }

    private fun doAboutChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(aboutMe = value.lowercase())
        }
    }

    private fun doEmailChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(email = value.lowercase())
        }
    }

    private fun doNameChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(name = value.firstLetterIsCapitalizedRestSmall())
        }
    }

    private fun doLastNameChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(lastName = value.firstLetterIsCapitalizedRestSmall())
        }
    }

    override fun done(e: ParseException?) {
        Log.i("Abdurahman", "ParseException${e?.stackTraceToString()}")
        _uploadProgress.tryEmit(null)
    }

    override fun done(percentDone: Int?) {
        val progrss = percentDone ?: return
        val uploadProgress = AvatarUploadProgress(progrss)
        _uploadProgress.tryEmit(uploadProgress)
    }
}