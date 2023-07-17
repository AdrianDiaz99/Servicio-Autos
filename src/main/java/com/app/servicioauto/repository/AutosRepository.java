package com.app.servicioauto.repository;

import com.app.servicioauto.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutosRepository extends JpaRepository<Auto, Integer> {

    List<Auto> findByIdUsuario(Integer userId);

}
