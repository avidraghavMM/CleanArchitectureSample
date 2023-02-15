package com.example.domain.mapper

interface Mapper<M, ME> {
    fun map(entity: ME): M
}
