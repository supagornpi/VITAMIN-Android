package com.how.vitamin.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.how.vitamin.model.Character
import com.how.vitamin.ui.SpaceItemDecoration
import com.how.vitamin.ui.detail.DetailAdapter
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

@BindingAdapter("bind:src")
fun setImageViewResource(view: ImageView, resId: Int) {
    view.setImageResource(resId)
}

@BindingAdapter("bind:background")
fun setBackgroundColor(view: RecyclerView, colorId: Int) {
    view.setBackgroundColor(view.context.resources.getColor(colorId))
}

@BindingAdapter("bind:adapter")
fun setAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
}

@BindingAdapter("bind:items")
fun setItems(view: RecyclerView, items: List<Character>?) {
    view.adapter = DetailAdapter().apply {
        itemList = items ?: emptyList()
        notifyDataSetChanged()
    }
}

@BindingAdapter("bind:itemDeco")
fun setDecoration(view: RecyclerView, space: Float) {
    view.addItemDecoration(SpaceItemDecoration(space.toInt(), 3))
}

@BindingAdapter("bind:transformer")
fun bindAdapterTransform(view: DiscreteScrollView, isTransform: Boolean) {
    if (isTransform) {
        view.setItemTransformer(
            ScaleTransformer.Builder()
                .setMaxScale(1.25f)
                .setMinScale(0.8f)
                .build()
        )
    }
}

@BindingAdapter("bind:loadUrl")
fun bindUrlImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}