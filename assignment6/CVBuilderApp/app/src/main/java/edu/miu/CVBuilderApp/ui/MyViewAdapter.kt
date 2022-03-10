package edu.miu.CVBuilderApp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutkotlinlibrary.ContactFragment
import com.example.tablayoutkotlinlibrary.HomeFragment
import com.miu.tabviewpager.HelpFragment
import com.miu.tabviewpager.WorkFragment

class MyViewAdapter(fm:FragmentManager,lc:Lifecycle) : FragmentStateAdapter(fm,lc) {
    // How many Fragments - Returns the total number of items in the data set held by the adapter.
    override fun getItemCount(): Int = 4
    // Provide a new Fragment associated with the specified position.
    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> HelpFragment()
            2-> WorkFragment()
            3-> ContactFragment()
            else-> Fragment()
        }
    }
}

