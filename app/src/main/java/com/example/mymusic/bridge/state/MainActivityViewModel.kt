package com.example.mymusic.bridge.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @createTime: 2022/12/30
 * @author: lady_zhou
 * @Description:  MainActivityViewModel 用于 activity_main.xml
 */
class MainActivityViewModel : ViewModel() {
    // 首页需要记录抽屉布局的情况 （响应的效果，都让 抽屉控件干了）
    @JvmField //在Java中调用的时候，可以直接使用属性名，而不是对应的getter方法。
    val openDrawer = MutableLiveData<Boolean>()

    // （响应的效果，都让 抽屉控件干了）
    @JvmField
    val allowDrawerOpen = MutableLiveData<Boolean>()

    // 构造代码块
    init {
        allowDrawerOpen.value = true
    }
}