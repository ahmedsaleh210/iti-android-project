package com.app.myapplication.core.model.body

import com.app.myapplication.models.Support
import com.app.myapplication.models.User
import com.google.gson.annotations.SerializedName

data class ResponseUserList (

    @SerializedName("page")
    var page:Int,

    @SerializedName("per_page")
    var perPage:Int,

    @SerializedName("total")
    var total:Int,

    @SerializedName("total_pages")
    var totlaPages:Int,

    @SerializedName("data")
    var data:List<User>,

    @SerializedName("support")
    var support: Support

)