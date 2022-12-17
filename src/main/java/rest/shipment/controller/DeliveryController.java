package rest.shipment.controller;

import org.springframework.web.bind.annotation.*;
import rest.shipment.model.Delivery;
import rest.shipment.service.DeliveryService;
import rest.shipment.service.ParcelService;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final ParcelService parcelService;

    public DeliveryController(DeliveryService deliveryService, ParcelService parcelService) {
        this.deliveryService = deliveryService;
        this.parcelService = parcelService;
    }

    @PostMapping("/new/{city}")
    public void newDeliveryOrder(@PathVariable String city) {
        deliveryService.createDeliveryOrderForCityReference(city);
        parcelService.updateParcelList(city);
    }

    @GetMapping
    public List<Delivery> showAllDeliveries() { return deliveryService.getAllDeliveries(); }
}
