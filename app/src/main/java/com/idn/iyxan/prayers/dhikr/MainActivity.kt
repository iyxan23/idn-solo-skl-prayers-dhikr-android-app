package com.idn.iyxan.prayers.dhikr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.idn.iyxan.prayers.dhikr.adapter.ArticleAdapter
import com.idn.iyxan.prayers.dhikr.databinding.ActivityMainBinding
import com.idn.iyxan.prayers.dhikr.model.Article
import com.idn.iyxan.prayers.dhikr.ui.HarianDzikirDoaActivity
import com.idn.iyxan.prayers.dhikr.ui.PagiPetangDzikirActivity
import com.idn.iyxan.prayers.dhikr.ui.QauliyahShalatActivity
import com.idn.iyxan.prayers.dhikr.ui.SetiapSaatDzikirActivity
import com.idn.iyxan.prayers.dhikr.ui.detail.DetailArtikelActivity
import com.idn.iyxan.prayers.dhikr.ui.detail.DzikirPetangActivity
import com.idn.iyxan.prayers.dhikr.utils.ArticleItemCallback

class MainActivity : AppCompatActivity() {

    private var keep = true
    private var runner = Runnable { keep = false }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
            .setKeepOnScreenCondition { keep }

        Handler(Looper.getMainLooper())
            .postDelayed(runner, 2000)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        initView()
        setupViewPager()
    }

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in articlesData.indices) {
                sliderIndicators[i].setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }

            sliderIndicators[position].setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    private val sliderIndicators: List<ImageView> by lazy {
        val sliderDotParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )

        sliderDotParams.setMargins(8, 8, 8, 8)
        sliderDotParams.gravity = Gravity.CENTER_VERTICAL;

        (0..articlesData.size).map { idx ->
            ImageView(this).apply {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        this@MainActivity,
                        if (idx == 0) R.drawable.dot_active else R.drawable.dot_inactive
                    )
                )

                binding.llSliderDots.addView(this, sliderDotParams)
            }
        }
    }

    private fun setupViewPager() {
        // evaluate the lazy delegate
        sliderIndicators
    }

    private fun initView() {
        binding.cardDzikirDoaShalat.setOnClickListener {
            startActivity(Intent(this, QauliyahShalatActivity::class.java))
        }

        binding.cardDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }

        binding.cardDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
        }

        binding.cardDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }

        binding.vpArtikel.adapter = ArticleAdapter(articlesData, object : ArticleItemCallback {
            override fun onItemClick(item: Article) {
                val intent = Intent(this@MainActivity, DetailArtikelActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }
        })
        binding.vpArtikel.registerOnPageChangeCallback(slidingCallback)
    }

    private val articlesData: List<Article> by lazy {
        val titles = resources.getStringArray(R.array.arr_title_artikel)
        val contents = resources.getStringArray(R.array.arr_desc_artikel)
        val images = resources.obtainTypedArray(R.array.arr_img_artikel)

        try {
            titles.zip(contents).mapIndexed { index, it ->
                val title = it.first
                val content = it.second

                Article(images.getResourceId(index, 0), title, content)
            }
        } finally {
            images.recycle();
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        binding.vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }
}