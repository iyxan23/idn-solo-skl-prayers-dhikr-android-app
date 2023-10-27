package com.idn.iyxan.prayers.dhikr.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.iyxan.prayers.dhikr.adapter.PrayerDhikrAdapter
import com.idn.iyxan.prayers.dhikr.databinding.ActivitySetiapSaatDzikirBinding
import com.idn.iyxan.prayers.dhikr.model.PrayerDhikrData

class SetiapSaatDzikirActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetiapSaatDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivitySetiapSaatDzikirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PrayerDhikrAdapter(PrayerDhikrData.listDataDzikir)
        binding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)
        binding.rvDzikirSetiapSaat.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}