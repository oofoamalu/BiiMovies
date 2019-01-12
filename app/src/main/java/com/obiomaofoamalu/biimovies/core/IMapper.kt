package com.obiomaofoamalu.biimovies.core

//todo:kotlin doc
interface IMapper<T, U> {

    fun boToDto(bo: T): U

    fun dtoToBo(dto: U): T

    fun bosToDtos(bos: List<T>): List<U>

    fun dtosToBos(dtos: List<U>): List<T>
}
