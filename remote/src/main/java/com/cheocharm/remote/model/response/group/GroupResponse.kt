package com.cheocharm.remote.model.response.group

data class GroupResponse(
    val groupName: String,
    val groupImageUrl: String,
    val bio: String,
    val createdAt: String,
    val count: Int,
    val userImageUrlList: List<String>
)
