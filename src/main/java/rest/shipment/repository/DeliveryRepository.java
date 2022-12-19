package rest.shipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.shipment.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {


}
