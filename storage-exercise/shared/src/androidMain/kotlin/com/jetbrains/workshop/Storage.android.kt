package com.jetbrains.workshop

import android.app.Application
import android.content.Context

val context get() = ContextHelper.currentContext!!

actual fun persistString(key: String, value: String) {
    context.getSharedPreferences("mypref", Context.MODE_PRIVATE).edit().putString(key, value).apply()
}

actual fun restoreString(key: String): String {
    return context.getSharedPreferences("mypref", Context.MODE_PRIVATE).getString(key, "") ?: ""
}
