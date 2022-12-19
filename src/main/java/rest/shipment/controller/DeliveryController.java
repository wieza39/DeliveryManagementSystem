package rest.shipment.controller;

import org.springframework.web.bind.annotation.*;
import rest.shipment.model.Delivery;
import rest.shipment.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/new/{city}")
    public void newDeliveryOrder(@PathVariable String city) {
        deliveryService.createDeliveryOrderForCityReference(city);
    }

    @GetMapping
    public List<Delivery> showAllDeliveries() { return deliveryService.getAllDeliveries(); }
}
