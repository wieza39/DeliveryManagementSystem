package rest.shipment.controller;

import org.springframework.web.bind.annotation.*;
import rest.shipment.model.Parcel;
import rest.shipment.service.ParcelService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) { this.parcelService = parcelService; }

    @PostMapping
    public void newParcel(@RequestBody Parcel parcel) {
        parcelService.addNewParcel(parcel);
    }

    @GetMapping("/all")
    public List<Parcel> getAllParcels() {return parcelService.getAllParcels(); }

}
