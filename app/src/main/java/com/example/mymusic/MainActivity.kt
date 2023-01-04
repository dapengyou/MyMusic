package com.example.mymusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mymusic.bridge.state.MainActivityViewModel
import com.example.mymusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var mainBinding: ActivityMainBinding? = null
    var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel = getActivityViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainBinding ?.lifecycleOwner = this
        mainBinding ?.setVm(mainActivityViewModel)
    }
    // 此getActivityViewModelProvider函数，给所有的 BaseActivity 子类用的 【ViewModel非共享区域】
    protected fun getActivityViewModelProvider(activity: AppCompatActivity): ViewModelProvider {
        return ViewModelProvider(activity, activity.defaultViewModelProviderFactory)
    }
}