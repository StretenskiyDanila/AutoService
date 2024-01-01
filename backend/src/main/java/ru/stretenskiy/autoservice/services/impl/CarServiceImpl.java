package ru.stretenskiy.autoservice.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.repositories.CarRepository;
import ru.stretenskiy.autoservice.services.CarService;

import javax.validation.constraints.NotNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public Long saveCar(@NotNull Car car) {
        log.info("Saving new {}", car);
        return carRepository.save(car).getId();
    }

    @Override
    @Transactional
    public void deleteCar(@NotNull Car car) {
        log.info("Delete {}", car);
        carRepository.delete(car);
    }

    @Override
    public Optional<Car> getCarById(@NotNull Long id) {
        return carRepository.findById(id);
    }

    @Override
    public ByteArrayResource generateReport() {
        List<Car> cars = carRepository.findAll();
        try (Workbook wb = new SXSSFWorkbook(); ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {
            int rowCount = 0;
            final String[] headers = {"№", "Number", "Mark", "Color", "Is foreign"};
            SXSSFSheet sheet = (SXSSFSheet) wb.createSheet("cars");
            Row row = sheet.createRow(rowCount++);
            for (int i = 0; i < headers.length; i++) {
                row.createCell(i).setCellValue(headers[i]);
            }

            for (Car car : cars) {
                Row carRow = sheet.createRow((rowCount++));
                carRow.createCell(0).setCellValue(car.getId());
                carRow.createCell(1).setCellValue(car.getNumber());
                carRow.createCell(2).setCellValue(car.getMark());
                carRow.createCell(3).setCellValue(car.getColor());
                carRow.createCell(4).setCellValue(car.getIsForeign());
            }
            wb.write(arrayOutputStream);
            return new ByteArrayResource(arrayOutputStream.toByteArray());
        } catch (IOException e) {
            return null;
        }
    }


}
