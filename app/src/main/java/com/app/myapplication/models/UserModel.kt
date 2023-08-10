package com.app.myapplication.models

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("first_name")
    var firstName:String,

    @SerializedName("last_name")
    var lastName:String,

    @SerializedName("id")
    var id:Int,

    @SerializedName("email")
    var email:String,

    @SerializedName("avatar")
    var avatar:String

)