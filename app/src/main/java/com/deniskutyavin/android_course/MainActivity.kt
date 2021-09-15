package com.deniskutyavin.android_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclersView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = UserAdapter()
        recyclerView.adapter = adapter
        adapter.userList = loadUsers()
        adapter.notifyDataSetChanged()
    }

    private fun loadUsers() : List<User> {
        return listOf(
            User(
                avatarUrl = "",
                userName = "User name 1",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 2",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 3",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 4",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 5",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 6",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 7",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 8",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 9",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 10",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 11",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 12",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 13",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 14",
                groupName = "A"
            ),

            User(
                avatarUrl = "",
                userName = "User name 15",
                groupName = "A"
            )
        )
    }
}