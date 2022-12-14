package rest.shipment.service;

import org.springframework.stereotype.Service;
import rest.shipment.model.Parcel;
import rest.shipment.repository.ParcelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository) { this.parcelRepository = parcelRepository; }

    public void addNewParcel(Parcel parcel) {
        Optional<Parcel> checkIfDoubled = parcelRepository.findParcelByParcelNumber(parcel.getParcelNumber());
        if(checkIfDoubled.isPresent()) {
            throw new IllegalStateException("Parcel with provided 'Parcel Number' is already in the system.");
        }
        parcelRepository.save(parcel);
    }

    public List<Parcel> getAllParcels() { return  parcelRepository.findAll(); }

//    public Optional<Parcel> getParcelByCity(String city) {
//        return parcelRepository.findParcelByCity(city);
//    }

    //update parcel.delivery_id

}
