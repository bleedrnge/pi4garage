package com.bleedrnge.pi4garage.web.controller;

import com.bleedrnge.pi4garage.persistence.model.AccessLog;
import com.bleedrnge.pi4garage.persistence.dao.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/accesslogs")
public class AccessLogController {

    private final AccessLogRepository accessLogRepository;

    @Autowired
    AccessLogController(AccessLogRepository accessLogRepository){
        this.accessLogRepository = accessLogRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<AccessLog> readAccessLogs(@PathVariable Instant time){
        return accessLogRepository.findAllByTimeBefore(time);
    }



}
