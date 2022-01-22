package com.bilalqwatly.kroma.data.remote.api.model.response

import com.bilalqwatly.kroma.data.entity.MediaData
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResultData: Serializable {

    @SerializedName("title")
    val title: String? = null

    @SerializedName("byline")
    val byline: String? = null

    @SerializedName("published_date")
    val publishedDate: String? = null

    @SerializedName("section")
    val section: String? = null

    @SerializedName("abstract")
    val abstract: String? = null

    @SerializedName("media")
    val media: ArrayList<MediaData>? = null
}