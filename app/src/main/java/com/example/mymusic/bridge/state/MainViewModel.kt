package com.example.mymusic.bridge.state

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * @createTime: 2023/1/3
 * @author: lady_zhou
 * @Description: 首页Fragment 的 MainViewModel
 */
class MainViewModel : ViewModel() {
    // MainFragment初始化页面的标记 例如：“最近播放”  的记录
    @JvmField
    val initTabAndPage = ObservableBoolean() // ObservableBoolean 防止抖动，频繁改变，使用这个的场景

    // MainFragment “最佳实践” 里面的 WebView需要加载的网页链接路径
    @JvmField
    val pageAssetPath = ObservableField<String>()
}