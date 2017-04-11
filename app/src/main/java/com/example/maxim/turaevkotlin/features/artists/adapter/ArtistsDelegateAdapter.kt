package com.example.maxim.turaevkotlin.features.artists.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.maxim.turaevkotlin.R
import com.example.maxim.turaevkotlin.commons.ArtistsItem
import com.example.maxim.turaevkotlin.commons.adapter.ViewType
import com.example.maxim.turaevkotlin.commons.adapter.ViewTypeDelegateAdapter
import com.example.maxim.turaevkotlin.commons.extensions.inflate
import com.example.maxim.turaevkotlin.commons.extensions.loadImg
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistsDelegateAdapter :ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as ArtistsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.item_artist)) {

        fun bind(item: ArtistsItem) = with(itemView) {
            img_thumbnail.loadImg(item.cover)
            description.text = item.name
        }
    }
}