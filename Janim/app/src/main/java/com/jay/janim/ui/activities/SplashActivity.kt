package com.jay.janim.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.jay.janim.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler()

        handler.postDelayed({
            handler.postDelayed({
                binding.view.visibility = View.VISIBLE
            },500)

            handler.postDelayed({
                binding.view2.visibility = View.VISIBLE
            },800)

            handler.postDelayed({
                binding.view3.visibility = View.VISIBLE
            },1200)

            handler.postDelayed({
                binding.view4.visibility = View.VISIBLE
            },1500)

            handler.postDelayed({
                binding.intro.visibility = View.VISIBLE
            },1900)

            handler.postDelayed({
                startActivity(Intent(this,LockActivity::class.java))
                finish()
            },4100)
        },3500)

    }
}