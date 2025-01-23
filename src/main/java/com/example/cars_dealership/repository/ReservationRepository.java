package com.example.cars_dealership.repository;

import com.example.cars_dealership.enums.StatusReservation;
import com.example.cars_dealership.model.Reservation;
import com.example.cars_dealership.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByClient(User client);
    List<Reservation> findByStatusReservation(StatusReservation statusReservation);
    Page<Reservation> findAllByOrderByDateDesc(Pageable pageable);

    @Query("SELECT r FROM Reservation r WHERE " +
            "(:clientId IS NULL OR CAST(r.client.id_user AS string) LIKE %:clientId%) AND " +
            "(:variantId IS NULL OR CAST(r.variant.idVariant AS string) LIKE %:variantId%) AND " +
            "(:reservationId IS NULL OR CAST(r.idReservation AS string) LIKE %:reservationId%) AND " +
            "(:status IS NULL OR r.statusReservation = :status)"+
            "ORDER BY r.date DESC")
    List<Reservation> findReservations(
            @Param("clientId") String clientId,
            @Param("variantId") String variantId,
            @Param("reservationId") String reservationId,
            @Param("status") StatusReservation status);
}
