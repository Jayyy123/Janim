package com.jay.janim.ui.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.janim.R
import com.jay.janim.databinding.HomerecyclersBinding
import com.jay.janim.models.dataclass.Post

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    val imageList = ArrayList<Post>()

    inner class HomeViewHolder(val binding : HomerecyclersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(HomerecyclersBinding.bind(LayoutInflater.from(parent.context).inflate(
            R.layout.homerecyclers, parent,false
        )))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currenImage = imageList[position]

    }

    override fun getItemCount(): Int {

        return imageList.size

    }


}