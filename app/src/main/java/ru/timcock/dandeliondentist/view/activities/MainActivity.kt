package ru.timcock.dandeliondentist.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.ActivityMainBinding
import ru.timcock.dandeliondentist.view.fragments.PrescriptionsFragment
import ru.timcock.dandeliondentist.view.fragments.ProfileFragment
import ru.timcock.dandeliondentist.view.fragments.SearchFragment
import ru.timcock.dandeliondentist.view.fragments.AppointmentsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        val appointmentsFragment = AppointmentsFragment()
        val prescriptionsFragment = PrescriptionsFragment()
        val profileFragment = ProfileFragment()
        val searchFragment = SearchFragment()
        setCurrentFragment(searchFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            it.isChecked=true
            when(it.itemId){
                R.id.search-> setCurrentFragment(searchFragment)
                R.id.appointments-> setCurrentFragment(appointmentsFragment)
                R.id.presriptions-> setCurrentFragment(prescriptionsFragment)
                R.id.profile-> setCurrentFragment(profileFragment)
                }
            true

            }
        }



    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFragment,fragment)
            commit()
        }
}