package com.idn.iyxan.prayers.dhikr.ui.detail

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idn.iyxan.prayers.dhikr.databinding.ActivityDetailArtikelBinding
import com.idn.iyxan.prayers.dhikr.model.Article

class DetailArtikelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailArtikelBinding

    companion object {
        const val DATA_TITLE = "title"
        const val DATA_DESC = "data"
        const val DATA_IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islam"

        super.onCreate(savedInstanceState)
        binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article = when {
            SDK_INT >= 33 -> intent.getParcelableExtra("data", Article::class.java)
            // suppress: getParcelableExtra is available in SDK_INT lower than 32
            else -> @Suppress("DEPRECATION") intent.getParcelableExtra("data") as Article?
        }!!

        binding.apply {
            tvDetailTitle.text = article.titleArtikel
            tvDetailDesc.text = article.descArtikel
            imgDetail.setImageResource(article.imageArtikel)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}