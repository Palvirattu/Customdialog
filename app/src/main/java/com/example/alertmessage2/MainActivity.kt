package com.example.alertmessage2

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.aninterface.R
import com.example.aninterface.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnclear.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Do you want to clear")
                .setCancelable(false)
                .setPositiveButton("yes") { _, _ ->
                    Toast.makeText(this, "Data cleared successfully", Toast.LENGTH_LONG)
                        .show()
                }

                .setNegativeButton("No") { _, _ ->
                    Toast.makeText(this, "Data is not clear", Toast.LENGTH_LONG).show()
                }
                .show()
        }
        binding.btnupdate.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.customedialog)
            var btnok = dialog.findViewById<Button>(R.id.btnok)
            var etname2 = dialog.findViewById<EditText>(R.id.etname2)
            etname2.setText(binding.etname.text.toString())
            var etcollage = dialog.findViewById<EditText>(R.id.etcollage)
            etcollage.setText(binding.etcname.text.toString())
            btnok.setOnClickListener {
                if (etname2.text.toString().isNullOrEmpty()) {
                    etname2.error = "Enter your name"
                } else if (etcollage.text.toString().isNullOrEmpty()) {
                    etcollage.error = "Enter your collage name"
                } else {
                    binding.etname.setText(etname2.text.toString())
                    binding.etcname.setText(etcollage.text.toString())
                    dialog.dismiss()
                }
                dialog.show()
            }
        }


    }
}

