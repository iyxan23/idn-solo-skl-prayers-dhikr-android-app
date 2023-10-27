package com.idn.iyxan.prayers.dhikr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.iyxan.prayers.dhikr.databinding.ItemArticleBinding
import com.idn.iyxan.prayers.dhikr.model.Article
import com.idn.iyxan.prayers.dhikr.utils.ArticleItemCallback

class ArticleAdapter(
    private val articles: List<Article>,
    private val callback: ArticleItemCallback?
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position];

        holder.imgArticle.setImageResource(article.imageArtikel)
        holder.itemView.setOnClickListener {
            callback?.onItemClick(article)
        }
    }

    inner class ViewHolder(itemView: ItemArticleBinding) : RecyclerView.ViewHolder(itemView.root) {
        val imgArticle = itemView.imgArtikel;
    }
}