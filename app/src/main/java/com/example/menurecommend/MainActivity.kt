package com.example.menurecommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.menurecommend.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val cnt = MenuItem.menuList.count()
    var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("")

        val random = Random()
        binding.btnMenu.setOnClickListener {
            val num = random.nextInt(cnt)
            val name = MenuItem.menuList[num].menu
            binding.btnMenu.setText(name)
        }

        binding.btnList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }



    }

    override fun onBackPressed() {
        if(System.currentTimeMillis() - 2000 > backKeyPressedTime){
            Toast.makeText(this, "한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            finish()
        }
        backKeyPressedTime = System.currentTimeMillis()
    }
}