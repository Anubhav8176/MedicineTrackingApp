package com.anucodes.medicinetracker.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface MedicineDao{
    @Upsert
    suspend fun addMedicine(medicine: MedicineEntity)

    @Delete
    suspend fun deleteMedicine(medicine: MedicineEntity)

    @Query("SELECT * FROM medicine")
    fun getAllMedicine(): Flow<List<MedicineEntity>>
}