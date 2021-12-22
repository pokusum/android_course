package com.deniskutyavin.android_course.ui.likes

import androidx.fragment.app.viewModels
import com.deniskutyavin.android_course.R
import com.deniskutyavin.android_course.databinding.FragmentLikesBinding
import com.deniskutyavin.android_course.ui.base.BaseFragment

class LikesFragment : BaseFragment(R.layout.fragment_likes) {
    private val viewBinding by viewBinding(FragmentLikesBinding::bind)

    private val viewModel: LikesViewModel by viewModels()
}