package com.appdynamics.engg;

import java.util.ArrayList;

/**
 * Created by mohitagarwal on 02/08/16.
 */


public class ParkingLot {
    int fullSize, comapctSize, handyCapSize;
    int curFull, curComp, curHandy;

    Car[] carlist;

    ParkingLot(int f, int c, int h){
        this.fullSize = f;
        this.comapctSize= c;
        this.handyCapSize= h;
        carlist = new Car[f+c+h];
    }

    public int getFirstNull(){
        for(int i = 0; i < fullSize+comapctSize+handyCapSize;i++){
            if(carlist[i] == null)
                return i;
        }

        return 0;
    }

    public int getTS(){

        return (int)System.currentTimeMillis()%1000;
    }

    public Receipt checkin(Car car, boolean handicapPermit) {
        Receipt r;
        if (handicapPermit) {
            if (this.curHandy < handyCapSize) {
                curHandy++;
                int k = getFirstNull();
                r = new Receipt(k, 2, getTS());
                carlist[k] = car;
                return r;
            }
        }
        switch(car.type){
            case COMPACT:
                if (comapctSize > curComp) {
                    curComp++;
                    int k = getFirstNull();
                    r = new Receipt(k, 1, getTS());
                    carlist[k] = car;
                    return r;
                }
                break;
            case FULL_SIZE:
                if (fullSize > curFull) {
                    curFull++;
                    int k = getFirstNull();
                    r = new Receipt(k, 0, getTS());
                    carlist[k] = car;
                    return r;
                }
                break;
        }




        return null;

    }


    public Car checkout(Receipt receipt) {
        if(receipt.id < 0 && receipt.id >= fullSize+comapctSize+handyCapSize )
            return null;

        switch (receipt.slotType){
            case 0:
                curFull--;
                break;
            case 1:
                curComp--;
                break;
            case 2:
                curHandy--;
            default:
                return null;
        }

        Car c = carlist[receipt.id];
        carlist[receipt.id] = null;

        return c;

    }

    public static void main(String args[]){
        ParkingLot p = new ParkingLot(10,20,30);
        Car car = new Car("A1234",Car.CarType.FULL_SIZE);
        Car car2 = new Car("A12e34",Car.CarType.COMPACT);
        Car car3= new Car("A123r4r",Car.CarType.FULL_SIZE);
        Car car4 = new Car("A12t34",Car.CarType.COMPACT);
        Car car5 = new Car("A12tg34",Car.CarType.FULL_SIZE);

        Receipt r = p.checkin(car,true);
        System.out.println(r.id);
        System.out.println("ftasf");
        System.out.println(p.carlist[0].registration);
//        Car c1 = p.checkout(r);
//        System.out.println(c1.registration);


    }


}
