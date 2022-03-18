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
import edu.miu.CVBuilderApp.utils.AppUtils
import edu.miu.CVBuilderApp.utils.Utils

class SettingsDialog : DialogFragment() {
    private lateinit var communicator: DialogCommunicator
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.dialog_settings, null)

            val theme = AppUtils.getPref(getString(R.string.saved_theme))

            builder.setView(view).apply {
                view.findViewById<Button>(R.id.btn_cancel)?.setOnClickListener { dismiss() }
                val darkRB = view.findViewById<RadioButton>(R.id.radio_dark)
                val lightRB = view.findViewById<RadioButton>(R.id.radio_light)

                if (theme == Utils.DARK) darkRB.performClick() else lightRB.performClick()

                darkRB.setOnClickListener { v ->
                    val radio = v as RadioButton
                    val checked = radio.isChecked
                    when (v.id) {
                        R.id.radio_dark ->
                            if (checked) communicator.onChangeTheme(Utils.DARK)
                    }
                    dismiss()
                }
                lightRB.setOnClickListener { v ->
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
        } ?: throw IllegalStateException(getString(R.string.something_went_wrong))

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = context as DialogCommunicator
    }
}