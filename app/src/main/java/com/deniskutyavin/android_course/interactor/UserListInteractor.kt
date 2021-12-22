package com.deniskutyavin.android_course.interactor

import com.deniskutyavin.android_course.data.network.response.error.GetUsersErrorResponce
import com.deniskutyavin.android_course.entity.User
import com.deniskutyavin.android_course.repository.UsersRepository
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class UserListInteractor @Inject constructor(
    private val usersRepository: UsersRepository
) {
    suspend fun getUsers(): NetworkResponse<List<User>, GetUsersErrorResponce> {
        val response = usersRepository.getUsers()
        return response
    }
}