package ru.timcock.dandeliondentist.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.FragmentDoctorsSearchBinding
import ru.timcock.dandeliondentist.databinding.FragmentSelectedItemBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SelectedItemFragment : Fragment(), View.OnClickListener {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentSelectedItemBinding
    private lateinit var doctorAdapter: DoctorListAdapter

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

        return inflater.inflate(R.layout.fragment_selected_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentSelectedItemBinding.bind(view)
        doctorAdapter = DoctorListAdapter()
        var mallDoctors = arrayListOf<DoctorListItem>()
        val f = 5.0
        mallDoctors.add(DoctorListItem("Magomedova Anna Abchihba","Dentist","MC Noize",
            "",resources.getDrawable(R.drawable.smiling_doctor_template), "12 reviews",
            "Pushkina street", "22.03.2006",f))
        binding.doctorRecyclerView.adapter = doctorAdapter
        doctorAdapter.setmAllDoctorListItems(mallDoctors)
        binding.sortTileImageButton.setOnClickListener(this)
        binding.filterTileImageButton.setOnClickListener(this)
        binding.locationTileImageButton.setOnClickListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectedItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.sort_tile_imageButton->{
                SortDialogFragment().show(childFragmentManager, "MyCustomFragment")

            }

        }
    }
}