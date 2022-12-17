package rest.shipment.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Parcels")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Parcel Number", unique = true)
    private String parcelNumber;

    @Column(name = "Weight")
    private double weight;

    @Column(name = "City")
    private String city;

    @Column(name = "Order date")
    @CreationTimestamp
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


//    public void setDelivery(Delivery delivery) {
//        this.delivery = delivery;
//        if(!delivery.getParcelList().contains(this)) {
//            delivery.getParcelList().add(this);
//        }
//    }
    public Parcel() {}

}
