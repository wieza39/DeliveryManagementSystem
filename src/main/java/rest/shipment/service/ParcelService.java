package rest.shipment.service;

import org.springframework.stereotype.Service;
import rest.shipment.model.Delivery;
import rest.shipment.model.Parcel;
import rest.shipment.repository.DeliveryRepository;
import rest.shipment.repository.ParcelRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final DeliveryRepository deliveryRepository;

    public ParcelService(ParcelRepository parcelRepository, DeliveryRepository deliveryRepository) {
        this.parcelRepository = parcelRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public void addNewParcel(Parcel parcel) {
        Optional<Parcel> checkIfDoubled = parcelRepository.findParcelByParcelNumber(parcel.getParcelNumber());
        if(checkIfDoubled.isPresent()) {
            throw new IllegalStateException("Parcel with provided 'Parcel Number' is already in the system.");
        }
        parcelRepository.save(parcel);
    }

    public void updateParcelList(String city) {
        List<Delivery> deliveryList = deliveryRepository.findAll();

        for (Delivery deliver : deliveryList) {
            deliver.getParcelList().stream().filter(parcel -> parcel.getCity() == city).forEach(parcel -> {
            parcel.setDelivery(deliver);
            });}
    }


    public List<Parcel> getAllParcels() { return  parcelRepository.findAll(); }
    public List<Parcel> getParcelsByCity(String city) { return parcelRepository.findParcelByCity(city); }



}
