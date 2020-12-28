package com.es.ppmtool.services;


import com.es.ppmtool.domain.Project;
import com.es.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository ;

    public Project saveOrUpdateProject (Project project){

        // A lot of logic here ..


        return projectRepository.save(project);
    }
}
