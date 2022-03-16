package com.jay.janim.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.janim.R
import com.jay.janim.databinding.NoterecyclersBinding
import com.jay.janim.models.dataclass.Note

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    var notesList = ArrayList<Note>()
    val favList = ArrayList<Note>()

    inner class NotesViewHolder(val binding: NoterecyclersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(NoterecyclersBinding.bind(LayoutInflater.from(parent.context).inflate(
            R.layout.noterecyclers, parent,false)))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = notesList[position]
        holder.binding.notetiitle.text = currentNote.title
        holder.binding.cb.isChecked = currentNote.status

        if (currentNote.status){
            favList.add(currentNote)
        }

        holder.binding.delete.setOnClickListener {
            delete(position)
        }

        holder.binding.see.setOnClickListener {

            if (holder.binding.notetiitle.visibility != View.GONE) {
                holder.binding.apply {
                    notetiitle.visibility = View.GONE
                }
            }else{
                holder.binding.notetiitle.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }


    private fun delete(position: Int){

        this.notesList.removeAt(position)
        this.notifyItemRemoved(position)

    }


}