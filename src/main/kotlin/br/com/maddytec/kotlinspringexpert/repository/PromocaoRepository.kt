package br.com.maddytec.kotlinspringexpert.repository

import br.com.maddytec.kotlinspringexpert.model.Promocao
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface PromocaoRepository: PagingAndSortingRepository<Promocao, Long> {

    @Query(value = "select p from Promocao p where p.preco <= :valor")
    fun findByPrecoAte(valor: Double): List<Promocao>
}