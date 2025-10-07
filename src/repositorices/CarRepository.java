package repositorices;

import models.Car;
import java.util.*;

public class CarRepository implements Repository<Car, Integer> {
    private List<Car> cars = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Car save(Car car) {
        if (car == null) {
            System.out.println("Ошибка: нельзя сохранить null");
            return null;
        }

        if (car.getId() == null) {

            car.setId(nextId);
            cars.add(car);
            System.out.println("Сохранили машину: " + car.brand + " (ID: " + nextId + ")");
            nextId++;
        } else {

            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getId().equals(car.getId())) {
                    cars.set(i, car);
                    System.out.println("Обновили машину: " + car.brand + " (ID: " + car.getId() + ")");
                    return car;
                }
            }

            cars.add(car);
            System.out.println("Добавили машину: " + car.brand + " (ID: " + car.getId() + ")");
        }

        return car;
    }

    @Override
    public List<Car> saveAll(Collection<Car> entities) {
        List<Car> savedCars = new ArrayList<>();
        System.out.println("Сохраняем коллекцию машин...");

        for (Car car : entities) {
            Car savedCar = save(car);
            if (savedCar != null) {
                savedCars.add(savedCar);
            }
        }

        System.out.println("Сохранено машин: " + savedCars.size());
        return savedCars;
    }

    @Override
    public Optional<Car> findById(Integer id) {
        if (id == null) {
            System.out.println("ID не может быть null");
            return Optional.empty();
        }


        for (Car car : cars) {
            if (car.getId().equals(id)) {
                System.out.println("Нашли машину с ID " + id + ": " + car.brand);
                return Optional.of(car);
            }
        }

        System.out.println("Не нашли машину с ID " + id);
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            System.out.println("ID не может быть null");
            return;
        }


        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)) {
                Car removedCar = cars.remove(i);
                System.out.println("Удалили машину с ID " + id + ": " + removedCar.brand);
                return;
            }
        }

        System.out.println("Машина с ID " + id + " не найдена");
    }

    @Override
    public void deleteAll() {
        int carCount = cars.size();
        cars.clear();
        nextId = 1;
        System.out.println("Удалили ВСЕ машины. Было удалено: " + carCount + " машин");
    }

    @Override
    public long count() {
        long carCount = cars.size();
        System.out.println("Всего машин в репозитории: " + carCount);
        return carCount;
    }

    @Override
    public boolean existsById(Integer id) {
        if (id == null) {
            return false;
        }


        for (Car car : cars) {
            if (car.getId().equals(id)) {
                System.out.println("Машина с ID " + id + " существует: true");
                return true;
            }
        }

        System.out.println("Машина с ID " + id + " существует: false");
        return false;
    }
}