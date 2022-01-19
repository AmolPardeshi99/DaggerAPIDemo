package dev.amol.daggerapidemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.amol.daggerapidemo.R
import dev.amol.daggerapidemo.data.remote.responsedata.Article
import dev.amol.daggerapidemo.databinding.ItemLayoutBinding

class DaggerDemoAdapter(private val articleList:ArrayList<Article>):RecyclerView.Adapter<DaggerDemoAdapter.DaggerDemoViewHolder>() {

    class DaggerDemoViewHolder(val itemLayoutBinding: ItemLayoutBinding):RecyclerView.ViewHolder(itemLayoutBinding.root){
        fun setData(article: Article){
            itemLayoutBinding.dataClass = article
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaggerDemoViewHolder {
        return DaggerDemoViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: DaggerDemoViewHolder, position: Int) {
        val article = articleList[position]
        holder.setData(article)
    }

    override fun getItemCount(): Int = articleList.size
}