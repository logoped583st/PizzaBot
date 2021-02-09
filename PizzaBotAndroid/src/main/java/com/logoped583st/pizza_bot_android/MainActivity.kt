package com.logoped583st.pizza_bot_android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.logoped583st.androidApp.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                MainViewModel::class.java
            )

        val editText = findViewById<EditText>(R.id.editText)

        val pathView = findViewById<PathView>(R.id.pathView)

        viewModel.data.observe(this, {
            pathView.model = it
        })

        findViewById<Button>(R.id.submitPath).setOnClickListener {
            try {
                viewModel.requestData(editText.text.toString())
            } catch (e: Exception) {
                Snackbar.make(pathView, e.message ?: "", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
