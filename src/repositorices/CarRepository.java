package repositorices;

import models.Car;

import java.util.*;

public class CarRepository implements Repository<Car,Integer>{
    private Map<Integer, Car> cars = new HashMap<>();
    private static int Id = 0;

    @Override
    public Car save(Car car) {
        if (car == null){
            System.out.println("Ошибка, машина = NULL!");
            return null;
        }
        cars.put(Id, car);
        System.out.println("Сохранили машину с ID: " + Id + ": " + car.brand);
        Id++;
        return car;
    }

    @Override
    public List<Car> saveAll(Collection entities) {
        return List.of();
    }

    @Override
    public Optional<Car> findById(Integer id) {
        if (cars.get(id) != null){
            System.out.println("Нашли машину ID " + id + ": " + cars.get(id).brand);
        }
        else{
            System.out.println("Такой машины не найдено");
        }
        return Optional.ofNullable(cars.get(id));
    }

    @Override
    public void deleteById(Integer integer) {

    }



    @Override
    public void deleteAll() {
        if (cars.size() > 0){
            cars.clear();
            System.out.println("Удалены все машины");
        }
        else{
            System.out.println("Список машин пуст");
        }
    }

    @Override
    public long count() {
        return cars.size();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }


}