package com.example.cars_dealership.repository;

import com.example.cars_dealership.enums.StatusCommande;
import com.example.cars_dealership.model.Commande;
import com.example.cars_dealership.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findAllByClient(User clinet);
    Page<Commande> findAllByOrderByDateDesc(Pageable pageable);

    @Query("SELECT c FROM Commande c WHERE " +
            "(:clientId IS NULL OR CAST(c.client.id_user AS string) LIKE %:clientId%) AND " +
            "(:variantId IS NULL OR CAST(c.variant.idVariant AS string) LIKE %:variantId%) AND " +
            "(:commandeId IS NULL OR CAST(c.idCommande AS string) LIKE %:commandeId%) AND " +
            "(:price IS NULL OR c.totalPrice <= CAST(:price AS bigdecimal)) AND " +
            "(:status IS NULL OR c.statusCommande = :status) " +
            "ORDER BY c.date DESC")
    List<Commande> findCommandes(
            @Param("clientId") String clientId,
            @Param("variantId") String variantId,
            @Param("commandeId") String commandeId,
            @Param("price") String price,
            @Param("status") StatusCommande status);

}
