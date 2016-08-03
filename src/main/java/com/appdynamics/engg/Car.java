package com.appdynamics.engg;

/**
 * Created by mohitagarwal on 02/08/16.
 */
public class Car {
    public enum CarType{
        COMPACT,FULL_SIZE;
    }

    public final String registration;

    public final CarType type;

    Car(String registration, CarType type) {

        this.registration = registration;

        this.type = type;
    }

}
