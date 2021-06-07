package com.github.sasakitomohiro.dynamicfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.sasakitomohiro.dynamicfeature.databinding.ActivityDfmBinding

internal class DFMActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityDfmBinding>(this, R.layout.activity_dfm)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding
    }
}
