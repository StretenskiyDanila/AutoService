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
import ru.stretenskiy.autoservice.entities.Work;
import ru.stretenskiy.autoservice.repositories.WorkRepository;
import ru.stretenskiy.autoservice.services.WorkService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;

    @Override
    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    @Override
    @Transactional
    public Long saveWork(@NotNull Work work) {
        log.info("Saving new {}", work);
        return workRepository.save(work).getId();
    }

    @Override
    @Transactional
    public void deleteWork(@NotNull Work work) {
        log.info("Delete {}", work);
        workRepository.delete(work);
    }

    @Override
    public Optional<Work> getWorkById(@NotNull Long id) {
        return workRepository.findById(id);
    }

    @Override
    public ByteArrayResource generateReport() {
        List<Work> works = workRepository.findAll();
        try (Workbook wb = new SXSSFWorkbook(); ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {
            int rowCount = 0;
            final String[] headers = {"№", "Date work", "Master_id", "Car_id", "Service_id"};
            SXSSFSheet sheet = (SXSSFSheet) wb.createSheet("works");
            Row row = sheet.createRow(rowCount++);
            for (int i = 0; i < headers.length; i++) {
                row.createCell(i).setCellValue(headers[i]);
            }

            for (Work work : works) {
                Row carRow = sheet.createRow((rowCount++));
                carRow.createCell(0).setCellValue(work.getId());
                carRow.createCell(1).setCellValue(work.getDateWork());
                carRow.createCell(2).setCellValue(work.getMaster().getId());
                carRow.createCell(3).setCellValue(work.getCar().getId());
                carRow.createCell(4).setCellValue(work.getServicing().getId());
            }
            wb.write(arrayOutputStream);
            return new ByteArrayResource(arrayOutputStream.toByteArray());
        } catch (IOException e) {
            return null;
        }
    }

}
