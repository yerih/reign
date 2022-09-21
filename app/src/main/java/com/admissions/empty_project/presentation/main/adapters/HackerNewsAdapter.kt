package com.admissions.empty_project.presentation.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.admissions.domain.HackerNew
import com.admissions.empty_project.data.databinding.ItemLayoutBinding

class HackerNewsAdapter(private val listener: ()->Unit): ListAdapter<HackerNew, HackerNewsAdapter.ViewHolder>(DiffUtilCallback) {

    class ViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(hackerNew: HackerNew){binding.hackerNew = hackerNew}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { listener() }
    }

}


private object DiffUtilCallback: DiffUtil.ItemCallback<HackerNew>(){
    override fun areItemsTheSame(oldItem: HackerNew, newItem: HackerNew): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: HackerNew, newItem: HackerNew): Boolean = oldItem == newItem
}
