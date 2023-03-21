package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPicker=findViewById<Button>(R.id.btnDatePicker)
        btnPicker.setOnClickListener { view->
            clickDatePicker(view)
        }
    }

    //@RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view:View){

        val myCalendar=Calendar.getInstance()
        val i=myCalendar.get(Calendar.YEAR)
        val i2=myCalendar.get(Calendar.MONTH)
        val i3=myCalendar.get(Calendar.DAY_OF_MONTH)
        
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener
        { view, i, i2, i3 ->  },i,i2,i3).show()
        
          }
}