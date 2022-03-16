package com.jay.janim.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.janim.R
import com.jay.janim.databinding.FavouritesrecyclerBinding
import com.jay.janim.models.dataclass.Note

class FavouritesAdapter : RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>() {

    val favList = ArrayList<Note>()

    inner class FavouritesViewHolder(val binding: FavouritesrecyclerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        return FavouritesViewHolder(FavouritesrecyclerBinding.bind(LayoutInflater.from(parent.context).inflate(
            R.layout.favouritesrecycler,parent,false
        )))
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val currentNote = favList[position]
        holder.binding.notetiitle.text= currentNote.title
        holder.binding.cb.isChecked = currentNote.status

        if (!currentNote.status){
            delete(position)
        }

        holder.binding.delete.setOnClickListener {
            delete(position)
        }

        holder.binding.see.setOnClickListener {
            if (holder.binding.notetiitle.visibility != View.GONE){
                holder.binding.notetiitle.visibility = View.GONE
            }else{
                holder.binding.notetiitle.visibility = View.VISIBLE
            }
        }

    }

    override fun getItemCount(): Int {
        return favList.size
    }

    private fun delete(position: Int){
        this.favList.removeAt(position)
        this.notifyItemRemoved(position)
    }

}