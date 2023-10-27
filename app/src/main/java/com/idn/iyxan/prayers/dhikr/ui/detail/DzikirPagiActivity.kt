package com.idn.iyxan.prayers.dhikr.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.iyxan.prayers.dhikr.R
import com.idn.iyxan.prayers.dhikr.adapter.PrayerDhikrAdapter
import com.idn.iyxan.prayers.dhikr.databinding.ActivityDzikirPagiBinding
import com.idn.iyxan.prayers.dhikr.model.PrayerDhikrData
import com.idn.iyxan.prayers.dhikr.model.PrayerDhikrItem

class DzikirPagiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Dzikir Pagi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPagi.adapter = PrayerDhikrAdapter(PrayerDhikrData.listDataDzikirPagi)
        binding.rvDzikirPagi.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}