package com.example.myorm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myorm.databinding.ActivityAddNoteBinding
import com.example.myorm.room.NoteData
import com.example.myorm.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddNoteActivity : AppCompatActivity() {

    lateinit var binding : ActivityAddNoteBinding
    var noteDB : NoteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteDB = NoteDatabase.getInstance(this)

        binding.btnSaveNote.setOnClickListener {
            addData()
        }
    }

    fun addData(){
        GlobalScope.async {
            var title = binding.noteTitle.text.toString()
            var content = binding.noteContent.text.toString()
            var tgl = binding.dateNote.text.toString()

            noteDB?.noteDao()?.insertData(NoteData(0, title, content, tgl))
        }

        //Supaya Balik ke Halaman/MainActivity Sebelumnya
        finish()
    }

    override fun onStart() {
        super.onStart()
    }
}