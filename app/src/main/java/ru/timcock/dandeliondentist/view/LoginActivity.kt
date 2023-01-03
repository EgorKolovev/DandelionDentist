package ru.timcock.dandeliondentist.view

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.ActivityLoginBinding
import java.util.regex.Matcher
import java.util.regex.Pattern


private lateinit var binding: ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        binding.registrationFromLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.registration_from_login->{
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                overridePendingTransition(0,0)
            }

        }


    }
    fun isPasswordValid(password:CharSequence): Boolean{
        val pattern: Pattern
        val matcher: Matcher

        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"

        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)

        return matcher.matches()

    }
}