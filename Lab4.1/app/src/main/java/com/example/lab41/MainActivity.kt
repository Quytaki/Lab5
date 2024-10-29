package com.example.lab41

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val email = emailInput.text.toString()
            val phone = phoneInput.text.toString()

            if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && phone.matches("\\d+".toRegex())) {
                Toast.makeText(this, "Email và số điện thoại hợp lệ!", Toast.LENGTH_SHORT).show()
            } else {
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Email không hợp lệ!", Toast.LENGTH_SHORT).show()
                }
                if (!phone.matches("\\d+".toRegex())) {
                    Toast.makeText(this, "Số điện thoại không hợp lệ!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
