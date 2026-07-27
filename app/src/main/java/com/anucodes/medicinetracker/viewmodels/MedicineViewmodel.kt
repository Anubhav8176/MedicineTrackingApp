package com.anucodes.medicinetracker.viewmodels

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anucodes.medicinetracker.room.MedicineDao
import com.anucodes.medicinetracker.room.MedicineEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MedicineViewmodel(private val medicineDao: MedicineDao): ViewModel(){

    private val _medicines = MutableStateFlow<List<MedicineEntity>>(emptyList())
    val medicines = _medicines.asStateFlow()

    init {
        getAllMedicines()
    }

    fun getAllMedicines() {
        viewModelScope.launch {
            try {
                medicineDao.getAllMedicine().collect { medicineList ->
                    val tempMedicineList = mutableListOf<MedicineEntity>()

                    medicineList.forEach { medicine ->
                        var isTaken = medicine.isTaken

                        if (medicine.isTaken) {
                            val nextDueTime = medicine.updatedAt +
                                    TimeUnit.DAYS.toMillis(medicine.frequencyDays.toLong())

                            if (nextDueTime < System.currentTimeMillis()) {
                                medicineDao.updateIsTaken(isTaken = false, medicine.id)
                                isTaken = false
                            }
                        }

                        tempMedicineList.add(medicine.copy(isTaken = isTaken))
                    }

                    _medicines.value = tempMedicineList
                }
            } catch (e: Exception) {
                Log.e("Medicine DB", "The error is ${e.message}")
            }
        }
    }

    fun addNewMedicine(medicineEntity: MedicineEntity){
        viewModelScope.launch {
            try {
                medicineDao.addMedicine(medicineEntity)
            }catch (e: Exception){
                Log.e("Medicine DB", "The error is ${e.message}")
            }
        }
    }

    fun updateMedicine(medicine: MedicineEntity){
        viewModelScope.launch {
            try {
                medicineDao.updateMedicine(medicine = medicine)
                Log.i("Medicine Home: ", "New Medicine: $medicine")
            }catch (e: Exception){
                Log.e("Medicine DB", "The error is ${e.message}")
            }
        }
    }
}


//Utility functions
fun toMinutesOfDay(hour: Int, minutes: Int): Int = hour*60 + minutes

fun fromMinutesOfDay(minutesOfDay: Int): Pair<Int, Int>{
    val hour = minutesOfDay/60
    val minute = minutesOfDay%60

    return hour to minute
}