package com.ueg.probweb.billingsystem.repositorys;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> getByCreatedDateBetween(LocalDate initialDate, LocalDate finalDate);

    @Query("SELECT SUM(s.salePrice) FROM Sale s")
    Double sumAllSalesPrice();

//    @Query("SELECT SUM(s.salePrice) FROM Sale s WHERE s.createdDate BETWEEN :initialDate AND :finalDate")
//    Double sumSalesPriceByCreatedDate(LocalDate initialDate, LocalDate finalDate);

    @Query(value = "SELECT new com.ueg.probweb.billingsystem.entities.dtos.TotalSalePerDateDTO(s.createdDate, SUM(s.salePrice))"
            + "FROM Sale s "
            + "WHERE s.createdDate BETWEEN :initialDate AND :finalDate "
            + "GROUP BY s.createdDate")
    List<TotalSalePerDateDTO> sumSalesPriceByCreatedDate(@Param("initialDate") LocalDate initialDate,
                                                         @Param("finalDate") LocalDate finalDate);

    @Query("SELECT new com.ueg.probweb.billingsystem.entities.dtos.HighestSellerDTO(s.seller, SUM(s.salePrice)) " +
            "FROM Sale s " +
            "GROUP BY s.seller " +
            "HAVING SUM(s.salePrice) = (SELECT MAX(subquery.totalSales) FROM " +
            "(SELECT SUM(salePrice) as totalSales FROM Sale GROUP BY seller) AS subquery)")
    HighestSellerDTO findSellerWithHighestSales();


    @Query("SELECT new com.ueg.probweb.billingsystem.entities.dtos.HighestClientDTO(s.client, SUM(s.salePrice)) " +
            "FROM Sale s " +
            "GROUP BY s.client " +
            "HAVING SUM(s.salePrice) = (SELECT MAX(subquery.totalSales) FROM " +
            "(SELECT SUM(salePrice) as totalSales FROM Sale GROUP BY client) AS subquery)")
    HighestClientDTO findCustomerWithHighestSales();


    @Query("SELECT new com.ueg.probweb.billingsystem.entities.dtos.HighestProductDTO(s.product, SUM(s.salePrice)) " +
            "FROM Sale s " +
            "GROUP BY s.product " +
            "HAVING SUM(s.salePrice) = (SELECT MAX(subquery.totalSales) FROM " +
            "(SELECT SUM(salePrice) as totalSales FROM Sale GROUP BY product) AS subquery)")
    HighestProductDTO findProductWithHighestSales();

}

