package com.meyrforge.polarsync.feature_sleep.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SleepTrackerViewModel @Inject constructor(): ViewModel() {
    private val _sliderPosition = MutableLiveData(0f)
    var sliderPosition = _sliderPosition

    fun onSliderChanged(sliderValue: Float) {
        _sliderPosition.value = sliderValue
    }
}