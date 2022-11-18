package com.gautam.json_passing.modal

import com.google.gson.annotations.SerializedName

data class callbackRespons(

    var page:Int,
    @SerializedName("per_page")
    var perPage:Int,
    var total:Int,
    @SerializedName("total_pages")
    var totalPage:Int,
    @SerializedName("data")
    var userlist:MutableList<User>,
    var support:Support


)
