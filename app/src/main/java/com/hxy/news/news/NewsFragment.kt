package com.hxy.news.news

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.hxy.core.base.base.BaseFragment
import com.hxy.core.magicindicator.ViewPagerHelper
import com.hxy.core.magicindicator.buildins.commonnavigator.CommonNavigator
import com.hxy.core.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import com.hxy.core.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import com.hxy.core.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import com.hxy.core.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import com.hxy.core.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
import com.hxy.news.R
import com.hxy.news.news.adapter.FragmentAdapter
import com.hxy.news.news.fragment.NewFragment
import com.hxy.news.news.model.NewsChannelEntity
import com.hxy.news.news.presenter.NewsChannelModel
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * desc:
 * @author tuoxie on 2020/7/16
 * E-Mail Address：tuoxie@gaoding.com
 **/
class NewsFragment : BaseFragment() {
    override fun initView() {

    }

    override fun initData() {
        var model = ViewModelProviders.of(this).get<NewsChannelModel>(NewsChannelModel::class.java)
        model.getNewsChannel().observe(this, Observer {
            initTab(it)
            initViewPage(it)
        })
        model.loadChannel()
    }

    fun initTab(it: ArrayList<NewsChannelEntity>) {
        var mNavigator = CommonNavigator(context)
        mNavigator.scrollPivotX = 0.35f
        mNavigator.adapter = object : CommonNavigatorAdapter() {
            private var news: ArrayList<NewsChannelEntity> = it
            private var viewPager: ViewPager = vp_viewpager
            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                var titleView = SimplePagerTitleView(context)
                titleView.setText(news.get(index).title)
                titleView.selectedColor = Color.WHITE
                titleView.normalColor = Color.RED
                titleView.setOnClickListener {
                    viewPager.setCurrentItem(index)
                }
                return titleView
            }

            override fun getCount(): Int {
                return news.size
            }

            override fun getIndicator(context: Context?): IPagerIndicator {
                var indicator = LinePagerIndicator(context)
                return indicator
            }

        }
        mid_tab.navigator = mNavigator

    }

    fun initViewPage(news: ArrayList<NewsChannelEntity>) {
        var fragments = ArrayList<Fragment>();
        for (i in 0 until news.size) {
            var fragment = NewFragment()
            var bundle = Bundle()
            bundle.putString("id", news.get(i).id);
            fragment.arguments = bundle
            fragments.add(fragment)
        }
        vp_viewpager.adapter = FragmentAdapter(fragmentManager!!, fragments)
        ViewPagerHelper.bind(mid_tab, vp_viewpager)
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_news
    }
}