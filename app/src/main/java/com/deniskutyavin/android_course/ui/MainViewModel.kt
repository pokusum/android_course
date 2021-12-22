package com.deniskutyavin.android_course.ui


import com.deniskutyavin.android_course.interactor.AuthInteractor
import com.deniskutyavin.android_course.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : BaseViewModel() {
    var isAuthorizedFlow: Flow<Boolean> = MutableStateFlow(false)
    suspend fun isAuthorized() {
        isAuthorizedFlow = authInteractor.isAuthorized()
    }

    suspend fun logout() {
        authInteractor.logout()
    }
}