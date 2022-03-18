package edu.miu.walmartlogin.adapter

import CVBuilderApp.R
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.miu.CVBuilderApp.data.Work

class WorkAdapter(val context: Context, val workList: MutableList<Work>) :
    RecyclerView.Adapter<BaseViewHolder?>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): BaseViewHolder {
        val itemEvents: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_work, viewGroup, false)
        return AssignedTasksViewHolder(itemEvents)
    }

    fun addWork(work: Work){
        workList.add(work)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(baseViewHolder: BaseViewHolder, i: Int) {
        baseViewHolder.onBind(i)
    }

    override fun getItemCount(): Int = workList.size

    inner class AssignedTasksViewHolder(view: View?) : BaseViewHolder(view) {
        var title: TextView? = view?.findViewById(R.id.rv_work_title)
        var image: ImageView? = view?.findViewById(R.id.rv_work_logo)
        var workPosition: TextView? = view?.findViewById(R.id.rv_work_position)
        var duration: TextView? = view?.findViewById(R.id.rv_work_duration)

        @SuppressLint("NotifyDataSetChanged")
        override fun onBind(position: Int) {
            super.onBind(position)
            val product = workList[position]

            image?.setBackgroundResource(product.image)
            title?.text = product.title
            workPosition?.text = product.position
            duration?.text = product.duration
        }
    }
}