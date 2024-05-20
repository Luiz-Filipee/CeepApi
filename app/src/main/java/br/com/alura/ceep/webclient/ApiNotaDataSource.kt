package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.data.model.Nota
import br.com.alura.ceep.webclient.model.NotaRequisicao

private const val TAG = "NotaWebClient"

class ApiNotaDataSource {

    private val notaService = RetrofitInicializador().notaService

    suspend fun buscaTodas(): List<Nota>? {
        return try {
            val NotasResposta = notaService
                .buscaTodas()
            return NotasResposta.map { notaResposta ->
                notaResposta.nota
            }
        } catch (e: Exception) {
            Log.e(TAG, "buscaTodas: ", e)
            null
        }
    }

    suspend fun salva(nota: Nota): Boolean {
        try {
            val resposta = notaService.salva(nota.id, NotaRequisicao(
                titulo = nota.titulo,
                descricao = nota.descricao,
                imagem = nota.imagem
            ))
            return resposta.isSuccessful

        } catch (e: Exception) {
            Log.e(TAG, "salva: falha ao tentar salvar", e)
        }
        return false
    }

    suspend fun remove(id: String): Boolean {
        try {
            notaService.remove(id)
            return true
        } catch (e: Exception) {
            Log.e(TAG, "remove: falha ao remover", e)
        }
        return false
    }
}