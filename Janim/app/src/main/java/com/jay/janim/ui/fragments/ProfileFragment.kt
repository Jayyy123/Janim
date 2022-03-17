package com.jay.janim.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jay.janim.R
import com.jay.janim.databinding.FragmentProfileBinding
import com.jay.janim.ui.activities.LockActivity
import com.jay.janim.utils.Constants.appuserf
import com.jay.janim.utils.Constants.notes

class ProfileFragment : Fragment(R.layout.fragment_profile){



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lateinit var binding:FragmentProfileBinding
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)


        binding.username.text = appuserf
        binding.favcount.text = "$notes Notes currently Available"


        binding.logout.setOnClickListener {
            startActivity(Intent(this.activity,LockActivity::class.java))
            requireActivity().finish()
        }

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