package ru.timcock.dandeliondentist.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.FragmentDistrictsListBinding
import ru.timcock.dandeliondentist.databinding.FragmentMetroListBinding
import ru.timcock.dandeliondentist.view.items.CheckBoxAdapter
import ru.timcock.dandeliondentist.view.items.CheckBoxListItemData


class DistrictsListFragment : Fragment() {

    private lateinit var metro_list: ArrayList<CheckBoxListItemData>
    private  lateinit var checkBoxAdapter: CheckBoxAdapter
    private lateinit var binding: FragmentDistrictsListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_districts_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDistrictsListBinding.bind(view)
        checkBoxAdapter = CheckBoxAdapter()
        binding.districtRecyclerView.adapter = checkBoxAdapter
        metro_list = arrayListOf<CheckBoxListItemData>()
        metro_list.add(CheckBoxListItemData(item_isChecked = false,"Уралмаш"))
        checkBoxAdapter.setmAllCheckBoxListItemData(metro_list)
    }

}
