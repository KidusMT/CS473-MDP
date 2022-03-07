package edu.miu.walmartlogin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.miu.walmartlogin.databinding.ActivityElectronicsItemBinding

class ElectronicsCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityElectronicsItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectronicsItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}