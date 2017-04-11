package com.example.maxim.turaevkotlin.features.artists.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.maxim.turaevkotlin.R
import com.example.maxim.turaevkotlin.commons.adapter.ViewType
import com.example.maxim.turaevkotlin.commons.adapter.ViewTypeDelegateAdapter
import com.example.maxim.turaevkotlin.commons.extensions.inflate


class LoadingDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.item_loading)){
    }
}


