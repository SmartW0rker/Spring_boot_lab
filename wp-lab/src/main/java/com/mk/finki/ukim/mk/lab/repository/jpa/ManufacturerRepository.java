package com.mk.finki.ukim.mk.lab.repository.jpa;

import com.mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
    @Override
    List<Manufacturer> findAll();
}
