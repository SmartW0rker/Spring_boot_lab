package com.mk.finki.ukim.mk.lab.repository.impl;

import com.mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import com.mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryManufacturerRepository {
    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }

}
