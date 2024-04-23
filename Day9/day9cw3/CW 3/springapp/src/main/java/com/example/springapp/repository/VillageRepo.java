package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Village;
import java.util.List;

@Repository
public interface VillageRepo extends JpaRepository<Village, Integer> {

    @Query("select v from Village as v where v.villageName=?1")
    Village findByName(String villageName);

    @Query("select v from Village as v where v.villageId=?1")
    Village findById(int id);

    @Query("select v from Village as v where v.villagePopulation=?1")
    List<Village> findByPopulation(int population);

}
