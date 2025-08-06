package com.meyrforge.polarsync.feature_sleep.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meyrforge.polarsync.feature_sleep.domain.usecases.GetSleepTrackerByDateUseCase
import com.meyrforge.polarsync.feature_sleep.domain.usecases.SaveSleepTrackerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SleepTrackerViewModel @Inject constructor(
    private val saveSleepTrackerUseCase: SaveSleepTrackerUseCase,
    private val getSleepTrackerByDateUseCase: GetSleepTrackerByDateUseCase,
) :
    ViewModel() {
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

    private val _notificationMessage = MutableLiveData<String?>(null)
    val notificationMessage: LiveData<String?> = _notificationMessage

    fun onSliderChanged(sliderValue: Float) {
        _sliderPosition.value = sliderValue
    }

    fun onTimeSelectedChange(time: String) {
        _timeSelected.value = time
    }

    fun onNegativeThoughtsChange(value: Boolean) {
        _negativeThoughts.value = value
    }

    fun onAnxiousChange(value: Boolean) {
        _anxious.value = value
    }

    fun onSleepThroughNightChange(value: Boolean) {
        _sleepThroughNight.value = value
    }

    init {
        getTodaySleepTracker()
    }

    fun onSaveSleep() {
        viewModelScope.launch {
            val isSaved = saveSleepTrackerUseCase(
                _sliderPosition.value ?: 0f,
                _timeSelected.value ?: "00:00",
                _negativeThoughts.value ?: false,
                _anxious.value ?: false,
                _sleepThroughNight.value ?: false
            )
            if (isSaved != null) {
                _notificationMessage.value = "Guardado con éxito"
            } else {
                _notificationMessage.value = "Error al guardar"
            }
        }
    }

    fun getTodaySleepTracker() {
        viewModelScope.launch {
            val sleep = getSleepTrackerByDateUseCase()
            _sliderPosition.value = sleep.hoursSlept
            _timeSelected.value = sleep.wentToSleepAt
            _negativeThoughts.value = sleep.negativeThoughts
            _anxious.value = sleep.anxious
            _sleepThroughNight.value = sleep.sleepThroughNight
        }
    }

    fun clearMessage() {
        _notificationMessage.value = null
    }

}