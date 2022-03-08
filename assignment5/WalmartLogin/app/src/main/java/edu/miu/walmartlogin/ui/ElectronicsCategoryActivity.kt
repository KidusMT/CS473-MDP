package edu.miu.walmartlogin.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.miu.walmartlogin.R
import edu.miu.walmartlogin.adapter.CategoryAdapter
import edu.miu.walmartlogin.data.Product
import edu.miu.walmartlogin.databinding.ActivityElectronicsItemBinding

class ElectronicsCategoryActivity : AppCompatActivity(), CategoryAdapter.Callback {

    private lateinit var binding: ActivityElectronicsItemBinding
    private val productList = mutableListOf(
        Product("HP Flyer Red 15.6 \" Laptop", "$435", "Red", R.drawable.laptop, 1236L, "Nice laptop."),
        Product("RCA Voyager 7\" 16GB android tablet", "$35", "Blue", R.drawable.tablet, 123L, "Nice tablet."),
        Product("Vizio 70\" class 4K", "$235", "Black", R.drawable.tv, 1234L, "Nice TV Screen."),
        Product("EPSON workforce WF-2750", "$135", "Black", R.drawable.scanner, 1235L, "Nice Scanner.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectronicsItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CategoryAdapter(this, productList)
        adapter.setCallback(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(product: Product?) {
        Toast.makeText(this, "${product?.title} Clicked", Toast.LENGTH_LONG).show()
    }
}