package com.anshuman.andriodcse225allcode.Storage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.anshuman.andriodcse225allcode.R
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class ExternalDetails : AppCompatActivity() {
    lateinit var fstream : FileInputStream
    private val filename = "SampleFile.txt"
    private val filepath = "MyFileStorage"
    lateinit var myExternalFile : File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_external_details)
        val result = findViewById<TextView>(R.id.result)
        val back = findViewById<Button>(R.id.back)

        try{
            myExternalFile = File(getExternalFilesDir(filepath),filename)
            fstream = FileInputStream(myExternalFile)
            val sbuffer = StringBuffer()

            var i : Int
            while (fstream.read().also { i = it } != -1){
                sbuffer.append(i.toChar())
            }
            fstream.close()

            val details = sbuffer.toString().split("\n").toTypedArray()
            result.text = """
                Name : ${details[0]}
                Password : ${details[1]}
            """.trimIndent()
        }catch (e : Exception){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        }

        back.setOnClickListener {
            intent = Intent(this,ExternalStorage::class.java)
            startActivity(intent)
            }

        }


}
