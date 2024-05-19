package br.com.alura.ceep.data.repository

import br.com.alura.ceep.data.dao.LocalNotaDataSource
import br.com.alura.ceep.data.model.Nota
import br.com.alura.ceep.webclient.ApiNotaDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class NotaRepository(
    private val localNotaDataSource: LocalNotaDataSource,
    private val apiNotaDataSource: ApiNotaDataSource
) {

    fun buscaTodas(): Flow<List<Nota>> {
        return localNotaDataSource.buscaTodas()
    }

    suspend fun atualizaTodas(){
        apiNotaDataSource.buscaTodas()?.let { notas ->
            val notasSincronizadas = notas.map { nota ->
                nota.copy(sincronizada = true)
            }
            localNotaDataSource.salva(notasSincronizadas)
        }
    }

    fun buscaPorId(id: String): Flow<Nota> {
        return localNotaDataSource.buscaPorId(id)
    }

    suspend fun remove(id: String) {
        localNotaDataSource.remove(id)
        apiNotaDataSource.remove(id)
    }

    suspend fun salva(nota: Nota) {
        localNotaDataSource.salva(nota)
        if(apiNotaDataSource.salva(nota)){
            val notaSincronizada = nota.copy(sincronizada = true)
            localNotaDataSource.salva(notaSincronizada)
        }
    }

    suspend fun sincroniza(){
        val notasNaoSincronizadas = localNotaDataSource.buscaNaoSincronizadas().first()
        notasNaoSincronizadas.forEach{ notaNaoSincronizada ->
            salva(notaNaoSincronizada)
        }
        atualizaTodas()
    }
}