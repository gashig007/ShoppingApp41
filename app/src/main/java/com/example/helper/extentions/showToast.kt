package com.example.helper.extentions

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.showToastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}