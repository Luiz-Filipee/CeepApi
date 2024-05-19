package br.com.alura.ceep.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.alura.ceep.data.model.Nota
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalNotaDataSource {

    @Insert(onConflict = REPLACE)
    suspend fun salva(note: Nota)

    @Query("SELECT * FROM Nota")
    fun buscaTodas() : Flow<List<Nota>>

    @Query("SELECT * FROM Nota WHERE id = :id")
    fun buscaPorId(id: String): Flow<Nota>

    @Query("DELETE FROM Nota WHERE id = :id")
    suspend fun remove(id: String)

    @Insert(onConflict = REPLACE)
    suspend fun salva(notas: List<Nota>)

    @Query("SELECT * FROM Nota WHERE sincronizada = 0")
    fun buscaNaoSincronizadas(): Flow<List<Nota>>

}