package com.example.mobilszoftverlabor.ui.main

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilszoftverlabor.R
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.ui.notedetails.NoteDetailsActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotesAdapter constructor(
    private val context: Context,
    private var mainPresenter: MainPresenter,
    private var notes: List<NoteResult>) : RecyclerView.Adapter<NotesAdapter.ViewHolder>()  {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var item: View = view
        var title: TextView = view.findViewById(R.id.note_title)
        var content: TextView = view.findViewById(R.id.note_text)
        var createDate: TextView = view.findViewById(R.id.note_create_date)
        var updatedate:TextView = view.findViewById(R.id.note_update_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        Log.d("Msg", "" + position + ": " + notes[position] )
        holder.title.text = note.title ?: "No title"
        holder.content.text = note.content?.take(10) ?: "No Content"
        holder.createDate.text = note.createdAt
        holder.updatedate.text = note.updatedAt

        holder.item.setOnClickListener{
            val intent = Intent(context, NoteDetailsActivity::class.java)
            intent.putExtra("NOTE_ID", note.id)
            context.startActivity(intent)
        }
    }
}