package com.jay.janim.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jay.janim.R
import com.jay.janim.databinding.FragmentNoteBinding
import com.jay.janim.models.database.NoteDatabase
import com.jay.janim.models.dataclass.Note
import com.jay.janim.models.repository.NoteRepository
import com.jay.janim.ui.activities.MainActivity
import com.jay.janim.ui.adapters.NotesAdapter
import com.jay.janim.ui.viewmodels.NoteViewModel
import com.jay.janim.utils.Constants.appuserf

class NoteFragment : Fragment(R.layout.fragment_note){

    lateinit var noteViewModel: NoteViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val TAG = ""

        val binding: FragmentNoteBinding = FragmentNoteBinding.bind(view)
        val adapter = NotesAdapter()

        noteViewModel = NoteViewModel(NoteRepository(NoteDatabase.invoke(requireActivity())))

        noteViewModel.getAllNotes().observe(requireActivity()){notes ->

            for (i in notes){
                if (i.username == appuserf){
                    noteViewModel.usernotes.add(i)
                }
            }
        }
        adapter.notesList = noteViewModel.usernotes


        if (adapter.notesList.size > 0){

            binding.hin.visibility = View.GONE
            binding.notes.visibility = View.VISIBLE

            binding.notes.layoutManager = LinearLayoutManager(this.activity)
            binding.notes.adapter = adapter
        }else{
            binding.hin.visibility = View.VISIBLE
            binding.notes.visibility = View.VISIBLE
        }


        binding.fab.setOnClickListener {
            binding.apply {
                fab.visibility = View.GONE
                addnote.visibility = View.VISIBLE
                hin.visibility = View.GONE
                notes.visibility = View.GONE
                val title = title.text.toString()
                val description = description.text.toString()
                add.setOnClickListener {
                    val note = Note(0, appuserf,title,description,false)
                    Log.i(TAG,"The note is $note")

                    noteViewModel.addNote(note)

                    noteViewModel.getAllNotes().observe(requireActivity()){
                        Log.i(TAG,"The note is $it")
                    }

                    adapter.notesList.add(note)
                    fab.visibility = View.VISIBLE
                    addnote.visibility = View.GONE
                    notes.visibility = View.VISIBLE

                }
            }
        }



    }
}