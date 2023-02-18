package spc;

import jakarta.persistence.EntityManager;

import java.util.List;

public class SectorRepository {

    public List<Sector> selectAllSectors() {
        EntityManager entityManager = Main.createEntityManager();

        List<Sector> sectors = entityManager.createQuery("select s from Sector s", Sector.class)
                .getResultList();

        entityManager.close();

        return sectors;
    }

}
