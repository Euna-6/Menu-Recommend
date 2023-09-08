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
        overridePendingTransition(R.anim.bottonone, R.anim.none)    // 화면 전환 효과

        val menuList = intent.getStringArrayListExtra("menuList")

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = menuList?.let { MenuAdapter(it) }

    }

    // 메인 액티비티로 돌아갈 때
    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }


}