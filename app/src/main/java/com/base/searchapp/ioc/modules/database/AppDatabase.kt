package com.base.searchapp.ioc.modules.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.base.data.database.model.Color
import com.base.data.database.dao.ColorsDao

@Database(entities = [Color::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
	abstract fun colorsDao(): ColorsDao
}
