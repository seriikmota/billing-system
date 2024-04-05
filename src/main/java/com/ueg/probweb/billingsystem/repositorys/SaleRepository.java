package com.ueg.probweb.billingsystem.repositorys;

import com.ueg.probweb.billingsystem.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> getByCreatedDateBetween(LocalDate initialDate, LocalDate finalDate);
    @Query("SELECT SUM(s.salePrice) FROM Sale s")
    Double sumAllSalesPrice();
    @Query("SELECT SUM(s.salePrice) FROM Sale s WHERE s.createdDate BETWEEN :initialDate AND :finalDate")
    Double sumSalesPriceByCreatedDate(LocalDate initialDate, LocalDate finalDate);
}

