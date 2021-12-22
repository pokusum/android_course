package com.deniskutyavin.android_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.deniskutyavin.android_course.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    companion object {
        val LOG_TAG = "MyAwesomeLogTag"

    }

    private val viewModel: MainViewModel by viewModels()

    private val viewBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(LOG_TAG, "onCreate()")

        setContentView(R.layout.activity_main)
        setupRecyclerView()

        findViewById<View>(R.id.usersRecyclersView).isVisible = false
        findViewById<View>(R.id.progressBar).isVisible = true

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                 viewModel.viewState.collect { viewState ->
                     Log.d(LOG_TAG, "$viewState")
                     renderViewState(viewState)
                 }
            }
        }
    }

    private fun renderViewState(viewState: MainViewModel.ViewState){
        when (viewState) {
            is MainViewModel.ViewState.Loading -> {
                viewBinding.usersRecyclersView.isVisible =false
                viewBinding.progressBar.isVisible = true
            }
            is MainViewModel.ViewState.Data -> {
                viewBinding.usersRecyclersView.isVisible = true
                (viewBinding.usersRecyclersView.adapter as UserAdapter).apply{
                    userList = viewState.userList
                    notifyDataSetChanged()
                }
                viewBinding.progressBar.isVisible = false
            }
        }
    }

    private fun setupRecyclerView(): UserAdapter {
        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclersView)
        val adapter = UserAdapter()
        recyclerView.adapter = adapter
        val divider = resources.getDrawable(R.drawable.divider_user_list, theme)
        recyclerView.addItemDecoration(DividerUserList(divider))
        return adapter
    }




}