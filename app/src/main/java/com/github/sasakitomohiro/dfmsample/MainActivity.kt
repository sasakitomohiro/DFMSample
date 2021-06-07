package com.github.sasakitomohiro.dfmsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.sasakitomohiro.dfmsample.databinding.ActivityMainBinding
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

internal class MainActivity : AppCompatActivity() {
    companion object {
        private const val DFM_REQUEST_CODE = 0
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val splitInstallManager by lazy {
        SplitInstallManagerFactory.create(this)
    }

    private val listener = SplitInstallStateUpdatedListener { state ->
        when (state.status()) {
            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                splitInstallManager.startConfirmationDialogForResult(state, this, DFM_REQUEST_CODE)
            }
            SplitInstallSessionStatus.DOWNLOADING -> {
                // do something
            }
            SplitInstallSessionStatus.DOWNLOADED -> {
                // do something
            }
            SplitInstallSessionStatus.FAILED -> {
                // do something
            }
            SplitInstallSessionStatus.INSTALLING -> {
                // do something
            }
            SplitInstallSessionStatus.INSTALLED -> {
                // do something
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splitInstallManager.registerListener(listener)

        binding.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).setClassName(
                this,
                "com.github.sasakitomohiro.dynamicfeature.DFMActivity"
            )
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DFM_REQUEST_CODE) {
            // do something
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onDestroy() {
        splitInstallManager.unregisterListener(listener)
        super.onDestroy()
    }
}
