package com.idn.iyxan.prayers.dhikr.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.iyxan.prayers.dhikr.R
import com.idn.iyxan.prayers.dhikr.adapter.PrayerDhikrAdapter
import com.idn.iyxan.prayers.dhikr.databinding.ActivityDzikirPagiBinding
import com.idn.iyxan.prayers.dhikr.databinding.ActivityDzikirPetangBinding
import com.idn.iyxan.prayers.dhikr.model.PrayerDhikrData

class DzikirPetangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Dzikir Pagi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPetang.adapter = PrayerDhikrAdapter(PrayerDhikrData.listDataDzikirPetang)
        binding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}