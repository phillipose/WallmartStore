package com.example.wallmartstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        supportActionBar?.title = "Shop by Category"

        var log = intent.getStringExtra("email")
        viewlogin.text = log
    }

   
    fun selected(v: View?) {
        when (v?.id) {
            R.id.e -> {
                val toast_electronics = Toast.makeText(applicationContext,
                    "Electronics  category  selected", Toast.LENGTH_SHORT)
                  toast_electronics.show()
            }
            R.id.c -> {
                val toast_clothes = Toast.makeText(applicationContext,
                    " Clothing  category  selected", Toast.LENGTH_SHORT)
                toast_clothes.show()
            }
            R.id.b -> {
                val toast_beauty = Toast.makeText(applicationContext,
                    "  Beauty  category  selected", Toast.LENGTH_SHORT)
                toast_beauty.show()
            }
            R.id.f -> {
                val toast_food = Toast.makeText(applicationContext,
                    "Food  category  selected", Toast.LENGTH_SHORT)
                toast_food.show()
            }
            else -> { val toast_food = Toast.makeText(applicationContext,
                "Select Some category ", Toast.LENGTH_SHORT)
                toast_food.show()

            }
        }
    }


}