package edu.miu.CVBuilderApp.ui.dialog

import CVBuilderApp.R
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import edu.miu.CVBuilderApp.data.Work

class WorkDialog : DialogFragment() {
    private lateinit var communicator: WorkDialogCommunicator
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.dialog_work, null)

            builder.setView(view).apply {
                view.findViewById<Button>(R.id.btn_cancel)?.setOnClickListener {
                    dismiss()
                }

                view.findViewById<Button>(R.id.btn_add)?.setOnClickListener {
                    val title = view.findViewById<EditText>(R.id.et_dialog_company).text.toString().trim()
                    val position = view.findViewById<EditText>(R.id.et_dialog_position).text.toString().trim()
                    val duration = view.findViewById<EditText>(R.id.et_dialog_duration).text.toString().trim()
                    validate(title, position, duration)
                    communicator.onAddWOrk(Work(title, position, duration, R.drawable.ic_work_placeholder))
                    dismiss()
                }

            }
            builder.create()
        } ?: throw IllegalStateException(getString(R.string.something_went_wrong))

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    fun validate(title: String, position: String, duration: String){
        if(title.isEmpty()){
            Toast.makeText(context, "Enter title", Toast.LENGTH_LONG).show()
            return
        }
        if(position.isEmpty()){
            Toast.makeText(context, "Enter position", Toast.LENGTH_LONG).show()
            return
        }
        if(duration.isEmpty()){
            Toast.makeText(context, "Enter duration", Toast.LENGTH_LONG).show()
            return
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = context as WorkDialogCommunicator
    }
}