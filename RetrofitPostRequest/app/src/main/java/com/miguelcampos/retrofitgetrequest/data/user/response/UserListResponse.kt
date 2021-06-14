package com.miguelcampos.retrofitgetrequest.data.user.response

data class UserListResponse(
    val `data`: List<User>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)