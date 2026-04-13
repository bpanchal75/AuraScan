package com.example.scanlio

import android.net.Uri
import android.util.Patterns

/**
 * Returns an http(s) [Uri] suitable for [Intent.ACTION_VIEW], or null if the payload is not treated as a web link.
 */
fun webUriForOpen(raw: String): Uri? {
    val t = raw.trim()
    if (t.isEmpty()) return null

    if (t.startsWith("http://", ignoreCase = true) || t.startsWith("https://", ignoreCase = true)) {
        return try {
            Uri.parse(t).takeIf { it.scheme?.equals("http", true) == true || it.scheme?.equals("https", true) == true }
        } catch (_: Exception) {
            null
        }
    }

    if (Patterns.WEB_URL.matcher(t).matches()) {
        return try {
            Uri.parse("https://$t")
        } catch (_: Exception) {
            null
        }
    }

    return null
}
