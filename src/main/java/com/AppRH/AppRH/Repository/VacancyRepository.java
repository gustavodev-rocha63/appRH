package com.AppRH.AppRH.Repository;

import com.AppRH.AppRH.Model.Vacancy;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface VacancyRepository extends CrudRepository<Vacancy,String>{
    Vacancy findByCodigo(long codigo);
    List<Vacancy> findByName(String name);
}
