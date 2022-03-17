package com.jay.janim.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jay.janim.R
import com.jay.janim.databinding.FragmentHomeBinding
import com.jay.janim.models.dataclass.Post
import com.jay.janim.ui.adapters.HomeAdapter
import com.jay.janim.utils.Constants.appuserf
import com.jay.janim.utils.Constants.status

class HomeFragment : Fragment(R.layout.fragment_home){

    lateinit var editors:ArrayList<Post>
    lateinit var popular:ArrayList<Post>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding:FragmentHomeBinding = FragmentHomeBinding.bind(view)

        val handler = Handler()
        val adaptere = HomeAdapter()
        val adapterp = HomeAdapter()

        editors = ArrayList()
        popular = ArrayList()

        if (status){
            binding.welcome.text = "Welcome to Janim $appuserf!"

            handler.postDelayed({
                binding.editors.layoutManager = LinearLayoutManager(this.activity,LinearLayoutManager.HORIZONTAL,false)
                binding.popular.layoutManager = LinearLayoutManager(this.activity,LinearLayoutManager.HORIZONTAL,false)

                binding.popular.adapter = adapterp
                binding.editors.adapter = adaptere

                posts()

                adaptere.imageList = editors
                adapterp.imageList = popular


            },12000)



        }else{
            binding.welcome.text = "Welcome back $appuserf!"

            handler.postDelayed({


                binding.editors.layoutManager = LinearLayoutManager(this.activity,LinearLayoutManager.HORIZONTAL,false)
                binding.popular.layoutManager = LinearLayoutManager(this.activity,LinearLayoutManager.HORIZONTAL,false)


                posts()

                adaptere.imageList = editors
                adapterp.imageList = popular

                binding.popular.adapter = adapterp
                binding.editors.adapter = adaptere
            },1700)
        }


    }

    private fun posts(){
        editors.add(Post(R.drawable.mha))
        editors.add(Post(R.drawable.bf))
        editors.add(Post(R.drawable.tg))
        editors.add(Post(R.drawable.jjk))
        editors.add(Post(R.drawable.jr))
        editors.add(Post(R.drawable.aot))
        editors.add(Post(R.drawable.bleach))
        editors.add(Post(R.drawable.poke))
        editors.add(Post(R.drawable.rz))
        editors.add(Post(R.drawable.pnl))
        editors.add(Post(R.drawable.se))
        editors.add(Post(R.drawable.sa))
        editors.add(Post(R.drawable.tbh))
        editors.add(Post(R.drawable.kny))
        editors.add(Post(R.drawable.hxh))


        popular.add(Post(R.drawable.pe))
        popular.add(Post(R.drawable.sf))
        popular.add(Post(R.drawable.tbh))
        popular.add(Post(R.drawable.poke))
        popular.add(Post(R.drawable.sa))
        popular.add(Post(R.drawable.rz))
        popular.add(Post(R.drawable.se))
        popular.add(Post(R.drawable.bf))
        popular.add(Post(R.drawable.rz))
        popular.add(Post(R.drawable.se))
        popular.add(Post(R.drawable.tg))
        popular.add(Post(R.drawable.mha))
        popular.add(Post(R.drawable.jjk))
        popular.add(Post(R.drawable.jr))
        popular.add(Post(R.drawable.aot))
        popular.add(Post(R.drawable.bleach))
        popular.add(Post(R.drawable.tbh))
        popular.add(Post(R.drawable.te))
        popular.add(Post(R.drawable.pnl))
        popular.add(Post(R.drawable.kny))
        popular.add(Post(R.drawable.hxh))


    }

}