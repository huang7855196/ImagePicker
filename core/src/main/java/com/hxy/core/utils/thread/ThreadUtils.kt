package com.hxy.core.utils.thread

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


/**
 * desc:协成管理类
 * @author hxy on 2020/7/16
 * E-Mail Address：yang7855196@163.com
 **/
object ThreadUtils {
    var mThreads: HashMap<String, ArrayList<Job>> = HashMap()


    fun runOnAnyThread(token: String = "default", runnable: () -> Unit) : ThreadUtils{
        var job = GlobalScope.launch(Dispatchers.IO) {
            runnable()
        }
        putJobs(token, job)
        return this
    }

    fun runOnUiThread(token: String = "default", runnable: () -> Unit)  : ThreadUtils{
        var job = GlobalScope.launch(Dispatchers.Main) {
            runnable()
        }
        putJobs(token, job)
        return this
    }

    private fun putJobs(token: String, job: Job) {
        var jobs = mThreads.get(token)
        if (jobs == null) {
            jobs = ArrayList()
        }
        jobs.add(job)
        mThreads.put(token, jobs)
    }

    fun cancelThread(token: String = "default") {
        var jobs = mThreads.get(token)
        jobs?.let {
            jobs.clear()
        }
    }
}