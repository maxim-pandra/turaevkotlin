package com.example.maxim.turaevkotlin.commons

import android.os.Parcel
import android.os.Parcelable
import com.example.maxim.turaevkotlin.commons.adapter.AdapterConstants
import com.example.maxim.turaevkotlin.commons.adapter.ViewType
import com.example.maxim.turaevkotlin.commons.extensions.createParcel

/**
 * Created by maxim on 4/9/2017.
 */
data class ArtistsItem(
        val id: Long,
        val name: String,
        val cover: String
) : ViewType, Parcelable {

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { ArtistsItem(it) }
    }

    protected constructor(parcelIn: Parcel) : this(
            parcelIn.readLong(),
            parcelIn.readString(),
            parcelIn.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id)
        dest.writeString(name)
        dest.writeString(cover)
    }

    override fun describeContents() = 0

    override fun getViewType() = AdapterConstants.ARTISTS
}

data class Artists(
        val news: List<ArtistsItem>)  : Parcelable {

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { Artists(it) }
    }

    protected constructor(parcelIn: Parcel) : this(
            mutableListOf<ArtistsItem>().apply {
                parcelIn.readTypedList(this, ArtistsItem.CREATOR)
            }
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeTypedList(news)
    }

    override fun describeContents() = 0
}
