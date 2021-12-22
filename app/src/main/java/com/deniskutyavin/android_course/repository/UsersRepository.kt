package com.deniskutyavin.android_course.repository

import com.deniskutyavin.android_course.data.network.Api
import com.deniskutyavin.android_course.data.network.response.error.GetUsersErrorResponce
import com.deniskutyavin.android_course.entity.User
import com.deniskutyavin.android_course.data.di.AppCoroutineScope
import com.deniskutyavin.android_course.data.di.IoCoroutineDispatcher
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.Lazy
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(
    private val apiLazy: Lazy<Api>,
    @AppCoroutineScope externalCoroutineScope: CoroutineScope,
    @IoCoroutineDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    private val api by lazy { apiLazy.get() }

    suspend fun getUsers() : NetworkResponse<List<User>, GetUsersErrorResponce> {
        return api.getUsers()
    }
}