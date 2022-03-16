package edu.miu.CVBuilderApp.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.miu.CVBuilderApp.ui.dialog.SettingsDialog
import edu.miu.CVBuilderApp.utils.Utils


class MainActivity : AppCompatActivity(), DialogCommunicator {

    private lateinit var binding: ActivityMainBinding
    private var result: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(if (someSettings.get(PREFFERED_THEME)) R.style.AppThemeLight else R.style.AppThemeDark)
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

    override fun onChangeTheme(theme: String) {
//        println(theme)
//        Toast.makeText(this, theme, Toast.LENGTH_LONG).show()
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        if(theme== Utils.DARK) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        AppSettings settings = AppSettings.getInstance(this);
//        settings.set(AppSettings.Key.USE_DARK_THEME,
//            !settings.getBoolean(AppSettings.Key.USE_DARK_THEME));
//        Intent intent = new Intent(this, <yourclass>.class);
//        startActivity(intent);
//        finish();
//        recreate()
    }

}