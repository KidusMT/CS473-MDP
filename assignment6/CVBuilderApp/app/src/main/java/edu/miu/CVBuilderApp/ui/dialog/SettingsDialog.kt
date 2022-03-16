package edu.miu.CVBuilderApp.ui.dialog

import CVBuilderApp.R
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import edu.miu.CVBuilderApp.ui.activity.DialogCommunicator
import edu.miu.CVBuilderApp.utils.Utils

class SettingsDialog : DialogFragment() {
    private lateinit var communicator: DialogCommunicator
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
         val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;
            val view = inflater.inflate(R.layout.dialog_settings, null)


            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(view).apply {
                view.findViewById<Button>(R.id.btn_cancel)?.setOnClickListener{dismiss()}
                view.findViewById<RadioButton>(R.id.radio_dark).setOnClickListener { v ->
                    val radio = v as RadioButton
                    val checked = radio.isChecked
                    when (v.id) {
                        R.id.radio_dark ->
                            if (checked) communicator.onChangeTheme(Utils.DARK)
                    }
                    dismiss()
                }
                view.findViewById<RadioButton>(R.id.radio_light).setOnClickListener { v ->
                    val radio = v as RadioButton
                    val checked = radio.isChecked
                    when (v.id) {
                        R.id.radio_light ->
                            if (checked) communicator.onChangeTheme(Utils.LIGHT)
                    }
                    dismiss()
                }
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = context as DialogCommunicator
    }
}