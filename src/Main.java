import models.ElectroCar;
import models.Sedan;
import models.Truck;
import repositorices.CarRepository;

public class Main {


    public static void main(String[] args) {
        Sedan sedan0 = new Sedan(null, 2015, 4, 160, "Toyota", true, 9);
        Sedan sedan1 = new Sedan(null, 2022, 2, 600, "Alfa Romeo", true, 7);
        Sedan sedan2 = new Sedan(null, 1999, 2, 503, "Porshe", true, 8);
        Sedan[] sedan = new Sedan[]{sedan0, sedan1, sedan2};
        Truck truck0 = new Truck(null, 2015, 200, "Mersedes", 5, true, 7);
        Truck truck1 = new Truck(null, 2020, 300, "Volvo", 7, true, 5);
        Truck truck2 = new Truck(null, 2023, 180, "Man", 3, true, 5);
        Truck[] truck = new Truck[]{truck0, truck1, truck2};
        ElectroCar electroCar0 = new ElectroCar(null, 2025, 200, "Tesla", 90, true, 6);
        ElectroCar electroCar1 = new ElectroCar(null, 2023, 400, "Audi", 90, true, 7
        );
        ElectroCar electroCar2 = new ElectroCar(null, 2024, 500, "BMW", 89, true, 7);
        ElectroCar[] electroCar = new ElectroCar[]{electroCar0, electroCar1, electroCar2};

        System.out.println("==========================");
        for (int i = 0; i < sedan.length; i++) {
            sedan[i].drive();
            sedan[i].stop();

            System.out.println("==========================");
        }


        for (int j = 0; j < truck.length; j++) {
            truck[j].drive();

        }

        for (int i = 0; i < electroCar.length; i++) {
            electroCar[i].drive();
            electroCar[i].charge();
        }

        System.out.println("-----------------------------");

        CarRepository rep = new CarRepository();
        rep.save(sedan0);
        System.out.println(rep.count());



    }

}