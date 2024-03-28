package net.gamal.kahlesapptask.features.getPosts.data.models.dto


import com.google.gson.annotations.SerializedName

data class PostDTO(
    @SerializedName("body")
    var body: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: Int
)