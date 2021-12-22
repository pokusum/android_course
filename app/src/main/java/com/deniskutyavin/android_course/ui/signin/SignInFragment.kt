package com.deniskutyavin.android_course.ui.signin

import androidx.fragment.app.viewModels
import com.deniskutyavin.android_course.ui.base.BaseFragment
import com.deniskutyavin.android_course.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.deniskutyavin.android_course.databinding.FragmentSignInBinding
import com.deniskutyavin.android_course.ui.signin.SignInViewModel

class SignInFragment : BaseFragment(R.layout.fragment_sign_in) {
    private val viewBinding by viewBinding(FragmentSignInBinding::bind)

    private val viewModel: SignInViewModel by viewModels()
}