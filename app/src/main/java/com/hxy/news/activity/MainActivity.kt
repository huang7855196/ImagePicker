package com.hxy.news.activity

import androidx.fragment.app.FragmentTransaction
import com.hxy.core.base.base.BaseActivity
import com.hxy.news.R
import com.hxy.news.fragment.GirlFragment
import com.hxy.news.fragment.MineFragment
import com.hxy.news.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * desc:首页
 * @author hxy on 2020/7/14
 * E-Mail Address：yang7855196@163.com
 **/
class MainActivity : BaseActivity() {
    private val NEWS_TAB: String = "newsFragment"
    private val GIRL_TAB: String = "girlFragment"
    private val MINE_TAB: String = "mineFragment"

    private lateinit var mNewsFragment: NewsFragment
    private lateinit var mGirlFragment: GirlFragment
    private lateinit var mMineFragment: MineFragment


    override fun initView() {
        initFragment()
        initListener();
    }

    fun initListener() {
        tv_home.setOnClickListener {
            switchTab(NEWS_TAB)
        }
        tv_girl.setOnClickListener {
            switchTab(GIRL_TAB)
        }
        tv_mine.setOnClickListener {
            switchTab(MINE_TAB)
        }
    }

    fun initFragment() {
        mNewsFragment = NewsFragment()
        mGirlFragment = GirlFragment()
        mMineFragment = MineFragment()
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, mNewsFragment, NEWS_TAB)
        transaction.add(R.id.container, mGirlFragment, GIRL_TAB)
        transaction.add(R.id.container, mMineFragment, MINE_TAB)
        transaction.commit()
        switchTab(NEWS_TAB)
    }

    fun switchTab(tab: String) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        when (tab) {
            NEWS_TAB -> {
                transaction.hide(mGirlFragment)
                transaction.hide(mMineFragment)
                transaction.show(mNewsFragment)
                tv_home.setSelected(true)
                tv_girl.setSelected(false)
                tv_mine.setSelected(false)
            }
            GIRL_TAB -> {
                transaction.hide(mNewsFragment)
                transaction.hide(mMineFragment)
                transaction.show(mGirlFragment)
                tv_home.setSelected(false)
                tv_girl.setSelected(true)
                tv_mine.setSelected(false)
            }
            MINE_TAB -> {
                transaction.hide(mGirlFragment)
                transaction.hide(mNewsFragment)
                transaction.show(mMineFragment)
                tv_home.setSelected(false)
                tv_girl.setSelected(false)
                tv_mine.setSelected(true)
            }
            else -> {
                transaction.hide(mGirlFragment)
                transaction.hide(mMineFragment)
                transaction.show(mNewsFragment)
                tv_home.setSelected(true)
                tv_girl.setSelected(false)
                tv_mine.setSelected(false)
            }
        }
        transaction.commitAllowingStateLoss()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main;
    }
}