package com.appdynamics.engg;

/**
 * Created by mohitagarwal on 02/08/16.
 */

public class Receipt {
    int id;
    int slotType;
    int timeStamp;
    Receipt (int id, int slotType, int timeStamp){
        this.id = id;
        this.slotType = slotType;
        this.timeStamp = timeStamp;
    }
}
