package com.anucodes.medicinetracker.presentation.utilities

import com.anucodes.medicinetracker.room.MedicineEntity

fun getMedSize(medicines: List<MedicineEntity>): Int{
    return medicines.size
}

fun getTakenMedSize(medicines: List<MedicineEntity>): Int{
    var isTaken = 0
    medicines.forEach {meds->
        if (meds.isTaken){
            isTaken++
        }
    }
    return isTaken
}