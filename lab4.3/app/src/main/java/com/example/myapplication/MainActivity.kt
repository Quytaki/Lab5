package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Danh sách URL hình ảnh
        val imageUrls = listOf(
            "https://picsum.photos/600/400?random=1",
            "https://picsum.photos/600/400?random=2",
            "https://picsum.photos/600/400?random=3",
            "https://picsum.photos/600/400?random=4",
            "https://picsum.photos/600/400?random=5",
            "https://picsum.photos/600/400?random=6",
            "https://picsum.photos/600/400?random=7",
            "https://picsum.photos/600/400?random=8",
            "https://picsum.photos/600/400?random=9",
            "https://picsum.photos/600/400?random=10"
            // Thêm nhiều URL khác nếu cần
        )

        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cài đặt adapter cho RecyclerView
        imageAdapter = ImageAdapter(imageUrls)
        recyclerView.adapter = imageAdapter
    }
}
