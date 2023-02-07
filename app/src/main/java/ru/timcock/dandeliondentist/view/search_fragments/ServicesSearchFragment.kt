package ru.timcock.dandeliondentist.view.search_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.FragmentSearchBinding
import ru.timcock.dandeliondentist.databinding.FragmentServicesSearchBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ServicesSearchFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var list: ListView
    private lateinit var  binding: FragmentServicesSearchBinding
    lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentServicesSearchBinding.bind(view)
        list=binding.servicesSearchListview
        val data = listOf(
            "Брекеты","Клизма",
            "Чистка"

        )
        adapter = SearchAdapter(requireContext(), data)
        list.adapter = adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_services_search, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ServicesSearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}