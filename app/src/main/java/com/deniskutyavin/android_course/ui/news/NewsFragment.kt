package com.deniskutyavin.android_course.ui.news

import androidx.fragment.app.viewModels
import com.deniskutyavin.android_course.R
import com.deniskutyavin.android_course.databinding.FragmentNewsBinding
import com.deniskutyavin.android_course.ui.base.BaseFragment
import com.deniskutyavin.android_course.ui.news.NewsViewModel


class NewsFragment : BaseFragment(R.layout.fragment_news) {
    private val viewBinding by viewBinding(FragmentNewsBinding::bind)

    private val viewModel: NewsViewModel by viewModels()
}