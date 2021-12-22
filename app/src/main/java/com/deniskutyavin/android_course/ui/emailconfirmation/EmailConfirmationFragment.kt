package com.deniskutyavin.android_course.ui.emailconfirmation

import androidx.fragment.app.viewModels
import com.deniskutyavin.android_course.ui.base.BaseFragment
import com.deniskutyavin.android_course.R
import com.deniskutyavin.android_course.ui.signin.SignInViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import com.deniskutyavin.android_course.databinding.FragmentEmailConfirmationBinding

class EmailConfirmationFragment : BaseFragment(R.layout.fragment_email_confirmation) {
    private val viewBinding by viewBinding(FragmentEmailConfirmationBinding::bind)


    private val viewModel: SignInViewModel by viewModels()
}