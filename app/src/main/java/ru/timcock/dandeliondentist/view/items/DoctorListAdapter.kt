package ru.timcock.dandeliondentist.view.items

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.timcock.dandeliondentist.R


class DoctorListAdapter(): RecyclerView.Adapter<DoctorItemViewHolder>() {
    private var mAllDoctorListItem: ArrayList<DoctorListItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.user_card_template, parent, false)
        Log.d("RECYCLER_TAG", "onCreateViewHolder: ")
        return DoctorItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (mAllDoctorListItem == null) 0 else mAllDoctorListItem!!.size
    }

    override fun onBindViewHolder(holder: DoctorItemViewHolder, position: Int) {
        holder.bind(mAllDoctorListItem!![position])
    }

    fun setmAllDoctorListItems(repositories: ArrayList<DoctorListItem>?) {
        mAllDoctorListItem = repositories
        notifyDataSetChanged()
    }


}