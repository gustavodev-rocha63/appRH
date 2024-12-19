package com.AppRH.AppRH.Repository;

import com.AppRH.AppRH.Model.Vacancy;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface VacancyRepository extends CrudRepository<Vacancy,String>{
    Vacancy findByCodigo(long codigo);
    List<Vacancy> findByName(String name);
}
