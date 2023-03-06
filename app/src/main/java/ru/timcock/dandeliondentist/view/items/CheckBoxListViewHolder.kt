package ru.timcock.dandeliondentist.view.items

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.timcock.dandeliondentist.R

class CheckBoxListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val item_checkbox: CheckBox = itemView.findViewById(R.id.checkbox_list_item_checkbox)
    private val item_textview: TextView = itemView.findViewById(R.id.checkbox_list_item_textview)

    init {
        itemView.setOnClickListener(this)
    }


    fun bind(item: CheckBoxListItemData){
    val text = item.item_text
    val isChecked = item.item_isChecked
    item_checkbox.isChecked = isChecked
    item_textview.text = text
    }

//    override fun onClick(v: View?) {
//        val position = adapterPosition
//        if (position != RecyclerView.NO_POSITION) {
//            val data = myData[position]
//            data.isSelected = !data.isSelected
//            notifyItemChanged(position)
//        }
//    }


}