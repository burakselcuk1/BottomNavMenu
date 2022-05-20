package com.example.tasarm1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.tasarm1.R
import com.example.tasarm1.data.CurrentCrypto


class TransacAdapter(private val dataSet: ArrayList<CurrentCrypto>) :
    RecyclerView.Adapter<TransacAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val image: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.yeni)
            image = view.findViewById(R.id.cryptoImg)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.main_page_row_item_two, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val cryptoImg =  R.id.cryptoImg

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].name

        viewHolder.itemView.apply {
            Glide.with(this).load(dataSet[position].img).into(cryptoImg)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

private fun <TranscodeType> RequestBuilder<TranscodeType>.into(cryptoImg: Int) {

}
