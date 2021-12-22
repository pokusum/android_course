package com.deniskutyavin.android_course.ui.main

import androidx.fragment.app.viewModels
import com.deniskutyavin.android_course.ui.base.BaseFragment
import com.deniskutyavin.android_course.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.deniskutyavin.android_course.databinding.FragmentMainBinding
import com.deniskutyavin.android_course.ui.signin.SignInViewModel

class MainFragment : BaseFragment(R.layout.fragment_main) {
    private val viewBinding by viewBinding(FragmentMainBinding::bind)

    private val viewModel: SignInViewModel by viewModels()
}