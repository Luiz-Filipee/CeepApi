package br.com.alura.ceep.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.alura.ceep.data.dao.LocalNotaDataSource
import br.com.alura.ceep.data.migrations.MIGRATIONS_2_3
import br.com.alura.ceep.data.migrations.MIGRATIONS_3_4
import br.com.alura.ceep.data.migrations.MIGRATION_1_2
import br.com.alura.ceep.data.model.Nota

@Database(
    version = 4,
    entities = [Nota::class],
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun notaDao(): LocalNotaDataSource

    companion object {
        @Volatile
        private var db: AppDatabase? = null

        fun instancia(context: Context): AppDatabase {
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "ceep.db"
            ).addMigrations(MIGRATION_1_2,MIGRATIONS_2_3,MIGRATIONS_3_4)
                .build()
        }
    }

}