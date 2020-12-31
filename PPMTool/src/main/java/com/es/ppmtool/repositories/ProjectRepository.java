package com.es.ppmtool.repositories;


import com.es.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);

    Project findByProjectIdentifier(String projectId);
    //uses build in findBy class.


}
