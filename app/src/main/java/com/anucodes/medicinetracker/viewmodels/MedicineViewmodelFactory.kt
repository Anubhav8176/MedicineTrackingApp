package com.anucodes.medicinetracker.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anucodes.medicinetracker.room.MedicineDao

class MedicineViewmodelFactory(
    private val medicineDao: MedicineDao
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicineViewmodel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MedicineViewmodel(medicineDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}