package ru.timcock.dandeliondentist.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.FragmentMetroListBinding
import ru.timcock.dandeliondentist.view.items.CheckBoxAdapter
import ru.timcock.dandeliondentist.view.items.CheckBoxListItemData


class MetroListFragment : Fragment() {


    private lateinit var metro_list: ArrayList<CheckBoxListItemData>
    private  lateinit var checkBoxAdapter: CheckBoxAdapter
    lateinit var binding: FragmentMetroListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_metro_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentMetroListBinding.bind(view)
        checkBoxAdapter = CheckBoxAdapter()
        binding.metroRecyclerView.adapter = checkBoxAdapter
        metro_list = arrayListOf<CheckBoxListItemData>()
        metro_list.add(CheckBoxListItemData(item_isChecked = false,"Динамо"))
        checkBoxAdapter.setmAllCheckBoxListItemData(metro_list)
        checkBoxAdapter.onItemClick = {
            it.item_isChecked = !it.item_isChecked
        }
    }


}