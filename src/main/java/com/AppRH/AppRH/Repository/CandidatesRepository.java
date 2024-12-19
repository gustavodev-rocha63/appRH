package com.AppRH.AppRH.Repository;

import com.AppRH.AppRH.Model.Candidates;
import com.AppRH.AppRH.Model.Vacancy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CandidatesRepository extends CrudRepository<Candidates,String> {
    Iterable<Candidates>findByVacancy(Vacancy vacancy);
    Candidates findByRg(String rg);
    Candidates findById(long id);
    List<Candidates>findByNameCandidate(String nameCandidate);
}
