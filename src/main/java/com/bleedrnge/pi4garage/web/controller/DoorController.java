package com.bleedrnge.pi4garage.web.controller;

import com.pi4j.io.gpio.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class DoorController {

    private static GpioPinDigitalOutput lightPin;
    private static GpioPinDigitalOutput doorPin;
    private static GpioPinDigitalInput sensorPin;

    @RequestMapping("/health")
    public ResponseEntity health() {
        return new ResponseEntity(HttpStatus.OK);
    }

    //toggles the garage door light
    @RequestMapping("/light")
    public ResponseEntity light() {
        if (lightPin == null) {
            GpioController gpio = GpioFactory.getInstance();
            lightPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLights");
        }

        lightPin.high();
        lightPin.low();
        try {
            Thread.sleep(250);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        lightPin.high();

        return new ResponseEntity(HttpStatus.OK);
    }


    //opens and closes the door
    @RequestMapping("/door")
    public ResponseEntity door() {
        if (doorPin == null) {
            GpioController gpio = GpioFactory.getInstance();
            doorPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyDoor");
        }

        doorPin.high();
        doorPin.low();
        try {
            Thread.sleep(250);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        doorPin.high();

        return new ResponseEntity(HttpStatus.OK);
    }


    //reads the state of the reed switch
    @RequestMapping("/status")
    public ResponseEntity doorStatus() {
        if (sensorPin == null) {
            GpioController gpio = GpioFactory.getInstance();
            sensorPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, "MyDoor", PinPullResistance.PULL_UP);
        }

        if(sensorPin.isHigh()) {
            return new ResponseEntity(HttpStatus.valueOf("Open"));
        }
        else{
            return new ResponseEntity(HttpStatus.valueOf("Closed"));
        }
    }

}
