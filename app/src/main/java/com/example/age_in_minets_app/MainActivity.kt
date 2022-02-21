package com.example.age_in_minets_app

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button=findViewById(R.id.textButtonSelectDate)
        button.setOnClickListener {
            openDialogDate(button)
        }
    }//sdf
    fun openDialogDate(view:View){
        val myCalendar=Calendar.getInstance();
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)
        Toast.makeText(this,"ddword",LENGTH_LONG).show()
        val dpd= DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
                view,year,month,day->
                    Toast.makeText(this,"word",LENGTH_LONG).show()
                    val selectDate="${day}/${month+1}/${year}"
                    val firstOut:TextView=findViewById(R.id.selectedDate)
                    firstOut.setText(selectDate);
                    val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
                    val date=sdf.parse(selectDate).time!!/60000;
                    val nowDate=sdf.parse(sdf.format(System.currentTimeMillis())).time!!/60000;
                    val result=nowDate-date;
                    val secondOut:TextView=findViewById(R.id.selectedAge)
                    secondOut.setText(result.toString())

                  Toast.makeText(this,"${nowDate}:${date}",LENGTH_LONG).show()
        },year,month,day)
        dpd.datePicker.setMaxDate(Date().time);
        dpd.show();
    }
}
