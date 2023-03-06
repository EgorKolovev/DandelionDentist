package ru.timcock.dandeliondentist.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.FragmentSelectedItemBinding
import ru.timcock.dandeliondentist.view.activities.WhereSortActivity
import ru.timcock.dandeliondentist.view.items.DoctorListAdapter
import ru.timcock.dandeliondentist.view.items.DoctorListItem

class SelectedItemFragment : Fragment(), View.OnClickListener {


    private lateinit var binding: FragmentSelectedItemBinding
    private lateinit var doctorAdapter: DoctorListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_selected_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectedItemBinding.bind(view)
        doctorAdapter = DoctorListAdapter()
        var mallDoctors = arrayListOf<DoctorListItem>()
        val f = 5.0
        mallDoctors.add(
            DoctorListItem(
                "Magomedova Anna Abchihba", "Dentist", "MC Noize",
                "", resources.getDrawable(R.drawable.smiling_doctor_template), "12 reviews",
                "Pushkina street", "22.03.2006", f
            )
        )
        binding.doctorRecyclerView.adapter = doctorAdapter
        doctorAdapter.setmAllDoctorListItems(mallDoctors)
        binding.sortTileImageButton.setOnClickListener(this)
        binding.filterTileImageButton.setOnClickListener(this)
        binding.locationTileImageButton.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        when(v?.id){
            R.id.sort_tile_imageButton ->{
                SortDialogFragment().show(childFragmentManager, "MyCustomFragment")

            }
            R.id.location_tile_imageButton->{
                val intent = Intent(context, WhereSortActivity::class.java)
                startActivity(intent)
            }

        }
    }



}