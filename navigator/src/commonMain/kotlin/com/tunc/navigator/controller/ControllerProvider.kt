package com.tunc.navigator.controller

import com.tunc.navigator.stack.ControllerItem
import com.tunc.navigator.stack.NavigationStack

class ControllerProvider {

    val stack = mutableMapOf<ControllerItem, NavigationStack>()

    fun findController(controllerItem: ControllerItem) = stack[controllerItem]

    fun addController(controllerItem: ControllerItem, default: NavigationStack) {
        if (stack[controllerItem] == null) {
            stack[controllerItem] = default
        }
    }

    fun removeController(controllerItem: ControllerItem) {
        stack.remove(controllerItem)
        stack[stack.keys.lastOrNull()]?.navigateUp()
    }

    companion object {
        val instance by lazy { ControllerProvider() }
    }
}