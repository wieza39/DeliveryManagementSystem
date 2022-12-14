package rest.shipment.service;

import org.springframework.stereotype.Service;
import rest.shipment.model.Delivery;
import rest.shipment.model.Parcel;
import rest.shipment.repository.ParcelRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public void addNewParcel(Parcel parcel) {
        Optional<Parcel> checkIfDoubled = parcelRepository.findParcelByParcelNumber(parcel.getParcelNumber());
        if(checkIfDoubled.isPresent()) {
            throw new IllegalStateException("Parcel with provided 'Parcel Number' is already in the system.");
        }
        parcelRepository.save(parcel);
    }

//    public void updateRecords(String city) {
//        List<Delivery> currentDeliveries = deliveryService.getAllDeliveries();
//        List<Parcel> parcelsToBeUpdate = currentDeliveries.stream()
//                .filter(d -> d.getParcelList()
//                        .stream()
//                        .filter(s -> s.getCity() == city).forEach((Parcel p) -> {
//                            p.setDelivery(d.getId());
//                        });
//    }

    public List<Parcel> getAllParcels() { return  parcelRepository.findAll(); }



}
