package models;

public class Sedan extends Car{
    private int passCount;
    boolean move;
    public Sedan (Integer id, int year, int PassCount, int horsePower, String brand,boolean move, int index) {
        super(id, year, horsePower, brand, move, index);
        this.passCount = passCount;
        this.move = move;
    }
    public void drive () {
        System.out.println(brand + " едет");

    }

    public void stop() {
        System.out.println(brand + " остановился");
    }

}


