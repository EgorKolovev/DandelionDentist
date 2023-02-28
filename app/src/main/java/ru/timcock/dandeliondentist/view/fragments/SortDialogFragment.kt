package ru.timcock.dandeliondentist.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ru.timcock.dandeliondentist.R
import ru.timcock.dandeliondentist.databinding.SortDialogLayoutBinding

class SortDialogFragment: DialogFragment(), View.OnClickListener {
    lateinit var binding: SortDialogLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner_dialog);
        return inflater.inflate(R.layout.sort_dialog_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SortDialogLayoutBinding.bind(view)
        binding.priceTextview.setOnClickListener(this)
        binding.ratingTextview.setOnClickListener(this)
        binding.nearestAppointmentTextview.setOnClickListener(this)
        binding.nearestToMeTextview.setOnClickListener(this)
        binding.useSortButton.setOnClickListener(this)
    }
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.price_textview->binding.priceCheckbox.isChecked = !binding.priceCheckbox.isChecked
            R.id.rating_textview->binding.ratingCheckbox.isChecked = !binding.ratingCheckbox.isChecked
            R.id.nearest_appointment_textview->binding.nearestAppointmentDateCheckbox.isChecked = !binding.nearestAppointmentDateCheckbox.isChecked
            R.id.nearest_to_me_textview->binding.proximityToMeCheckbox.isChecked = !binding.proximityToMeCheckbox.isChecked
            R.id.use_sort_button->dismiss()
        }
    }

}