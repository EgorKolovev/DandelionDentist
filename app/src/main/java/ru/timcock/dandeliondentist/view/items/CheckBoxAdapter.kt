package ru.timcock.dandeliondentist.view.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.timcock.dandeliondentist.R

class CheckBoxAdapter(): RecyclerView.Adapter<CheckBoxListViewHolder>() {

    private var mAllCheckBoxListItemData: ArrayList<CheckBoxListItemData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckBoxListViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.checkbox_list_item, parent, false)
        return CheckBoxListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (mAllCheckBoxListItemData == null) 0 else mAllCheckBoxListItemData!!.size
    }

    override fun onBindViewHolder(holder: CheckBoxListViewHolder, position: Int) {
        holder.bind(mAllCheckBoxListItemData!![position])
    }
    fun setmAllCheckBoxListItemData(repositories: ArrayList<CheckBoxListItemData>?) {
        mAllCheckBoxListItemData = repositories
        notifyDataSetChanged()
    }

}