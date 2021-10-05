package com.example.wallmartstore

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var users = ArrayList<User>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        forgottext.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        var testuser = User("Phillipos", "Tadesse", "ptadesse@miu.edu", "phill")
        users.add(testuser)

        Signinbutton.setOnClickListener {
            if (valid(edittextemail.text.toString(),
                    ps.text.toString())) {
                val sp = Intent(this,
                    ShoppingActivity::class.java)
                sp.putExtra("email",
                    edittextemail.text.toString())
                startActivity(sp)
            } else {
                Toast.makeText(applicationContext,
                    "User Dos not Exist",
                    Toast.LENGTH_LONG). show()
            }
        }

        Createaccount.setOnClickListener {
            val sin = Intent(this,
                RegisterActivity::class.java)
            resultLauncher.launch(sin)
        }
    }
    private fun valid(email: String, password: String): Boolean {
        for (j in users)
          {
            if (j.uname == email
                && j.pword == password)
            {
                return true
            }
        }
        return false
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
     { result ->
        if (result.resultCode == Activity.RESULT_OK)
        {
            val d: Intent? = result.data
            val sur = d!!
                .getSerializableExtra("user")
            val nu = sur as User
            users.add(nu)
        }
    }



    private fun findUserByEmail(email: String): User {
        for (i in users) {
            if (i.uname == email) {
                return i
            }
        }
        return User()
    }


    fun forgotPassword(view: View) {
        val ie = edittextemail.text.toString()
        val fu = findUserByEmail(ie)

        if(fu.pword.isNotEmpty()) {
            val sendIntent = Intent(Intent.ACTION_SENDTO,
                Uri.parse("mailto:"))
            sendIntent.putExtra(Intent.EXTRA_EMAIL,
                arrayOf(ie))
            sendIntent.putExtra(Intent.EXTRA_SUBJECT,
                "Recovered password:")
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                "password is: ${fu.pword}")
            startActivity(Intent.createChooser(sendIntent,
                "Email Sending: "))
        }
        else
        {
            Toast.makeText(applicationContext,
                "Could not found: $ie", Toast.LENGTH_LONG).show()
        }
    }
}