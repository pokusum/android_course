package com.deniskutyavin.android_course.ui.profile

import androidx.fragment.app.viewModels
import com.deniskutyavin.android_course.R
import com.deniskutyavin.android_course.databinding.FragmentProfileBinding
import com.deniskutyavin.android_course.ui.base.BaseFragment

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {
    private val viewBinding by viewBinding(FragmentProfileBinding::bind)

    private val viewModel: ProfileViewModel by viewModels()
}