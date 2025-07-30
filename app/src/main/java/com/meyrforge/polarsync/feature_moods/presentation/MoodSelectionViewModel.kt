package com.meyrforge.polarsync.feature_moods.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meyrforge.polarsync.feature_moods.domain.usecases.GetMoodsByDateUseCase
import com.meyrforge.polarsync.feature_moods.domain.usecases.SaveMoodSelectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoodSelectionViewModel @Inject constructor(
    private val saveMoodSelectionUseCase: SaveMoodSelectionUseCase,
    private val getMoodsByDateUseCase: GetMoodsByDateUseCase,
) :
    ViewModel() {

    private val _highestMoodChosen = MutableLiveData("")
    var highestMoodChosen: MutableLiveData<String> = _highestMoodChosen

    private val _irritableMoodChosen = MutableLiveData("")
    var irritableMoodChosen: MutableLiveData<String> = _irritableMoodChosen

    private val _anxiousMoodChosen = MutableLiveData("")
    var anxiousMoodChosen: MutableLiveData<String> = _anxiousMoodChosen

    private val _depressedMoodChosen = MutableLiveData("")
    var depressedMoodChosen: MutableLiveData<String> = _depressedMoodChosen

    fun onHighestMoodChosen(level: String) {
        _highestMoodChosen.value = level
    }

    fun onIrritableMoodChosen(level: String) {
        _irritableMoodChosen.value = level
    }

    fun onAnxiousMoodChosen(level: String) {
        _anxiousMoodChosen.value = level
    }

    fun onDepressedMoodChosen(level: String) {
        _depressedMoodChosen.value = level
    }

    init {
        getChosenMoods()
    }

    fun onSaveMoods() {
        viewModelScope.launch {
            saveMoodSelectionUseCase(
                _highestMoodChosen.value!!,
                _irritableMoodChosen.value!!,
                _anxiousMoodChosen.value!!,
                _depressedMoodChosen.value!!
            )
        }
    }

    private fun getChosenMoods() {
        viewModelScope.launch {
            val moods = getMoodsByDateUseCase()
            _highestMoodChosen.value = moods.highest
            _irritableMoodChosen.value = moods.irritable
            _anxiousMoodChosen.value = moods.anxious
            _depressedMoodChosen.value = moods.depressed
        }
    }
}