package com.anucodes.medicinetracker.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant


@Entity(tableName = "medicine")
data class MedicineEntity(

    //Medicine info
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val categories: String,
    val dose: String,
    val instructions: String,

    //Schedule
    val scheduledTime: Int,
    val frequencyDays: String = "Daily",
    val isActive: Boolean = true,

    //Basic timestamps
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
