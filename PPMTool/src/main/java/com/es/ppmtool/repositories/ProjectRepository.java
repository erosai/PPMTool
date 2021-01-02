package com.es.ppmtool.repositories;


import com.es.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
    //returns a list of projects.
    //The Java Iterable interface represents a collection of objects which is iterable - meaning
    // which can be iterated. This means, that a class that implements the Java Iterable interface
    // can have its elements iterated.


    Project findByProjectIdentifier(String projectId);
    //uses build in findBy class.


}
