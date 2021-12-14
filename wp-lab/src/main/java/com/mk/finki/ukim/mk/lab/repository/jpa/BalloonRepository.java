package com.mk.finki.ukim.mk.lab.repository.jpa;

import com.mk.finki.ukim.mk.lab.model.Balloon;
import com.mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon,Long> {
    @Override
    List<Balloon> findAll();
    List<Balloon> findBalloonByNameOrDescriptionLike(String name,
                                                     String description);

    void deleteById(Long id);
    Optional<Balloon> findById(Long id);

    //void edit(Long id, String name, String description, Manufacturer manufacturerObject);
}
