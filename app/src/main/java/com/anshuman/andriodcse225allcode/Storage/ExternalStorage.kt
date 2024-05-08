package com.anshuman.andriodcse225allcode.Storage

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.anshuman.andriodcse225allcode.R
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ExternalStorage : AppCompatActivity() {
    lateinit var uname : EditText
    lateinit var pwd : EditText
    lateinit var btn : Button

    lateinit var fstream : FileOutputStream
    private var filename = "SampleFile.txt"
    private val filepath = "MyFileStorage"
    lateinit var myExternalFile : File
    var mPermission = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_external_storage)
        uname = findViewById(R.id.name)
        pwd = findViewById(R.id.password)
        btn = findViewById(R.id.save)
        btn.setOnClickListener {
            val username = uname.text.toString()
            val password = pwd.text.toString()

            try{
                if(ContextCompat.checkSelfPermission(this,mPermission[0]) == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this,mPermission[1]) == PackageManager.PERMISSION_GRANTED){
                    Log.d("Permission","Permission Required")
                    ActivityCompat.requestPermissions(this,mPermission,0)
                }else{
                    if(username.isEmpty() || password.isEmpty()){
                        Toast.makeText(this,"Either of field is empty",Toast.LENGTH_SHORT).show()
                    }else{
                        myExternalFile = File(getExternalFilesDir(filepath),filename)
                        fstream = FileOutputStream(myExternalFile)
                        fstream.write(username.toByteArray())
                        fstream.write("\n".toByteArray())
                        fstream.write(password.toByteArray())
                        fstream.close()

                        Toast.makeText(this,"Data saved in "+myExternalFile!!.absolutePath,Toast.LENGTH_SHORT).show()
                        intent = Intent(this,ExternalDetails::class.java)
                        startActivity(intent)
                    }
                }
            }catch (e : FileNotFoundException){
                Log.d("msg1" ,"Failed1")
                e.printStackTrace()
            }catch (e : IOException){
                Log.d("msg2" ,"Failed2")
                e.printStackTrace()
            }
            }


    }
}