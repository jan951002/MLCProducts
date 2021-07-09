package com.jan.melichallenge.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.jan.melichallenge.R
import com.jan.melichallenge.ui.base.BaseActivity
import com.jan.melichallenge.databinding.ActivitySplashBinding
import com.jan.melichallenge.ui.main.MainActivity
import kotlinx.coroutines.delay

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    companion object {
        private const val SPLASH_TIME_OUT = 2000L
    }

    override fun layoutRes(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            delay(SPLASH_TIME_OUT)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}