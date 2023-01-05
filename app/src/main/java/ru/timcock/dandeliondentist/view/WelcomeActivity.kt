package ru.timcock.dandeliondentist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.ActivityLoginBinding
import ru.timcock.dandeliondentist.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.continueButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.continue_button->{
                intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                overridePendingTransition(0,0)
            }
        }

    }
}