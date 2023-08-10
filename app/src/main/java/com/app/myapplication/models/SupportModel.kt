package com.app.myapplication.models
import com.google.gson.annotations.SerializedName

data class Support (

    @SerializedName("url")
    var url:String,

    @SerializedName("text")
    var text:String

)