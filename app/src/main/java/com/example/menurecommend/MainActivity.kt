package com.example.menurecommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.menurecommend.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("")

        // 메뉴 리스트를 mutableList에 저장
        var menuList = mutableListOf<String>()
        var db: FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("menu")
            .get()
            .addOnSuccessListener { result->
                for (document in result) {
                    menuList.add(document.data.get("menu").toString())
                }
            }

        val random = Random()
        binding.btnMenu.setOnClickListener {
            val num = random.nextInt(menuList.size)
            val name = menuList[num]
            binding.btnMenu.setText(name)
        }

        binding.btnList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putStringArrayListExtra("menuList", ArrayList(menuList))
            startActivity(intent)
            overridePendingTransition(R.anim.none, R.anim.nonetotop)
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