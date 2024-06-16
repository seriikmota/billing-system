package com.ueg.probweb.billingsystem.repositorys;

import com.ueg.probweb.billingsystem.entities.Sale;
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
    @Query("SELECT s.createdDate, SUM(s.salePrice) "
            + "FROM Sale s "
            + "WHERE s.createdDate BETWEEN :initialDate AND :finalDate "
            + "GROUP BY s.createdDate")
    List<Object[]> sumSalesPriceByCreatedDate(@Param("initialDate") LocalDate initialDate,
                                              @Param("finalDate") LocalDate finalDate);

    @Query("SELECT s.seller, SUM(s.salePrice) as totalSales " +
            "FROM Sale s " +
            "GROUP BY s.seller " +
            "HAVING SUM(s.salePrice) = (SELECT MAX(totalSales) FROM " +
            "(SELECT SUM(salePrice) as totalSales FROM Sale GROUP BY seller) AS subquery)")
    List<Object[]> findSellerWithHighestSales();


    @Query("SELECT s.client, SUM(s.salePrice) as totalSales " +
            "FROM Sale s " +
            "GROUP BY s.client " +
            "HAVING SUM(s.salePrice) = (SELECT MAX(totalSales) FROM " +
            "(SELECT SUM(salePrice) as totalSales FROM Sale GROUP BY client) AS subquery)")
    List<Object[]> findCustomerWithHighestSales();


    @Query("SELECT s.product, SUM(s.salePrice) as totalSales " +
            "FROM Sale s " +
            "GROUP BY s.product " +
            "HAVING SUM(s.salePrice) = (SELECT MAX(totalSales) FROM " +
            "(SELECT SUM(salePrice) as totalSales FROM Sale GROUP BY product) AS subquery)")
    List<Object[]> findProductWithHighestSales();

}

