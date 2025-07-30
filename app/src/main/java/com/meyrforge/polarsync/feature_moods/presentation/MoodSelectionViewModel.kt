package com.meyrforge.polarsync.feature_moods.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
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

    private val _highestMoodChosen = mutableStateOf("")
    var highestMoodChosen: State<String> = _highestMoodChosen

    private val _irritableMoodChosen = mutableStateOf("")
    var irritableMoodChosen: State<String> = _irritableMoodChosen

    private val _anxiousMoodChosen = mutableStateOf("")
    var anxiousMoodChosen: State<String> = _anxiousMoodChosen

    private val _depressedMoodChosen = mutableStateOf("")
    var depressedMoodChosen: State<String> = _depressedMoodChosen

    private val _notificationMessage = MutableLiveData<String?>(null)
    val notificationMessage: LiveData<String?> = _notificationMessage

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
            val areSaved = saveMoodSelectionUseCase(
                _highestMoodChosen.value,
                _irritableMoodChosen.value,
                _anxiousMoodChosen.value,
                _depressedMoodChosen.value
            )
            if (areSaved != null){
                _notificationMessage.value = "Guardado con éxito"
            }else{
                _notificationMessage.value = "Error al guardar"
            }
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

    fun clearMessage(){
        _notificationMessage.value = null
    }
}