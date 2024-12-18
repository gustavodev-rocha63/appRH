package com.AppRH.AppRH.Repository;

import com.AppRH.AppRH.Model.Candidates;
import com.AppRH.AppRH.Model.Vacancy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidatesRepository extends CrudRepository<Candidates,String> {
    Iterable<Candidates>findByVacancy(Vacancy vacancy);
    Candidates findByRg(String rg);
    Candidates findById(long id);
    List<Candidates>findByNameCandidates(String nameCandidate);
}
