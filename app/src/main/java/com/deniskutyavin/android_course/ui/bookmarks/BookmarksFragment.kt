package com.deniskutyavin.android_course.ui.bookmarks

import androidx.fragment.app.viewModels
import com.deniskutyavin.android_course.R
import com.deniskutyavin.android_course.databinding.FragmentBookmarksBinding
import com.deniskutyavin.android_course.ui.base.BaseFragment
import com.deniskutyavin.android_course.ui.bookmarks.BookmarksViewModel

class BookmarksFragment : BaseFragment(R.layout.fragment_bookmarks) {
    private val viewBinding by viewBinding(FragmentBookmarksBinding::bind)

    private val viewModel: BookmarksViewModel by viewModels()
}