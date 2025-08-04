package com.meyrforge.polarsync.feature_sleep.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SleepTrackerViewModel @Inject constructor(): ViewModel() {
    private val _sliderPosition = MutableLiveData(0f)
    var sliderPosition = _sliderPosition

    private val _timeSelected = MutableLiveData("")
    var timeSelected = _timeSelected

    private val _negativeThoughts = MutableLiveData(false)
    var negativeThoughts = _negativeThoughts

    private val _anxious = MutableLiveData(false)
    var anxious = _anxious

    private val _sleepThroughNight = MutableLiveData(false)
    var sleepThroughNight = _sleepThroughNight

    fun onSliderChanged(sliderValue: Float) {
        _sliderPosition.value = sliderValue
    }

    fun onTimeSelectedChange(time: String){
        _timeSelected.value = time
    }
}