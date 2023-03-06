package ru.timcock.dandeliondentist.view.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.timcock.dandeliondentist.R

class CheckBoxAdapter(): RecyclerView.Adapter<CheckBoxAdapter.CheckBoxListViewHolder>() {

    private var mAllCheckBoxListItemData: ArrayList<CheckBoxListItemData>? = null
    private val selectedPositions = HashSet<Int>()

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
        holder.bind(mAllCheckBoxListItemData!![position],selectedPositions.contains(position))
    }

    fun setmAllCheckBoxListItemData(repositories: ArrayList<CheckBoxListItemData>?) {
        mAllCheckBoxListItemData = repositories
        notifyDataSetChanged()
    }

    inner class CheckBoxListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val item_checkbox: CheckBox =
            itemView.findViewById(R.id.checkbox_list_item_checkbox)
        private val item_textview: TextView =
            itemView.findViewById(R.id.checkbox_list_item_textview)

        init {
            itemView.setOnClickListener(this)
        }


        fun bind(data: CheckBoxListItemData, isSelected: Boolean) {
            item_textview.text = data.item_text
            item_checkbox.isChecked = isSelected
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (selectedPositions.contains(position)) {
                    selectedPositions.remove(position)
                } else {
                    selectedPositions.add(position)
                }
                updateCheckboxState()
            }
        }
        private fun updateCheckboxState() {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val data = mAllCheckBoxListItemData!![position]
                bind(data, selectedPositions.contains(position))
            }
        }

    }
    fun setSelectedPositions(positions: Set<String>) {
        selectedPositions.clear()
        positions.forEach { selectedPositions.add(it.toInt()) }
        notifyDataSetChanged()
    }

    fun getSelectedPositions(): HashSet<String> {
        val selected = HashSet<String>()
        selectedPositions.forEach { selected.add(it.toString()) }
        return selected
    }
}