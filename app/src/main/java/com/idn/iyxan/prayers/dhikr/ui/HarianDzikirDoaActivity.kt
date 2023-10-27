package com.idn.iyxan.prayers.dhikr.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.iyxan.prayers.dhikr.R
import com.idn.iyxan.prayers.dhikr.adapter.PrayerDhikrAdapter
import com.idn.iyxan.prayers.dhikr.databinding.ActivityHarianDzikirDoaBinding
import com.idn.iyxan.prayers.dhikr.model.PrayerDhikrItem

class HarianDzikirDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PrayerDhikrAdapter(dhikrData)
        binding.rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
        binding.rvDzikirDoaHarian.adapter = adapter
    }

    private val dhikrData: List<PrayerDhikrItem> by lazy {
        val titles = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafadzs = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translations = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        titles.zip(lafadzs).zip(translations).map {
            val desc = it.first.first
            val lafadz = it.first.second
            val translation = it.second

            PrayerDhikrItem(desc, lafadz, translation)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}