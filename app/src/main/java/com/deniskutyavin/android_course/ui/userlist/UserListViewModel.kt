package com.deniskutyavin.android_course.ui.userlist

import androidx.lifecycle.viewModelScope
import androidx.viewbinding.BuildConfig
import com.deniskutyavin.android_course.data.network.Api
import com.deniskutyavin.android_course.data.network.MockApi
import com.deniskutyavin.android_course.data.network.response.error.GetUsersErrorResponce
import com.deniskutyavin.android_course.entity.User
import com.deniskutyavin.android_course.interactor.UserListInteractor
import com.deniskutyavin.android_course.ui.base.BaseViewModel
import com.haroldadmin.cnradapter.NetworkResponse
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userListInteractor: UserListInteractor
) : BaseViewModel() {

    sealed class LoadUsersActionState {
        object Loading : LoadUsersActionState()
        data class Data(val userList: List<User>) : LoadUsersActionState()
        data class ServerError(val e: NetworkResponse.ServerError<GetUsersErrorResponce>) : LoadUsersActionState()
        data class NetworkError(val e: NetworkResponse.NetworkError) : LoadUsersActionState()
        data class UnknownError(val e: NetworkResponse.UnknownError) : LoadUsersActionState()
    }
    private val _loadUsersActionState = MutableStateFlow<LoadUsersActionState>(LoadUsersActionState.Loading)
    val loadUsersActionState: Flow<LoadUsersActionState> get() = _loadUsersActionState.asStateFlow()

    init {
        viewModelScope.launch {
            _loadUsersActionState.emit(LoadUsersActionState.Loading)
            lateinit var users : List<User>
            try {
                when (val response = userListInteractor.getUsers()) {
                    is NetworkResponse.Success -> {
                        users = response.body
                    }
                    is NetworkResponse.ServerError -> {
                        _loadUsersActionState.emit(LoadUsersActionState.ServerError(response))
                    }
                    is NetworkResponse.NetworkError -> {
                        _loadUsersActionState.emit(LoadUsersActionState.NetworkError(response))
                    }
                    is NetworkResponse.UnknownError -> {
                        _loadUsersActionState.emit(LoadUsersActionState.UnknownError(response))
                    }
                }
            } catch (error: Throwable) {
                Timber.e(error)
                _loadUsersActionState.emit(
                    LoadUsersActionState.UnknownError(
                        NetworkResponse.UnknownError(
                            error
                        )
                    )
                )
            }
            _loadUsersActionState.emit(LoadUsersActionState.Data(users))
        }
    }

private fun provideApi() : Api =
    if (BuildConfig.DEBUG) {
        MockApi()
    }
    else {
        Retrofit
            .Builder()
            .client(provideOkHttpClient())
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
            .build()
            .create(Api::class.java)
    }

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        //.addInterceptor(AuthorizationInterceptor(AuthRepository()))
        .build()
}

private fun provideMoshi(): Moshi {
    return Moshi.Builder().build()
}
}