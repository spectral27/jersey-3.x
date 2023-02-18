package spc;

import jakarta.persistence.EntityManager;

import java.util.List;

public class RecordRepository {

    public List<Record> selectAllRecords() {
        EntityManager entityManager = Main.createEntityManager();

        List<Record> records = entityManager.createQuery("select r from Record r", Record.class)
                .getResultList();

        entityManager.close();

        return records;
    }

}
