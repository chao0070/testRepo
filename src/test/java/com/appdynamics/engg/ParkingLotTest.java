package com.appdynamics.engg;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mohitagarwal on 02/08/16.
 */
public class ParkingLotTest {

    ParkingLot p = new ParkingLot(3,2,1);
    Car car = new Car("A1234",Car.CarType.FULL_SIZE);
    Car car2 = new Car("A12e34",Car.CarType.COMPACT);
    Car car3= new Car("A123r4r",Car.CarType.FULL_SIZE);
    Car car4 = new Car("A12t34",Car.CarType.COMPACT);
    Car car5 = new Car("A12tg34",Car.CarType.FULL_SIZE);

    @Test
    public void checkInTest() {

        Receipt r = p.checkin(car,true);
        Assert.assertEquals(r.id,0);
        Assert.assertEquals(r.slotType,2);

        Receipt r2 = p.checkin(car2,false);
        Assert.assertEquals(r2.id,1);
        Assert.assertEquals(r2.slotType,1);

        Receipt r3 = p.checkin(car3,false);
        Assert.assertEquals(r3.id,2);
        Assert.assertEquals(r3.slotType,0);

        Car c = p.checkout(r2);
        Assert.assertEquals(c.registration,car2.registration);

        Receipt r4 = p.checkin(car4,true);
        Assert.assertEquals(r4.id,1);
        Assert.assertEquals(r4.slotType,1);


        /*
        Assert.assertEquals();
        System.out.println(r.id);
        System.out.println(p.carlist[0].registration);
        Car c1 = p.checkout(r);
        System.out.println(c1.registration);*/

    }
    @Test
    public void checkOutTest() {

    }



}
