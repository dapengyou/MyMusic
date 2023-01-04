package com.example.mymusic.data.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.example.architecture.utils.ClickUtils

/**
 * @createTime: 2023/1/4
 * @author: lady_zhou
 * @Description: 和布局建立绑定的
 */
object CommonBindingAdapter {
    @JvmStatic
    @BindingAdapter(value = ["onClickWithDebouncing"], requireAll = false)
    fun onClickWithDebouncing(view: View?, clickListener: View.OnClickListener?) {
        ClickUtils.applySingleDebouncing(view, clickListener)
    }
}