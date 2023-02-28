package ru.timcock.dandeliondentist.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.FragmentSearchBinding
import ru.timcock.dandeliondentist.view.search_fragments.*

class SearchFragment : Fragment(), View.OnClickListener {


    lateinit var binding: FragmentSearchBinding

    var searchViewIsOpened: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentSearchBinding.bind(view)

        val tabLayoutFragment = TabLayoutFragment()
        val suggestionsSearchFragment = SuggestionsSearchFragment()

        binding.search.setOnQueryTextFocusChangeListener { view, b ->run{
            replaceChildFragment(tabLayoutFragment, R.id.fragment_search_child_fragment,"TABLAYOUT_FRAGMENT_TAG")
            searchViewIsOpened=true
        }
        }

        binding.search.setOnFocusChangeListener(View.OnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                replaceChildFragment(
                    suggestionsSearchFragment,
                    R.id.fragment_search_child_fragment, "SUGGESTIONS_FRAGMENT_TAG"
                )
            }
        })
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (tab_flag == 1) {
                    val fragment = childFragmentManager?.findFragmentByTag("SERVICES_FRAGMENT_TAG") as? ServicesSearchFragment
                    val adapter = fragment?.adapter
                    val fragments = childFragmentManager?.fragments
                    for (fragment in fragments!!) {
                        Log.d("QUERY_TAG", fragment.javaClass.simpleName)
                    }
                    Log.d("QUERY_TAG", "fragment is " + fragment.toString())
                    if (adapter != null) {
                        Log.d("QUERY_TAG", "NOTNULL")
                        adapter.filter(newText?.toString() ?: "")
                    }
                } else if (tab_flag == 2) {
                    val fragment = childFragmentManager?.findFragmentByTag("DOCTORS_FRAGMENT_TAG") as? DoctorsSearchFragment
                    val adapter = fragment?.adapter
                    if (adapter != null) {
                        adapter.filter(newText?.toString() ?: "")
                    }
                } else if (tab_flag == 3) {
                    val fragment = childFragmentManager?.findFragmentByTag("CLINICS_FRAGMENT_TAG") as? ClinicSearchFragment
                    val adapter = fragment?.adapter
                    if (adapter != null) {
                        adapter.filter(newText?.toString() ?: "")
                    }
                }

                return true
            }
        })

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    Log.d("HANDLE_TAG", "handleOnBackPressed: ")
                    if (searchViewIsOpened){
                        val suggestionsSearchFragment = SuggestionsSearchFragment()
                        replaceChildFragment(suggestionsSearchFragment,
                            R.id.fragment_search_child_fragment,"SUGGESTIONS_FRAGMENT_TAG")
                        tab_flag=0
                    }
                    childFragmentManager.popBackStackImmediate()
                    searchViewIsOpened=false
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    fun Fragment.replaceChildFragment(fragment: Fragment, frameId: Int, replaceTag: String) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(frameId, fragment,replaceTag).commit()
        childFragmentManager.executePendingTransactions()

    }

    companion object {
        var tab_flag=1



    }



    override fun onClick(p0: View?) {

    }


}