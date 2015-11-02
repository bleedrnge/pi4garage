package com.bleedrnge.pi4garage.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GarageController {

    private static GpioPinDigitalOutput lightPin;
    private static GpioPinDigitalOutput doorPin;
    private static GpioPinDigitalInput sensorPin;

    @RequestMapping("/")
    public String greeting() {
        return "UP";
    }

    @RequestMapping("/light")
    public String light() {
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
        }
        lightPin.high();

        return "OK";
    }

    @RequestMapping("/door")
    public String door() {
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
        }
        doorPin.high();

        return "OK";
    }

    @RequestMapping("/sensor")
    public String doorSensor() {
        if (sensorPin == null) {
            GpioController gpio = GpioFactory.getInstance();
            sensorPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, "MyDoor", PinPullResistance.PULL_UP);
        }

        if(sensorPin.isHigh()) {
            return "Open";
        }
        else{
            return "Closed";
        }
    }

}
