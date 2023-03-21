package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
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
        
        val dpd=DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener
        { view, i, i2, i3 ->

            Toast.makeText(this,
                "Year: $i, Month: ${i2+1}, Day: $i3",
                Toast.LENGTH_LONG).show()

            val selectedDate="$i3/${i2 + 1}/$i"
            val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            val theDate=sdf.parse(selectedDate)

            val tvSelectedDate=findViewById<TextView>(R.id.selectedDate)
            tvSelectedDate.setText("$theDate")


            val selectedDateInMinutes=theDate!!.time / 60000

            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))!!.time/60000

            val differenceInMinutes=currentDate-selectedDateInMinutes
             val timePassedValue=findViewById<TextView>(R.id.timePassed);

            timePassedValue.setText("$differenceInMinutes")




        },i, i2, i3)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()



        
          }
}