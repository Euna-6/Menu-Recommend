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

        /* 테스트용 데이터
        val datas = ArrayList<MenuItem>()
        datas.add(MenuItem("떡볶이"))
        datas.add(MenuItem("라면"))
        datas.add(MenuItem("순대"))
         */

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // 테스트용 데이터 사용할 때
        // binding.recyclerView.adapter = MenuAdapter(datas)
        binding.recyclerView.adapter = MenuAdapter(MenuItem.menuList)


        // 아이템 갯수 확인
        val count = binding.recyclerView.adapter!!.itemCount
        //datas.add(MenuItem("$count"))


    }
}