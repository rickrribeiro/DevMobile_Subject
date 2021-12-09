package com.ricardoangelo.exam
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class TableHistoryActivity : AppCompatActivity() {
    var database = Firebase.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_history)

        setUpTableData()
    }

    private fun setUpTableData() {
        val myRef = database.getReference("location_history")
        //val table = findViewById<TableLayout>(R.id.location_table); // .orderByChild("starCount")
        val locationData = myRef.get().addOnSuccessListener {
            //Toast.makeText(this, it.value.toString(), Toast.LENGTH_LONG).show()
            //val row = LayoutInflater.from(table.context ).inflate(R.layout.table_row,null) as TableRow
            //val row = table.addView(R.layout.table_row)
            //val row = layoutInflater.inflate(R.layout.table_row,null)
            val tvLatitude = findViewById<TextView>(R.id.tvLatitude)
            val tvLongitude = findViewById<TextView>(R.id.tvLongitude)
            val tvDate = findViewById<TextView>(R.id.tvDate)
            tvLatitude.text =""
            tvLongitude.text =""
            tvDate.text =""
            it!!.children.forEach{
                //Toast.makeText(this, it.child("latitude").value.toString(), Toast.LENGTH_LONG).show()
                tvLatitude.text = tvLatitude.text as String + it.child("latitude").value.toString()+"\n"
                tvLongitude.text = tvLongitude.text as String + it.child("longitude").value.toString()+"\n"
                tvDate.text = tvDate.text as String + it.child("date").value.toString()+"\n"
            }
            
       }

        //locationData.result
    }
}