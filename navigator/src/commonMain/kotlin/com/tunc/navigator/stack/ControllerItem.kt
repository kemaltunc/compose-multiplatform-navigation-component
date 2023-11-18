package com.tunc.navigator.stack

import com.tunc.navigator.controller.ControllerProvider


abstract class ControllerItem {
    fun get(): NavigationStack =
        ControllerProvider.instance.findController(this) ?: throw Exception("Not foundController")
}