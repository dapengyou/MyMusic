package com.example.mymusic.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mymusic.R
import com.example.mymusic.bridge.state.SearchViewModel
import com.example.mymusic.databinding.FragmentSearchBinding

/**
 * @createTime: 2023/1/4
 * @author: lady_zhou
 * @Description:
 */
class SearchFragment : Fragment() {
    private var searchViewModel: SearchViewModel? = null
    private var searchBinding: FragmentSearchBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchViewModel = getFragmentViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_search, container, false)
        searchBinding = FragmentSearchBinding.bind(view)

        return view
    }

    // 给所有的 子fragment提供的函数，可以顺利的拿到 ViewModel 【非共享区域的ViewModel】
    protected fun getFragmentViewModelProvider(fragment: Fragment): ViewModelProvider {
        return ViewModelProvider(fragment, fragment.defaultViewModelProviderFactory)
    }
}