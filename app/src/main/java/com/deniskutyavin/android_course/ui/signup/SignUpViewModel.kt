package com.deniskutyavin.android_course.ui.signup

import androidx.lifecycle.viewModelScope
import com.deniskutyavin.android_course.data.network.response.error.SendRegistrationVerificationCodeErrorResponse
import com.deniskutyavin.android_course.interactor.AuthInteractor
import com.deniskutyavin.android_course.ui.base.BaseViewModel
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : BaseViewModel() {

    private val _signUpActionStateFlow = MutableStateFlow<SignUpActionState>(SignUpActionState.Loading)
    private var _email : String? = null

    fun signUpActionStateFlow() : Flow<SignUpActionState> {
        return _signUpActionStateFlow.asStateFlow()
    }

    suspend fun refreshSuccess() {
        _signUpActionStateFlow.emit(SignUpActionState.SendingDone)
    }

    fun sendVerificationCode(
        email: String
    ) {
        // если email тот же, что был раньше, то нам не нужно запускать все заново
        if (email == _email) {
            viewModelScope.launch {
                _signUpActionStateFlow.emit(SignUpActionState.SendVerificationCodeSucess)
            }
            return
        }
        _email = email
        viewModelScope.launch {
            _signUpActionStateFlow.emit(SignUpActionState.Loading)
            try {
                when (val response = authInteractor.sendRegistrationVerificationCode(
                    email
                )) {
                    is NetworkResponse.Success -> {
                        _signUpActionStateFlow.emit(SignUpActionState.SendVerificationCodeSucess)
                    }
                    is NetworkResponse.ServerError -> {
                        _signUpActionStateFlow.emit(SignUpActionState.ServerError(response))
                    }
                    is NetworkResponse.NetworkError -> {
                        _signUpActionStateFlow.emit(SignUpActionState.NetworkError(response))
                    }
                    is NetworkResponse.UnknownError -> {
                        _signUpActionStateFlow.emit(SignUpActionState.UnknownError(response))
                    }
                }
            } catch (error: Throwable) {
                Timber.e(error)
                _signUpActionStateFlow.emit(
                    SignUpActionState.UnknownError(
                        NetworkResponse.UnknownError(
                            error
                        )
                    )
                )
            }
        }
    }

    sealed class SignUpActionState {
        object SendVerificationCodeSucess : SignUpActionState()
        object Loading : SignUpActionState()
        object SendingDone : SignUpActionState()
        data class ServerError(val e: NetworkResponse.ServerError<SendRegistrationVerificationCodeErrorResponse>) : SignUpActionState()
        data class NetworkError(val e: NetworkResponse.NetworkError) : SignUpActionState()
        data class UnknownError(val e: NetworkResponse.UnknownError) : SignUpActionState()
    }
}