package com.idn.iyxan.prayers.dhikr.utils

import com.idn.iyxan.prayers.dhikr.model.Article

interface ArticleItemCallback {
    fun onItemClick(item: Article)
}