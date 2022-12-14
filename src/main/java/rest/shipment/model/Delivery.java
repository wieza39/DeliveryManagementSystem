package rest.shipment.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "Delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Delivery Status")
    private DeliveryStatus deliveryStatus;

    @Column(name = "Delivery Volume")
    private DeliveryVolume deliveryVolume;

    @Column(name = "Creation Date")
    @CreationTimestamp
    private LocalDate creationDate;

    @Column(name = "ETA")
    private LocalDate estimatedDeliveryTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    private List<Parcel> parcelList;

}
