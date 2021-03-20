package com.how.vitamin.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.how.vitamin.R
import com.how.vitamin.databinding.ItemHouseBinding

import com.how.vitamin.ui.HouseType
import com.how.vitamin.ui.HouseType.*

class MainAdapter(val action: (ImageView, HouseType) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val items = mutableListOf(
        Gryffindor,
        Slytherin,
        Ravenclaw,
        Hufflepuff
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<ItemHouseBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_house,
            parent,
            false
        ).let { MainViewHolder(it) }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(items[position])

    inner class MainViewHolder(private val binding: ItemHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HouseType) {
            binding.apply {
                house = item
                executePendingBindings()
                root.setOnClickListener { action(binding.imageViewItemHouseLogo, item) }
            }
        }
    }
}