package edu.miu.walmartlogin.data

import java.io.Serializable

data class Product(
    val title: String,
    val price: String,
    val color: String,
    val image: String,
    val itemId: String,
    val desc: String,
) : Serializable