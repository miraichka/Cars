package models;

public class Truck extends Car{
    private int loadCapacity;
    boolean move;
    public Truck (Integer id, int years, int horsePower, String brand, int loadCapacity, boolean move, int index){

        super( id, years, horsePower, brand,move, index);
        this.loadCapacity = loadCapacity;
        this.move = move;
    }

    public void setloadCapacity(){
        this.loadCapacity = loadCapacity;
    }

    public void getloadCapacity() {
        System.out.println(loadCapacity);
    }

    @Override
    public void drive() {
      System.out.println( brand +  " летит");
    }

    public void stop() {
        System.out.println(brand + " остановился");
    }

}
