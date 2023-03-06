package ru.timcock.dandeliondentist.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.ActivityWhereSortBinding
import ru.timcock.dandeliondentist.view.fragments.DistrictsListFragment
import ru.timcock.dandeliondentist.view.fragments.MetroListFragment
import ru.timcock.dandeliondentist.view.fragments.SearchFragment
import ru.timcock.dandeliondentist.view.search_fragments.DoctorsSearchFragment

class WhereSortActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWhereSortBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhereSortBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val metro_fragment = MetroListFragment()
        replaceFragment(metro_fragment,R.id.where_sort_tablayout_fragment)
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        replaceFragment(metro_fragment, R.id.where_sort_tablayout_fragment)
                    }
                    1 -> {
                        val  districtsListFragment = DistrictsListFragment()
                        replaceFragment(districtsListFragment,R.id.where_sort_tablayout_fragment)
                    }

                }


            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }
    fun replaceFragment(fragment: Fragment, frameId: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(frameId, fragment).commit()
        supportFragmentManager.executePendingTransactions()

    }
}

