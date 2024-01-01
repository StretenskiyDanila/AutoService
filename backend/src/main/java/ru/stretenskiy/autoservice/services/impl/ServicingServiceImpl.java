package ru.stretenskiy.autoservice.services.impl;

import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.entities.Servicing;
import ru.stretenskiy.autoservice.repositories.ServicingRepository;
import ru.stretenskiy.autoservice.services.ServicingService;
import ru.stretenskiy.autoservice.utils.CostServices;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicingServiceImpl implements ServicingService {

    private final ServicingRepository servicingRepository;

    @Override
    public List<Servicing> getAllServices() {
        return servicingRepository.findAll();
    }

    @Override
    public Optional<CostServices> getSumCost(Date withDate, Date beforeDate) {
        return servicingRepository.getSumCost(withDate, beforeDate);
    }

    @Override
    @Transactional
    public Long saveServicing(@NotNull Servicing servicing) {
        log.info("Saving new {}", servicing);
        return servicingRepository.save(servicing).getId();
    }

    @Override
    @Transactional
    public void deleteServicing(@NotNull Servicing servicing) {
        log.info("Delete {}", servicing);
        servicingRepository.delete(servicing);
    }

    @Override
    public Optional<Servicing> getServicingById(@NotNull Long id) {
        return servicingRepository.findById(id);
    }

    @Override
    public ByteArrayResource generateReport() {
        List<Servicing> servicings = servicingRepository.findAll();
        try (Workbook wb = new SXSSFWorkbook(); ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {
            int rowCount = 0;
            final String[] headers = {"№", "Name", "Cost our", "Cost foreign"};
            SXSSFSheet sheet = (SXSSFSheet) wb.createSheet("services");
            Row row = sheet.createRow(rowCount++);
            for (int i = 0; i < headers.length; i++) {
                row.createCell(i).setCellValue(headers[i]);
            }

            for (Servicing servicing : servicings) {
                Row carRow = sheet.createRow((rowCount++));
                carRow.createCell(0).setCellValue(servicing.getId());
                carRow.createCell(1).setCellValue(servicing.getName());
                carRow.createCell(2).setCellValue(servicing.getCostOur().doubleValue());
                carRow.createCell(3).setCellValue(servicing.getCostForeign().doubleValue());
            }
            wb.write(arrayOutputStream);
            return new ByteArrayResource(arrayOutputStream.toByteArray());
        } catch (IOException e) {
            return null;
        }
    }


}
