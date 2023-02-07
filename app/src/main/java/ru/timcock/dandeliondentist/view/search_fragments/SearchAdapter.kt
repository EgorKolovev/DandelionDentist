package ru.timcock.dandeliondentist.view.search_fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import ru.timcock.dandeliondentist.R

class SearchAdapter(private val context: Context, private val data: List<String>) : BaseAdapter() {

    private var filteredData: List<String> = data

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.search_list_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.text_view)
        val imageView = view.findViewById<ImageView>(R.id.image_view)
        val item = getItem(position) as String
        textView.text = item
        imageView.setImageResource(R.drawable.arrow_icon)
        return view
    }
    fun filter(query: String) {
        filteredData = data.filter { it.contains(query, ignoreCase = true) }
        notifyDataSetChanged()
    }

}

