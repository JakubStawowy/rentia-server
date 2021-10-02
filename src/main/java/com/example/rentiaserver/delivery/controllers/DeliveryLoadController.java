package com.example.rentiaserver.delivery.controllers;

import com.example.rentiaserver.constants.ApplicationConstants;
import com.example.rentiaserver.data.helpers.AnnouncementToCreatorHelper;
import com.example.rentiaserver.delivery.dao.DeliveryRepository;
import com.example.rentiaserver.delivery.helpers.DeliveryToCreateHelper;
import com.example.rentiaserver.delivery.to.DeliveryTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = ApplicationConstants.Origins.LOCALHOST_ORIGIN)
@RestController
@RequestMapping(value = DeliveryManageController.BASE_ENDPOINT)
public class DeliveryLoadController {

    public static final String BASE_ENDPOINT = ApplicationConstants.Urls.BASE_API_URL + "/delivery";

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryLoadController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @GetMapping("/deliverer")
    public List<DeliveryTo> getUserDeliveries(@RequestParam Long userId) {
        return deliveryRepository.findAllByDeliverer(userId)
                .stream().map(DeliveryToCreateHelper::create).collect(Collectors.toList());
    }

    @GetMapping("/principal")
    public List<DeliveryTo> getAllByPrincipal(@RequestParam Long userId) {
        return deliveryRepository.findAllByPrincipal(userId)
                .stream().map(DeliveryToCreateHelper::create).collect(Collectors.toList());
    }
}