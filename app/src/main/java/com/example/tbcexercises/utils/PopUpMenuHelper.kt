package com.example.tbcexercises.utils


import androidx.appcompat.widget.PopupMenu

fun popUpMenuHelper(popup: PopupMenu) {
    try {
        val fields = popup.javaClass.declaredFields
        for (field in fields) {
            if ("mPopup" == field.name) {
                field.isAccessible = true
                val menuPopupHelper = field.get(popup)
                val classPopupHelper = Class.forName(menuPopupHelper.javaClass.name)
                val setForceIcons = classPopupHelper.getMethod("setForceShowIcon", Boolean::class.javaPrimitiveType)
                setForceIcons.invoke(menuPopupHelper, true)
                break
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

