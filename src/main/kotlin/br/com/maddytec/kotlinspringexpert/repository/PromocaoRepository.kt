package br.com.maddytec.kotlinspringexpert.repository

import br.com.maddytec.kotlinspringexpert.model.Promocao
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PromocaoRepository: PagingAndSortingRepository<Promocao, Long> {
}