package com.anucodes.medicinetracker.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [MedicineEntity::class],
    version = 2,
    exportSchema = false
)
abstract class MedicineDatabase: RoomDatabase() {
    abstract fun MedicineDao(): MedicineDao
    companion object{
        @Volatile
        private var INSTANCE: MedicineDatabase? = null
        fun getDb(context: Context): MedicineDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context = context,
                    MedicineDatabase::class.java,
                    "medicine_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}