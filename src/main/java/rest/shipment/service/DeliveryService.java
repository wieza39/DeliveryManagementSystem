package rest.shipment.service;

import org.springframework.stereotype.Service;
import rest.shipment.model.Delivery;
import rest.shipment.model.DeliveryStatus;
import rest.shipment.model.DeliveryVolume;
import rest.shipment.model.Parcel;
import rest.shipment.repository.DeliveryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ParcelService parcelService;

    public DeliveryService(DeliveryRepository deliveryRepository, ParcelService parcelService) {
        this.deliveryRepository = deliveryRepository;
        this.parcelService = parcelService;
    }

    public void createDeliveryOrderForCityReference(String city) {
        Delivery delivery = new Delivery();

        delivery.setDeliveryStatus(DeliveryStatus.PREPARED);
        delivery.setDeliveryVolume(DeliveryVolume.SMALL); //To narazie na sztywno
        delivery.setParcelList(prepareDeliveryList(city));

//TO-DO      update ETA based on parcel.orderDate

        deliveryRepository.save(delivery);
    }

    public List<Delivery> getAllDeliveries() { return deliveryRepository.findAll(); }


    public List<Parcel> prepareDeliveryList(String city) {
        List<Parcel> parcelList = parcelService.getParcelsByCity(city);
        return parcelList;
    }

}
