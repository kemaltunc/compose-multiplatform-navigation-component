package com.tunc.navigator.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import com.tunc.navigator.controller.ControllerProvider
import com.tunc.navigator.page.Page
import com.tunc.navigator.page.PageIdentifier
import com.tunc.navigator.stack.NavigationStack
import com.tunc.navigator.stack.ControllerItem

@Composable
fun <T : Page> NavView(
    initial: PageIdentifier,
    controllerItem: ControllerItem,
    content: @Composable (page: T) -> Unit
) {

    val holder = rememberSaveableStateHolder()

    ControllerProvider.instance.apply {
        addController(controllerItem, NavigationStack(initial, holder))
        stack[controllerItem]?.stack?.lastOrNull()?.let {
            holder.SaveableStateProvider(it.getClassName()) {
                content.invoke(it.page as T)
            }
        } ?: run {
            removeController(controllerItem)
        }
    }
}
