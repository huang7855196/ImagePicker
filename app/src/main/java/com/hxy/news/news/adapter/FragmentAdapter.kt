package com.hxy.news.news.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hxy.news.news.model.NewsChannelEntity

/**
 * desc:
 * @author tuoxie on 2020/7/17
 * E-Mail Address：tuoxie@gaoding.com
 **/
class FragmentAdapter(fm: FragmentManager, tabs: ArrayList<Fragment>) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    val tabs: ArrayList<Fragment> = tabs

    override fun getPageTitle(position: Int): CharSequence? {
        return "title"
    }

    override fun getItem(position: Int): Fragment {
        return tabs.get(position)
    }

    override fun getCount(): Int {
        return tabs.size
    }

}