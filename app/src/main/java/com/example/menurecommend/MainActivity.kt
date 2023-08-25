package com.example.menurecommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.menurecommend.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val cnt = MenuItem.menuList.count()

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
}