package com.example.hselyceumapp.data.room.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""
            CREATE TABLE favorites (
                id INTEGER PRIMARY KEY NOT NULL,
                login TEXT NOT NULL,
                avatarUrl TEXT NOT NULL,
                htmlUrl TEXT NOT NULL
            )
        """)
    }
}