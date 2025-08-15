package com.meyrforge.polarsync.feature_medication.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MedicationViewModel @Inject constructor() : ViewModel() {

    private val _medicationName = mutableStateOf("")
    val medicationName = _medicationName

    private val _medicationDosage = mutableStateOf("")
    val medicationDosage = _medicationDosage

    private val _isOptional = mutableStateOf(false)
    val isOptional = _isOptional

    fun onMedicationNameChange(name: String) {
        _medicationName.value = name
    }

    fun onMedicationDosageChange(dosage: String) {
        _medicationDosage.value = dosage
    }

    fun onIsOptionalChange(isOptional: Boolean) {
        _isOptional.value = isOptional
    }

    fun saveMedication(){}
}