package rest.shipment.model;


import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Parcel() {}

}
