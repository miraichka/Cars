package models;

public class ESedan extends ElectroCar{
    boolean move;
    public ESedan ( Integer id, int years, int horsePower, String brand, int batteryCapacity,boolean move, int index) {
        super (id, years, horsePower, brand,batteryCapacity, move, index);

    }
}
