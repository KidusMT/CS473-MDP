package edu.miu.CVBuilderApp.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityMainBinding
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.miu.CVBuilderApp.ui.dialog.SettingsDialog
import edu.miu.CVBuilderApp.utils.AppUtils
import edu.miu.CVBuilderApp.utils.Utils


class MainActivity : AppCompatActivity(), DialogCommunicator {

    private lateinit var binding: ActivityMainBinding
    private var result: Long = 0
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = AppUtils.setPref(this)

        val theme = sharedPref.getString(getString(R.string.saved_theme), "")
        if(theme!=null) decideTheme(theme)

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

    override fun onChangeTheme(theme: String) {
        with (sharedPref.edit()) {
            this?.putString(getString(R.string.saved_theme), theme)
            this?.apply()
        }

        decideTheme(theme)
    }

    fun decideTheme(theme: String){
        if(theme== Utils.DARK) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}