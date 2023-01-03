package ru.timcock.dandeliondentist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.ActivityLoginBinding
import ru.timcock.dandeliondentist.databinding.ActivityRegisterBinding

private lateinit var binding: ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        binding.loginFromRegistration.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.login_from_registration->{
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                overridePendingTransition(0,0)
            }
        }
    }
}