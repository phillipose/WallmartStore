package com.example.wallmartstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private var user: User = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        button_register.setOnClickListener {
            if (checkingValidity())
            {
                Toast.makeText(
                    applicationContext,
                    "successfully Created!!",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent()
                intent.putExtra("user", user)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
    private fun checkingValidity(): Boolean {

        user.uname = edittextemail.text.toString()
        user.lname = lastname.text.toString()
        user.pword = ps.text.toString()
        user.fname = firstname.text.toString()
        if (user.fname.isEmpty()
            || user.lname.isEmpty()
            || user.uname.isEmpty()
            || user.pword.isEmpty()) {
            Toast.makeText(
                applicationContext,
                "fill all please",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }


}