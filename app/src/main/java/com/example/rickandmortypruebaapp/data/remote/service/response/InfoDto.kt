package com.example.rickandmortypruebaapp.data.remote.service.response

data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)