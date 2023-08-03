package com.company0ne.sharedpreferencedemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GetData:AppCompatActivity() {
    //Declare the View where we want to update the user entered data
     private lateinit var nameOutput: TextView
     private lateinit var ageOutput: TextView

     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_get_data)

         //find the id of the views
          nameOutput = findViewById(R.id.getName)
          ageOutput = findViewById(R.id.getAge)
     }
    //we use resume method
      override fun onResume() {
               super.onResume()

               //and get Data inside it
               val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
               val getName = sharedPreferences.getString("name", "")
               val getAge = sharedPreferences.getString("age", "")

                //update our textView from the user entered data
                nameOutput.text = getName
                ageOutput.text = getAge
          }
     }
