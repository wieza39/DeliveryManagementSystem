package rest.shipment.service;

import org.springframework.stereotype.Service;
import rest.shipment.model.Delivery;
import rest.shipment.model.DeliveryStatus;
import rest.shipment.model.DeliveryVolume;
import rest.shipment.model.Parcel;
import rest.shipment.repository.DeliveryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ParcelService parcelService;

    public DeliveryService(DeliveryRepository deliveryRepository, ParcelService parcelService) {
        this.deliveryRepository = deliveryRepository;
        this.parcelService = parcelService;
    }

    public void createDeliveryOrder(Delivery delivery, String city) {
        delivery.setDeliveryStatus(DeliveryStatus.REGISTERED);
        delivery.setDeliveryVolume(DeliveryVolume.SMALL);
        delivery.setParcelList(setDeliveryList(city));
        delivery.setEstimatedDeliveryTime(delivery.getCreationDate().plusDays(3));
        deliveryRepository.save(delivery);
    }

    public List<Parcel> setDeliveryList(String city) {
        List<Parcel> parcelList = parcelService.getAllParcels();
        List<Parcel> finalList = parcelList.stream()
                .filter(p -> p.getCity() == city).collect(Collectors.toList());
        return finalList;
    }

}
