package com.example.myorm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myorm.databinding.ActivityDetailNoteBinding
import com.example.myorm.room.NoteData

class DetailNoteActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var getDetail = intent.getSerializableExtra("detail") as NoteData

        binding.detailTitle.text = getDetail.title
        binding.detailNote.text = getDetail.content
    }
}