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
import ru.stretenskiy.autoservice.entities.Master;
import ru.stretenskiy.autoservice.repositories.MasterRepository;
import ru.stretenskiy.autoservice.services.MasterService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MasterServiceImpl implements MasterService {

    private final MasterRepository masterRepository;

    @Override
    public List<Master> getAllMasters() {
        return masterRepository.findAll();
    }

    @Override
    public List<Long> getBestMasters(Date withDate, Date beforeDate) {
        return masterRepository.getBestMasters(withDate, beforeDate);
    }

    @Override
    @Transactional
    public Long saveMaster(@NotNull Master master) {
        log.info("Saving new {}", master);
        return masterRepository.save(master).getId();
    }

    @Override
    @Transactional
    public void deleteMaster(@NotNull Master master) {
        log.info("Delete {}", master);
        masterRepository.delete(master);
    }

    @Override
    public Optional<Master> getMasterById(@NotNull Long id) {
        return masterRepository.findById(id);
    }

    @Override
    public ByteArrayResource generateReport() {
        List<Master> masters = masterRepository.findAll();
        try (Workbook wb = new SXSSFWorkbook(); ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {
            int rowCount = 0;
            final String[] headers = {"№", "Name"};
            SXSSFSheet sheet = (SXSSFSheet) wb.createSheet("masters");
            Row row = sheet.createRow(rowCount++);
            for (int i = 0; i < headers.length; i++) {
                row.createCell(i).setCellValue(headers[i]);
            }

            for (Master master : masters) {
                Row carRow = sheet.createRow((rowCount++));
                carRow.createCell(0).setCellValue(master.getId());
                carRow.createCell(1).setCellValue(master.getName());
            }
            wb.write(arrayOutputStream);
            return new ByteArrayResource(arrayOutputStream.toByteArray());
        } catch (IOException e) {
            return null;
        }
    }

}
