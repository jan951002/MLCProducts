package com.jan.melichallenge.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import com.jan.melichallenge.R
import com.jan.melichallenge.ui.base.BaseActivity
import com.jan.melichallenge.databinding.ActivitySplashBinding
import com.jan.melichallenge.ui.main.MainActivity
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay

private const val SPLASH_TIME_OUT = 2000L

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    override fun layoutRes(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            val animation = AnimationUtils.loadAnimation(
                this@SplashActivity, R.anim.bottom_to_original
            )
            binding.splashImage.animation = animation
            delay(SPLASH_TIME_OUT)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        lifecycleScope.cancel()
        super.onDestroy()
    }
}
