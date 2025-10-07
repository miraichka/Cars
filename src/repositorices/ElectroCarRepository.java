package repositorices;

import models.ElectroCar;
import java.util.*;

public class ElectroCarRepository implements Repository<ElectroCar, Integer> {
    private List<ElectroCar> electroCars = new ArrayList<>();
    private int nextId = 1;

    @Override
    public ElectroCar save(ElectroCar electroCar) {
        if (electroCar == null) {
            System.out.println("Ошибка: нельзя сохранить null");
            return null;
        }

        if (electroCar.getId() == null) {
            electroCar.setId(nextId);
            electroCars.add(electroCar);
            System.out.println("⚡ Сохранили электромобиль: " + electroCar.brand + " (ID: " + nextId + ")");
            nextId++;
        } else {
            for (int i = 0; i < electroCars.size(); i++) {
                if (electroCars.get(i).getId().equals(electroCar.getId())) {
                    electroCars.set(i, electroCar);
                    System.out.println("⚡ Обновили электромобиль: " + electroCar.brand + " (ID: " + electroCar.getId() + ")");
                    return electroCar;
                }
            }
            electroCars.add(electroCar);
            System.out.println("⚡ Добавили электромобиль: " + electroCar.brand + " (ID: " + electroCar.getId() + ")");
        }
        return electroCar;
    }

    @Override
    public List<ElectroCar> saveAll(Collection<ElectroCar> entities) {
        List<ElectroCar> savedCars = new ArrayList<>();
        System.out.println("Сохраняем коллекцию электромобилей...");

        for (ElectroCar electroCar : entities) {
            ElectroCar savedCar = save(electroCar);
            if (savedCar != null) {
                savedCars.add(savedCar);
            }
        }

        System.out.println("⚡ Сохранено электромобилей: " + savedCars.size());
        return savedCars;
    }

    @Override
    public Optional<ElectroCar> findById(Integer id) {
        if (id == null) {
            System.out.println("ID не может быть null");
            return Optional.empty();
        }

        for (ElectroCar electroCar : electroCars) {
            if (electroCar.getId().equals(id)) {
                System.out.println("Нашли электромобиль с ID " + id + ": " + electroCar.brand);
                return Optional.of(electroCar);
            }
        }

        System.out.println("Не нашли электромобиль с ID " + id);
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            System.out.println("ID не может быть null");
            return;
        }

        for (int i = 0; i < electroCars.size(); i++) {
            if (electroCars.get(i).getId().equals(id)) {
                ElectroCar removedCar = electroCars.remove(i);
                System.out.println("Удалили электромобиль с ID " + id + ": " + removedCar.brand);
                return;
            }
        }

        System.out.println("Электромобиль с ID " + id + " не найден");
    }

    @Override
    public void deleteAll() {
        int carCount = electroCars.size();
        electroCars.clear();
        nextId = 1;
        System.out.println("Удалили ВСЕ электромобили. Было удалено: " + carCount + " машин");
    }

    @Override
    public long count() {
        long carCount = electroCars.size();
        System.out.println("Всего электромобилей в репозитории: " + carCount);
        return carCount;
    }

    @Override
    public boolean existsById(Integer id) {
        if (id == null) {
            return false;
        }

        for (ElectroCar electroCar : electroCars) {
            if (electroCar.getId().equals(id)) {
                System.out.println("Электромобиль с ID " + id + " существует: true");
                return true;
            }
        }

        System.out.println("Электромобиль с ID " + id + " существует: false");
        return false;
    }
}