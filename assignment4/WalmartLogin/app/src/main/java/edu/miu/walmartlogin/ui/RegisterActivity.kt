package edu.miu.walmartlogin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.miu.walmartlogin.databinding.ActivityMainBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onCreateAccount(view: android.view.View) {}
}