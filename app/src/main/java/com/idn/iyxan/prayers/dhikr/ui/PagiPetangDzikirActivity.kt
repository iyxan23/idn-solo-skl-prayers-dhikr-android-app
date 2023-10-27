package com.idn.iyxan.prayers.dhikr.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.idn.iyxan.prayers.dhikr.R
import com.idn.iyxan.prayers.dhikr.databinding.ActivityPagiPetangDzikirBinding
import com.idn.iyxan.prayers.dhikr.ui.detail.DzikirPagiActivity
import com.idn.iyxan.prayers.dhikr.ui.detail.DzikirPetangActivity

class PagiPetangDzikirActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPagiPetangDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityPagiPetangDzikirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBtnDzikirPagi.setOnClickListener(this)
        binding.imgBtnDzikirPetang.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, DzikirPagiActivity::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(
                Intent(
                    this,
                    DzikirPetangActivity::class.java
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}