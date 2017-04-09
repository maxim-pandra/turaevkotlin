package com.example.maxim.turaevkotlin

interface BaseView<T> {

    fun setPresenter(presenter: T): Unit
}