package com.example.mylogintomain

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class LoginActivity : AppCompatActivity() {
    private val mTag = LoginActivity::class.java.name
    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var editTextAccount = findViewById<EditText>(R.id.editTextTextPersonName)
        var editTextPassword = findViewById<EditText>(R.id.editTextTextPassword)

        val btnSubmit =  findViewById<Button>(R.id.button3)

        context = applicationContext


        btnSubmit.setOnClickListener {
            //Log.e(mTag, "account = ${editTextAccount.text}")
            // Log.e(mTag, "password = ${editTextPassword.text}")

            if (editTextAccount.text.toString()  == "account" &&
                editTextPassword.text.toString() == "password") {

                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra("VALUE_ACCOUNT", editTextAccount.text.toString())
                intent.putExtra("VALUE_PASSWORD", editTextPassword.text.toString())
                startActivity(intent)
            } else {
                Log.e(mTag, "account or password mismatch!")
                toast("account or password mismatch!")
            }
            //toast("HELLO WORLD")
        }


    }

    private fun toast(message: String) {

        val toast = Toast.makeText(context, HtmlCompat.fromHtml("<h1>$message</h1>", HtmlCompat.FROM_HTML_MODE_COMPACT), Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)

        toast.show()
    }
}