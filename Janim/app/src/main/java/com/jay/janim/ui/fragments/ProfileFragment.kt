package com.jay.janim.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jay.janim.R
import com.jay.janim.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile){



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lateinit var binding:FragmentProfileBinding
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding.settings.setOnClickListener {

            if (binding.otherdeets.visibility != View.GONE) {

                binding.otherdeets.visibility = View.GONE
                binding.settingsview.visibility = View.VISIBLE
            }else{
                binding.otherdeets.visibility = View.VISIBLE
                binding.settingsview.visibility = View.GONE
            }
        }


    }

}