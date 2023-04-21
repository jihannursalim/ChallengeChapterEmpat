package com.example.myorm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.widget.Toast
import com.example.myorm.databinding.ActivityEditBinding
import com.example.myorm.room.NoteData
import com.example.myorm.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class EditActivity : AppCompatActivity() {

    lateinit var binding : ActivityEditBinding
    var dbNote : NoteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbNote = NoteDatabase.getInstance(this)

        //Ambil data
        var getDataNote = intent.getSerializableExtra("dataedit") as NoteData

        //Set data
        binding.editTitle.setText(getDataNote.title)
        binding.editNote.setText(getDataNote.content)
        binding.idNote.setText(getDataNote.id.toString())

        //Klik edit
        binding.btnEditNote.setOnClickListener {
            editNote()
        }
    }

    fun editNote(){
        var idNote = binding.idNote.text.toString().toInt()
        var title = binding.editTitle.text.toString()
        var note = binding.editNote.text.toString()
        var date = binding.editTanggal.text.toString()

        GlobalScope.async {
            var edit = dbNote?.noteDao()?.updateNote(NoteData(idNote, title, note, date))
            runOnUiThread {
                Toast.makeText(this@EditActivity, "Data berhasil di edit", Toast.LENGTH_LONG)
                    .show()
            }
            finish()
        }
    }
}