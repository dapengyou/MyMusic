package com.example.mymusic.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mymusic.R
import com.example.mymusic.bridge.state.MainViewModel
import com.example.mymusic.databinding.FragmentMainBinding

/**
 * @createTime: 2023/1/3
 * @author: lady_zhou
 * @Description:
 */
class MainFragment : Fragment() {
    private var mainViewModel: MainViewModel? = null
    private var mainBinding: FragmentMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = getFragmentViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_main, container, false)
        mainBinding = FragmentMainBinding.bind(view)

        mainBinding?.click = ClickProxy() // 设置点击事件，布局就可以直接绑定
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel!!.initTabAndPage.set(true)
    }

    inner class ClickProxy {
        // 当在首页点击 “菜单” 的时候，直接导航到 ---> 菜单的Fragment界面
        fun openMenu() {} // 触发

        // 当在首页点击 “搜索图标” 的时候，直接导航到 ---> 搜索的Fragment界面
        fun search() = nav().navigate(R.id.action_mainFragment_to_searchFragment)
    }

    // 给所有的 子fragment提供的函数，可以顺利的拿到 ViewModel 【非共享区域的ViewModel】
    protected fun getFragmentViewModelProvider(fragment: Fragment): ViewModelProvider {
        return ViewModelProvider(fragment, fragment.defaultViewModelProviderFactory)
    }

    protected fun nav(): NavController {
        return NavHostFragment.findNavController(this)
    }
}