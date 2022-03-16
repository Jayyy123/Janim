package com.jay.janim.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.jay.janim.R
import com.jay.janim.databinding.ActivityLockBinding
import com.jay.janim.models.database.UserDatabases
import com.jay.janim.models.dataclass.User
import com.jay.janim.models.repository.UserRepository
import com.jay.janim.ui.base.BaseActivity
import com.jay.janim.ui.viewmodels.LockViewModel
import com.jay.janim.utils.Constants
import com.jay.janim.utils.viewmodelproviderfactory.UserViewModelProviderFactory
import com.jay.janim.utils.Constants.appuserf

class LockActivity : BaseActivity() {

    val TAG = ""


    private lateinit var binding: ActivityLockBinding
    private lateinit var handler: Handler
    private lateinit var userViewModel: LockViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler()

        binding.sigi1.setOnClickListener {
            binding.reg.visibility = View.VISIBLE
            binding.sig.visibility = View.GONE
        }

        binding.sigu.setOnClickListener {
            binding.sig.visibility = View.VISIBLE
            binding.reg.visibility = View.GONE
        }



        binding.tc.setOnClickListener {
            binding.terms.visibility = View.VISIBLE
        }

        binding.contine.setOnClickListener {
            binding.terms.visibility = View.GONE
        }


        val uvmf = UserViewModelProviderFactory(UserRepository(UserDatabases.invoke(this)))
        val vmp = ViewModelProvider(this, uvmf).get(LockViewModel::class.java)

        vmp.adduser(User(1,"j","o","c","joe"))

        vmp.getAllUsers().observe(
            this@LockActivity
        ) {
            vmp.userss.value = it
        }



        binding.si.setOnClickListener {
            if (binding.username.text.isNotEmpty() && binding.pass.text.isNotEmpty()) {
                Snackbar.make(binding.root, "User Signin noticed", Snackbar.LENGTH_SHORT).show()

                login()

            } else {
                Snackbar.make(binding.root, "Please Fill out all the fields", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        binding.su.setOnClickListener {
            if (binding.username1.text.isNotEmpty() && binding.first.text.isNotEmpty() && binding.last.text.isNotEmpty() && binding.pass1.text.isNotEmpty()) {
                if (!binding.cb.isChecked) {
                    Snackbar.make(
                        binding.root,
                        "You must accept Janim's terms and conditions\n in order to proceed",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    binding.tcw.visibility = View.VISIBLE
                    handler.postDelayed({ binding.tcw.visibility = View.INVISIBLE }, 3000)
                } else {
                    Snackbar.make(binding.root, "User Signup noticed", Snackbar.LENGTH_SHORT).show()
                    signup()
                }
            } else {
                Snackbar.make(
                    binding.root,
                    "Please Fill out all the fields",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }


    private fun login() {

        var usernameIndex = 0
        var passwordIndex = 0

        val uvmf = UserViewModelProviderFactory(UserRepository(UserDatabases.invoke(this)))
        val vmp = ViewModelProvider(this, uvmf)[LockViewModel::class.java]

        vmp.getUsername().observe(this, Observer { users ->

            Log.e(TAG, "The list of users is $users")

                if (users.contains(binding.username.text.toString().trimEnd())) {
                    usernameIndex = users.indexOf(binding.username.text.toString().trimEnd())
                    vmp.username = true
                }
        })

        vmp.getPassword().observe(this, Observer { users ->
            Log.e(TAG, "The list of passwords is $users")
                if (users.contains(binding.pass.text.toString())) {
                    passwordIndex = users.indexOf(binding.pass.text.toString())
                    vmp.password = true
                }

            Log.e(TAG,"$passwordIndex $usernameIndex")

            if (vmp.password && vmp.username && (passwordIndex == usernameIndex)) {
                Toast.makeText(
                    this@LockActivity,
                    "Welcome back ${binding.username.text}",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(Intent(this, MainActivity::class.java))
                vmp.username = false
                vmp.password = false
                appuser = binding.username.text.toString()
                appuserf = binding.username.text.toString()
                finish()
            } else {
                Toast.makeText(
                    this@LockActivity,
                    "There was an error Logging in ${binding.username.text}",
                    Toast.LENGTH_SHORT
                ).show()
                vmp.username = false
                vmp.password = false
                passwordIndex = 0
                usernameIndex = 0
            }

        })
    }


    private fun signup() {
        val uvmf = UserViewModelProviderFactory(UserRepository(UserDatabases.invoke(this)))
        val vmp = ViewModelProvider(this, uvmf)[LockViewModel::class.java]
        val firstname = binding.first.text.toString().trimIndent()
        val lastname = binding.last.text.toString().trimIndent()
        val username = binding.username1.text.toString().trimEnd()
        val password = binding.pass1.text.toString()

        Log.e(TAG, "database = ${vmp.userss.value}")

        val user = User(2,firstname, lastname, username, password)
        Log.e(TAG, "The userrr is $user")

        vmp.getUsername().observe(this@LockActivity) {
                Log.e(TAG,"$it")
                if (!it.contains(username)) {
                    vmp.adduser(user)
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(
                        this@LockActivity,
                        "Welcome back $username",
                        Toast.LENGTH_SHORT
                    ).show()
                    helper = true
                    appuser = username
                    finish()

                } else {
                    Snackbar.make(
                        binding.root,
                        "Username already exists.\n Please use a different one or Sign into your account",
                        Snackbar.LENGTH_SHORT
                    ).show()

                }
            }
        Log.e(TAG, "The list of su is $user")
        Log.e(TAG, "database f = ${vmp.userss.value}")
        }

    }


//    private fun clear(){
//        binding.username.setText("")
//        binding.username1.setText("")
//        binding.pass.setText("")
//        binding.pass1.setText("")
//        binding.first.setText("")
//        binding.last.setText("")
//    }
