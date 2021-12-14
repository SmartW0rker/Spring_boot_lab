package com.mk.finki.ukim.mk.lab.service.impl;

import com.mk.finki.ukim.mk.lab.exceptions.BalloonNotFoundExeption;
import com.mk.finki.ukim.mk.lab.exceptions.ManufacturerNotFound;
import com.mk.finki.ukim.mk.lab.model.Balloon;
import com.mk.finki.ukim.mk.lab.model.Manufacturer;
import com.mk.finki.ukim.mk.lab.repository.jpa.BalloonRepository;
import com.mk.finki.ukim.mk.lab.repository.jpa.ManufacturerRepository;
import com.mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class BaloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BaloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findBalloonByNameOrDescriptionLike(text,text);
    }

    @Override
    public void save(Balloon balloon) {
        balloonRepository.delete(balloon);
        balloonRepository.save(balloon);
    }

    @Override
    public void deleteById(Long id) { balloonRepository.deleteById(id);
    }
    @Override
    @Transactional
    public void edit(Long id, String name, String description, Long manufacturerId){
        Balloon balloon=balloonRepository.findById(id).orElseThrow(()->new BalloonNotFoundExeption(id));
        Manufacturer manufacturerObject=manufacturerRepository.findAll()
                .stream().filter(m->m.getId().equals(manufacturerId))
                .findFirst().orElseThrow(()->new ManufacturerNotFound(id));
        balloon.setName(name);
        balloon.setDescription(description);
        balloon.setManufacturer(manufacturerObject);
    }


}
