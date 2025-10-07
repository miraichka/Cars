package models;
public class ETruck extends ElectroCar{

    boolean move;
    public ETruck (Integer id, int years, int horsePower, String brand, int batteryCapacity,boolean move, int index) {
        super(id, years, horsePower, brand, batteryCapacity, move, index);
    }
}
