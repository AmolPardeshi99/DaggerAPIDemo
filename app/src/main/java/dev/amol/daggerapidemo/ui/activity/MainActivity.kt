package dev.amol.daggerapidemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.daggerapidemo.R
import dev.amol.daggerapidemo.data.remote.responsedata.Article
import dev.amol.daggerapidemo.databinding.ActivityMainBinding
import dev.amol.daggerapidemo.ui.adapter.DaggerDemoAdapter
import dev.amol.daggerapidemo.viewmodel.DaggerDemoViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val daggerDemoViewModel: DaggerDemoViewModel by viewModels()
    lateinit var activityMainBinding: ActivityMainBinding
    private var articleList = ArrayList<Article>()
    lateinit var daggerDemoAdapter: DaggerDemoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setRecycler()
        loadData()

    }


    private fun setRecycler() {
        daggerDemoAdapter = DaggerDemoAdapter(articleList)
        activityMainBinding.recyclerView.apply {
            adapter=daggerDemoAdapter
        }
    }

    private fun loadData() {
        daggerDemoViewModel.getAPIData()
        daggerDemoViewModel.articleListData.observe(this, Observer {
            if(it.status.equals("ok")){
                    articleList.clear()
                    articleList.addAll(it.articles)
                daggerDemoAdapter.notifyDataSetChanged()
                }
        })
    }
}