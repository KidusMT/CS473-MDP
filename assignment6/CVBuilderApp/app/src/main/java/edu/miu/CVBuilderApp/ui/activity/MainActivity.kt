package edu.miu.CVBuilderApp.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.miu.CVBuilderApp.ui.dialog.SettingsDialog


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var result: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Create an object for the Adapter Class
        val adapter = MyViewAdapter(supportFragmentManager,lifecycle)
        // Set the Adapter to your Viewpager UI
        binding.pager.adapter = adapter
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        /* Setting up Tab Layout with the ViewPageg2 is handled by the TabLayoutMediator
        * by passing your tablayout id and viewpager id*/
        TabLayoutMediator(binding.tabLayout,binding.pager){tab,position->
            when(position){
                0->{
                    tab.text="Home"
//                    tab.setIcon(R.drawable.home)
                }
                1->{
                    tab.text="About Me"
//                    tab.setIcon(R.drawable.help)
                }
                2->{
                    tab.text="Work"
//                    tab.setIcon(R.drawable.work)
                }
                3->{
                    tab.text = "Contact"
//                    tab.setIcon(R.drawable.contact)
                }
            }
        }.attach()

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.menu_main_setting) {
                showNoticeDialog()
                return@setOnMenuItemClickListener true
            } else false
        }
    }

    private fun showNoticeDialog() {
        val dialog = SettingsDialog()
        dialog.show(supportFragmentManager, "SettingsFragment")
    }

}