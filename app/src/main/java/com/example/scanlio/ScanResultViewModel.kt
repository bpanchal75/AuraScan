package com.example.scanlio

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScanResultViewModel : ViewModel() {
    private val _payload = MutableStateFlow("")
    private val _formatLabel = MutableStateFlow("")
    val payload: StateFlow<String> = _payload.asStateFlow()
    val formatLabel: StateFlow<String> = _formatLabel.asStateFlow()

    fun setResult(payload: String, formatLabel: String) {
        _payload.value = payload
        _formatLabel.value = formatLabel
    }
}
