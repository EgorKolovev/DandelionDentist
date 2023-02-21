package ru.timcock.dandeliondentist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.timcock.dandeliondentist.R

class SelectedItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_item)
        val selected_item_fragment = SelectedItemFragment()
        setCurrentFragment(selected_item_fragment)
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.item_selected_fragment,fragment)
            commit()
        }
}