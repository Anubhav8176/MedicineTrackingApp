package com.anucodes.medicinetracker.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anucodes.medicinetracker.room.MedicineDao
import com.anucodes.medicinetracker.room.MedicineEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MedicineViewmodel(private val medicineDao: MedicineDao): ViewModel(){

    private val _medicines = MutableStateFlow<List<MedicineEntity>>(emptyList())
    val medicines = _medicines.asStateFlow()

    init {
        getAllMedicines()
    }

    fun getAllMedicines(){
        viewModelScope.launch {
            try {
                medicineDao.getAllMedicine().collect {medicineList->
                    _medicines.value = medicineList
                }
            }catch (e: Exception){
                Log.e("Medicine DB", "The error is ${e.cause}")
            }
        }
    }
}