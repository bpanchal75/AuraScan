package com.aurascan.qrscanner

import android.content.Context
import android.content.Intent
import android.provider.Settings

data class BluetoothActionSpec(
    val name: String? = null,
    val address: String? = null,
) {
    val isValid: Boolean get() = name != null || address != null
}

fun parseBluetoothPayload(raw: String): BluetoothActionSpec? {
    if (!raw.startsWith("BT:", ignoreCase = true)) return null
    
    val name = Regex("N:([^;]+);", RegexOption.IGNORE_CASE).find(raw)?.groupValues?.get(1)
    val address = Regex("A:([^;]+);", RegexOption.IGNORE_CASE).find(raw)?.groupValues?.get(1)
    
    return if (name != null || address != null) {
        BluetoothActionSpec(name, address)
    } else {
        null
    }
}

fun Context.openBluetoothSettings() {
    try {
        val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    } catch (_: Exception) {
        // Fallback to general settings if Bluetooth settings is unavailable
        val intent = Intent(Settings.ACTION_SETTINGS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    }
}
