package com.company0ne.sharedpreferencedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    //Declare the all views
    private lateinit var age: EditText
    private lateinit var name: EditText
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find the all view
        name = findViewById(R.id.edit1)
        age = findViewById(R.id.edit2)
        button = findViewById(R.id.button)

        // Load the saved data from SharedPreferences or entered by the User
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        name.setText(sharedPreferences.getString("name", ""))
        age.setText(sharedPreferences.getString("age", ""))
        //if u remove only this block(Line 27-31), the user stored data is not displayed in EditText


        //set onClickListener
        button.setOnClickListener {

            val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            // write all the data entered by the user in SharedPreference and apply
            editor.putString("name", name.text.toString())
            editor.putString("age", age.text.toString())
            editor.apply()

            // Start-Pass Data to GetData activity
            val intent = Intent(this@MainActivity, GetData::class.java)
            startActivity(intent)
        }
    }
}
