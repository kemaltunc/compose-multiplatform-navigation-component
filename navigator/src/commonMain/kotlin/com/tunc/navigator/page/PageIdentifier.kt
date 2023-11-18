package com.tunc.navigator.page

data class PageIdentifier(
    val page: Page,
    var label: String = "",
    var isGroupItem: Boolean = false,
    var groupPageIdentifier: PageIdentifier? = null,
    var initialPage: Boolean = false
) {

    fun getClassName(): String {
        return page::class.simpleName.orEmpty() + label
    }
}