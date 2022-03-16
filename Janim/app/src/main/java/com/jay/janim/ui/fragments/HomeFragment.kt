package com.jay.janim.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jay.janim.R
import com.jay.janim.databinding.FragmentHomeBinding
import com.jay.janim.utils.Constants.appuserf
import com.jay.janim.utils.Constants.status

class HomeFragment : Fragment(R.layout.fragment_home){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding:FragmentHomeBinding = FragmentHomeBinding.bind(view)


        if (status){
            binding.welcome.text = "Welcome to Janim $appuserf!"
        }else{
            binding.welcome.text = "Welcome back $appuserf!"
        }
    }

}