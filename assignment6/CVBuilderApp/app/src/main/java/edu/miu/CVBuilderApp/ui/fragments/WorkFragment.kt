package edu.miu.CVBuilderApp.ui.fragments

import CVBuilderApp.R
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.miu.CVBuilderApp.data.Work
import edu.miu.walmartlogin.adapter.WorkAdapter

class WorkFragment : Fragment(R.layout.fragment_work) {

    private var workList = mutableListOf<Work>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        if(context!=null){
            workList = mutableListOf(
                Work(
                    getString(R.string.meta_facebook_inc),
                    getString(R.string.virtual_reality_content_engineer),
                    getString(R.string._2020_present),
                    R.drawable.meta
                ),
                Work(
                    getString(R.string.google),
                    getString(R.string.application_developer_for_youtube),
                    getString(R.string._2018_2020),
                    R.drawable.google
                ),
                Work(
                    getString(R.string.amazon),
                    getString(R.string.sde_ii),
                    getString(R.string._2016_2018),
                    R.drawable.amazon
                ),
                Work(
                    getString(R.string.kforce),
                    getString(R.string.sr_full_stack_engineer),
                    getString(R.string._2014_2016),
                    R.drawable.kforce
                )
            )
            recyclerView.layoutManager = LinearLayoutManager(context)
            val adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Toast.makeText(context, "clicked", Toast.LENGTH_LONG).show()
        }
    }
}