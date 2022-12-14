package rest.shipment.controller;

import org.springframework.web.bind.annotation.*;
import rest.shipment.model.Delivery;
import rest.shipment.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/delivery/new")
    public void newDelivery(Delivery delivery, @RequestBody String city) {
        deliveryService.createDeliveryOrder(delivery, city);
    }
}
