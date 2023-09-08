package com.example.menurecommend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menurecommend.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val menuList = intent.getStringArrayListExtra("menuList")

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = menuList?.let { MenuAdapter(it) }

        // 아이템 갯수 확인
        //val count = binding.recyclerView.adapter!!.itemCount
        //datas.add(MenuItem("$count"))

    }
}