package com.example.myorm.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDAO {

    @Insert
    fun insertData(noteData: NoteData)

    @Query("SELECT * FROM NoteData ORDER BY id DESC")
    fun getDataNote() : List<NoteData>

    @Delete
    fun deleteNote(noteData: NoteData)

    @Update
    fun updateNote(noteData: NoteData)
}