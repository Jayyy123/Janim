package com.jay.janim.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.jay.janim.R
import com.jay.janim.databinding.ActivityMainBinding
import com.jay.janim.ui.adapters.HomeAdapter
import com.jay.janim.ui.base.BaseActivity
import com.jay.janim.utils.Constants.status

class MainActivity : BaseActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navController: NavController
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHost.navController
        binding.bnv.setupWithNavController(navController)

        toggle = ActionBarDrawerToggle(this,binding.dl, binding.toolbar, R.string.open, R.string.close)
        binding.dl.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        handler = Handler()

        //Helpers
        helpers()



        }

    private fun helpersGone(){
        binding.apply {
            a1.visibility = View.GONE
            a2.visibility = View.GONE
            a3.visibility = View.GONE
            a4.visibility = View.GONE
            a5.visibility = View.GONE
            a6.visibility = View.GONE
            a7.visibility = View.GONE
            a8.visibility = View.GONE
            yu.visibility = View.GONE
            yu2.visibility = View.GONE
            yu3.visibility = View.GONE
            yu4.visibility = View.GONE
            yu5.visibility = View.GONE
            ymenu.visibility = View.GONE
            amenu.visibility = View.GONE
        }
    }

    private fun helpers(){
        if (status){

            binding.helpers.visibility = View.VISIBLE
            helpersGone()
            binding.apply {

                handler.postDelayed({
                    a1.visibility = View.VISIBLE
                    yu.visibility = View.VISIBLE

                    handler.postDelayed({
                        helpersGone()
                    },700)

                },1500)

                handler.postDelayed({
                    a2.visibility = View.VISIBLE
                    yu2.visibility = View.VISIBLE
                    handler.postDelayed({
                        helpersGone()
                    },700)
                },2500)


                handler.postDelayed({
                    a5.visibility = View.VISIBLE
                    yu5.visibility = View.VISIBLE
                    handler.postDelayed({
                        helpersGone()
                    },700)
                },3500)


                handler.postDelayed({
                    a4.visibility = View.VISIBLE
                    yu4.visibility = View.VISIBLE
                    handler.postDelayed({
                        helpersGone()
                    },700)
                },4500)

                handler.postDelayed({
                    amenu.visibility = View.VISIBLE
                    yu5.visibility = View.VISIBLE

                    handler.postDelayed({
                        helpersGone()
                    },700)

                },5500)

                handler.postDelayed({

                    a3.visibility = View.VISIBLE
                    a6.visibility = View.VISIBLE
                    a7.visibility = View.VISIBLE
                    a8.visibility = View.VISIBLE
                    yu3.visibility = View.VISIBLE

                    handler.postDelayed({
                        helpersGone()
                    },1500)

                },6500)

                handler.postDelayed({
                    binding.progressBar.visibility = View.VISIBLE
                    handler.postDelayed({
                        binding.progressBar.visibility = View.GONE
                    },3000)

                },8100)

            }
            helper = false
        }else{

            binding.progressBar.visibility = View.VISIBLE
            handler.postDelayed({
                binding.progressBar.visibility = View.GONE
            },3000)

        }
    }
}