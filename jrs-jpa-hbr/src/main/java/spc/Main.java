package spc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main-unit");

    public static void main(String[] args) {
        SectorRepository sectorRepository = new SectorRepository();

        List<Sector> sectors = sectorRepository.selectAllSectors();

        for (int i = 0; i < sectors.size(); i++) {
            System.out.println(sectors.get(i));
        }

        RecordRepository recordRepository = new RecordRepository();

        List<Record> records = recordRepository.selectAllRecords();

        for (int i = 0; i < records.size(); i++) {
            System.out.println(records.get(i));
        }
    }

    public static EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
