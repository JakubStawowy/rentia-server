package com.example.rentiaserver.delivery.controllers;

import com.example.rentiaserver.constants.ApplicationConstants;
import com.example.rentiaserver.data.to.PackageTo;
import com.example.rentiaserver.delivery.dao.MessageDao;
import com.example.rentiaserver.delivery.helpers.MessageToCreateHelper;
import com.example.rentiaserver.delivery.po.MessagePo;
import com.example.rentiaserver.delivery.to.MessageTo;
import com.example.rentiaserver.delivery.to.OutgoingMessageTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = ApplicationConstants.Origins.LOCALHOST_ORIGIN)
@RestController
@RequestMapping(value = MessageLoadController.BASE_ENDPOINT)
public class MessageLoadController {

    public static final String BASE_ENDPOINT = ApplicationConstants.Urls.BASE_API_URL + "/messages";

    private final MessageDao messageDao;

    @Autowired
    public MessageLoadController(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @GetMapping("/sent")
    public List<MessageTo> loadMessagesSent(@RequestParam Long userId) {
        return messageDao.findAllBySender(userId)
                .stream()
                .map(MessageToCreateHelper::create).collect(Collectors.toList());
    }

    @GetMapping("/received")
    public List<MessageTo> loadMessagesReceived(@RequestParam Long userId) {
        return messageDao.findAllByReceiver(userId).stream().map(MessageToCreateHelper::create).collect(Collectors.toList());
    }
}
