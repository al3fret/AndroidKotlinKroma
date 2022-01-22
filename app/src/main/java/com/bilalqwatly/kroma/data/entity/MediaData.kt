package com.bilalqwatly.kroma.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class MediaData : Serializable {

    @SerializedName("media-metadata")
    val mediaMetaDataList: ArrayList<MediaMetaData>? = null

}