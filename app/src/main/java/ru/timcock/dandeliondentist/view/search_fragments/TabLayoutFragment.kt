package ru.timcock.dandeliondentist.view.search_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.FragmentTabLayoutBinding
import ru.timcock.dandeliondentist.view.fragments.SearchFragment


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TabLayoutFragment : Fragment() {

    private lateinit var binding: FragmentTabLayoutBinding

    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentTabLayoutBinding.bind(view)
        val serviceSearchFragment = ServicesSearchFragment()
        replaceChildFragment(serviceSearchFragment,R.id.tabLayout_child_fragment,"SERVICES_FRAGMENT_TAG")
        SearchFragment.tab_flag=1
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0->{
                        replaceChildFragment(serviceSearchFragment,R.id.tabLayout_child_fragment,"SERVICES_FRAGMENT_TAG")
                        SearchFragment.tab_flag=1
                    }
                    1->{
                        val doctorsSearchFragment = DoctorsSearchFragment()
                        replaceChildFragment(doctorsSearchFragment,R.id.tabLayout_child_fragment,"DOCTORS_FRAGMENT_TAG")
                        SearchFragment.tab_flag=2
                    }
                    2->{
                        val clinicSearchFragment = ClinicSearchFragment()
                        replaceChildFragment(clinicSearchFragment,R.id.tabLayout_child_fragment,"CLINICS_FRAGMENT_TAG")
                        SearchFragment.tab_flag=3
                    }
                    }
                }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }



    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TabLayoutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



    private fun Fragment.replaceChildFragment(fragment: Fragment, frameId: Int, fragmentTag: String) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(frameId, fragment, fragmentTag).commit()
        childFragmentManager.executePendingTransactions()

    }





}