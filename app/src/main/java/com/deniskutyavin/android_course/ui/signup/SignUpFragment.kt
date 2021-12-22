package com.deniskutyavin.android_course.ui.signup

import androidx.fragment.app.viewModels
import com.deniskutyavin.android_course.R
import com.deniskutyavin.android_course.ui.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.deniskutyavin.android_course.databinding.FragmentSignUpBinding
import com.deniskutyavin.android_course.ui.signin.SignInViewModel


class SignUnFragment : BaseFragment(R.layout.fragment_sign_up) {
    private val viewBinding by viewBinding(FragmentSignUpBinding::bind)

    private val viewModel: SignInViewModel by viewModels()
}