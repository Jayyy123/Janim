package com.jay.janim.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
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
import com.jay.janim.utils.Constants.deletekey
import com.jay.janim.utils.Constants.info
import com.jay.janim.utils.Constants.notes

class NoteFragment : Fragment(R.layout.fragment_note){
    val TAG = ""
    lateinit var noteViewModel: NoteViewModel
    lateinit var adapter: NotesAdapter
    lateinit var binding: FragmentNoteBinding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNoteBinding.bind(view)
        adapter = NotesAdapter()

        noteViewModel = NoteViewModel(NoteRepository(NoteDatabase.invoke(requireActivity())))
//
//        if (!info) {

//        }else{
            getnotes()
//        }

//        if (deletekey != 0){
//            val toBeDeleted = noteViewModel.usernotes[deletekey]
//            noteViewModel.deleteNote(toBeDeleted)
//
//
//            noteViewModel.getAllNotes().observe(requireActivity()){
//                noteViewModel.usernotes = it as ArrayList<Note>
//                deletekey = 0
//
//                adapter.notifyItemRemoved(deletekey)
//            }
//        }


        binding.apply {
            title.setText("")
            description.setText("")
        }
        binding.fab.setOnClickListener {
            binding.apply {
                fab.visibility = View.GONE
                addnote.visibility = View.VISIBLE
                hin.visibility = View.GONE
                notes.visibility = View.GONE


                title.setText("")
                description.setText("")


                add.setOnClickListener {

                    val titl = title.text.toString()
                    val description = description.text.toString()

                    val note = Note(0, appuserf, titl,description,false)
                    Log.i(TAG,"\nooooooo----------The note is $note--------------oooooo\n")

                    noteViewModel.addNote(note)

                    noteViewModel.getAllNotes().observe(requireActivity()){
                        Log.i(TAG,"The noteee is $it")
                    }

                    addnote.visibility = View.GONE
                    fab.visibility = View.VISIBLE
                    notes.visibility = View.VISIBLE

                }
            }

        }

    }
    private fun getnotes(){
        noteViewModel.getAllNotes().observe(requireActivity()){note ->

            for (i in note){
                if (i.username == appuserf){
                    noteViewModel.usernotes.add(i)
                }
            }
            noteViewModel.addNote(Note(1,"c","Admin","Test case",true))

            adapter.notesList = noteViewModel.usernotes
            if (noteViewModel.usernotes.size > 1){

                notes = noteViewModel.usernotes.size
                binding.hin.visibility = View.GONE
                binding.notes.visibility = View.VISIBLE

                binding.notes.layoutManager = LinearLayoutManager(this.activity)
                binding.notes.adapter = adapter
            }else{
                binding.hin.visibility = View.VISIBLE
                binding.notes.visibility = View.VISIBLE
            }
            info = true
        }
    }
    private fun getnotesss(){
        noteViewModel.getAllNotes().observe(requireActivity()){note ->

            for (i in note){
                if (i.username == appuserf){
                    noteViewModel.usernotes.add(i)
                }
            }
            noteViewModel.addNote(Note(1,"c","Admin","Test case",true))

            adapter.notesList = noteViewModel.usernotes
            if (noteViewModel.usernotes.size > 1){

                notes = noteViewModel.usernotes.size
                binding.hin.visibility = View.GONE
                binding.notes.visibility = View.VISIBLE

                binding.notes.layoutManager = LinearLayoutManager(this.activity)
                binding.notes.adapter = adapter
            }else{
                binding.hin.visibility = View.VISIBLE
                binding.notes.visibility = View.VISIBLE
            }
            info = true
        }
    }

}