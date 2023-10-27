package com.idn.iyxan.prayers.dhikr.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.iyxan.prayers.dhikr.R
import com.idn.iyxan.prayers.dhikr.adapter.PrayerDhikrAdapter
import com.idn.iyxan.prayers.dhikr.databinding.ActivityQauliyahShalatBinding
import com.idn.iyxan.prayers.dhikr.model.PrayerDhikrData

class QauliyahShalatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQauliyahShalatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityQauliyahShalatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PrayerDhikrAdapter(PrayerDhikrData.listDataQauliyah)

        binding.rvQauliyahShalat.layoutManager = LinearLayoutManager(this)
        binding.rvQauliyahShalat.adapter = adapter;
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}