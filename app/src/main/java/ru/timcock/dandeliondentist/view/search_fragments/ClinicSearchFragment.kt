package ru.timcock.dandeliondentist.view.search_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.FragmentClinicSearchBinding
import ru.timcock.dandeliondentist.view.activities.SelectedItemActivity


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ClinicSearchFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentClinicSearchBinding
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
        binding = FragmentClinicSearchBinding.bind(view)
        val data = listOf(
            "Кооператив Крысиные хвостики","Вагинальная запеканка",
            "Пустых оградок парадонтоз","Клиника Доктора Залупаева"

        )

        adapter = SearchAdapter(requireContext(), data)
        binding.clinicSearchListview.adapter = adapter
        binding.clinicSearchListview.setOnItemClickListener { parent, view, position, id ->
            val element = adapter.getItem(position)
            val intent = Intent(context, SelectedItemActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_clinic_search, container, false)
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClinicSearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}