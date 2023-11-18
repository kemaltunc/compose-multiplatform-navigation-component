package com.tunc.navigator.stack

import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tunc.navigator.page.Page
import com.tunc.navigator.page.PageIdentifier

typealias Stack<T> = SnapshotStateList<T>

inline fun <T> Stack<T>.push(item: T) = add(item)

inline fun <T> Stack<T>.pop() = if (isNotEmpty()) removeAt(lastIndex) else null

fun <T> Stack<T>.peek(): T? = if (isNotEmpty()) this[lastIndex] else null


inline fun <T> Stack<T>.switch(item: T) {
    remove(item)
    add(item)
}

class NavigationStack(initial: PageIdentifier, private val holder: SaveableStateHolder) {

    var stack = Stack<PageIdentifier>()

    init {
        stack.push(initial)
    }


    fun navigate(
        screen: PageIdentifier,
    ) {
        stack.lastOrNull()?.let { identifier ->
            if (identifier.isGroupItem && screen.isGroupItem.not()) {
                screen.apply {
                    groupPageIdentifier = identifier
                }
            }
        }

        val findScreen = stack.lastOrNull { it.groupPageIdentifier == screen } ?: run {
            screen
        }

        stack.lastOrNull()?.let { last ->
            if (last.initialPage && last.getClassName() == findScreen.getClassName()) {
                findScreen.initialPage = true
            }
        }


        stack.switch(findScreen)

    }

    fun navigateUp() {
        if (stack.isNotEmpty()) {
            holder.removeState(stack.last().getClassName())
            stack.pop()
        }
    }

    fun isCurrentPage(page: Page): Boolean {
        return stack.peek()?.let { it.page == page }
            ?: false
    }

    fun isGroupItem(page: Page): Boolean {
        return stack.peek()?.let { it.page == page || it.groupPageIdentifier?.page == page }
            ?: false
    }

}
