package com.eu.electrolab

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                Calculator()
            }
            1 -> {
                Schematic()
            }
            2 -> {
                Learning()
            }
            else -> {
                throw  Resources.NotFoundException("position not found")
            }
        }
    }
}
