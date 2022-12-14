package rest.shipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.shipment.model.Parcel;

import java.util.Optional;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    Optional<Parcel> findParcelByParcelNumber(String parcelNumber);
    Optional<Parcel> findParcelByCity(String city);
    Optional<Parcel> findAllByCity(String city);
}
