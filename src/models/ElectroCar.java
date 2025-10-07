package models;

public class ElectroCar extends Car{
    int batteryCapacity;
    boolean move;
    public ElectroCar (Integer id, int years, int horsePower, String brand, int batteryCapacity,boolean move, int index) {
        super (id, years, horsePower, brand, move, index);
        this.batteryCapacity = batteryCapacity;
        this.move = move;

    }

    @Override
    public void drive() {
        System.out.println(brand + " рычит");
    }

    public void charge(){
        System.out.println(brand + " заряжена на: " + batteryCapacity + "%");
    }

    public void stop() {
        System.out.println(brand + " остановился");
    }

}
