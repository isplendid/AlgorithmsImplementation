package com.xu.interview.multithread.thread.reference;

import java.lang.ref.WeakReference;

/**
 * Created by sop on 2020/09/2020/9/2 10:30
 *
 * @Description:
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {

        Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);
        int i=0;
        while(true){
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }

//            System.out.println("system gc!");
//            System.gc();
        }
    }
}
