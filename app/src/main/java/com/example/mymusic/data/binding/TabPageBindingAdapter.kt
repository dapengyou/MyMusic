package com.example.mymusic.data.binding

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.example.architecture.ui.adapter.CommonViewPagerAdapter
import com.example.mymusic.R
import com.google.android.material.tabs.TabLayout

/**
 * @createTime: 2023/1/4
 * @author: lady_zhou
 * @Description: 和布局建立绑定的
 */
object TabPageBindingAdapter {
    @JvmStatic
    @BindingAdapter(value = ["initTabAndPage"], requireAll = false)
    fun initTabAndPage(tabLayout: TabLayout, initTabAndPage: Boolean) {
        if (initTabAndPage) {
            val count = tabLayout.tabCount
            val title = arrayOfNulls<String>(count)
            for (i in 0 until count) {
                val tab = tabLayout.getTabAt(i)
                if (tab != null && tab.text != null) {
                    title[i] = tab.text.toString()
                }
            }
            val viewPager: ViewPager = tabLayout.rootView.findViewById(R.id.view_pager)
            if (viewPager != null) {
                viewPager.adapter = CommonViewPagerAdapter(count, false, title)
                tabLayout.setupWithViewPager(viewPager)
            }
        }
    }
}