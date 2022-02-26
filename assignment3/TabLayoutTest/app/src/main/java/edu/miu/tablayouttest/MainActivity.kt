package edu.miu.tablayouttest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.miu.tablayouttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addRow("Android 9.0", "Pie")
        addRow("Android 8.0", "Oreo")

        binding.btnAdd.setOnClickListener {
            addRow(
                binding.etAndroidVersion.text.toString().trim(),
                binding.etAndroidCodeNm.text.toString().trim()
            )
        }

    }

    @SuppressLint("ResourceType")
    private fun addRow(versionName: String, codeName: String) {
        val tableRow = TableRow(this)

        val tvVersion = TextView(this)
        tvVersion.text = versionName

        val tvCodeName = TextView(this)
        tvCodeName.text = codeName

        tableRow.addView(tvVersion, 0)
        tableRow.addView(tvCodeName, 1)

        val tvVersionParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 5, 8, 0)
        }
        tvVersionParam.weight = 1f
        tvVersion.setBackgroundResource(R.color.table_row_bg)
        tvVersion.layoutParams = tvVersionParam

        val tvCodeNameParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 2, 0, 0)
        }
        tvCodeNameParam.weight = 1f
        tvCodeName.setBackgroundResource(R.color.table_row_bg)
        tvCodeName.layoutParams = tvCodeNameParam

        binding.androidTable.addView(tableRow)
    }
}