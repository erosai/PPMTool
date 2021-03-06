package com.es.ppmtool.web;


import com.es.ppmtool.domain.Project;
import com.es.ppmtool.services.MapValidationErrorService;
import com.es.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService ;

    @Autowired
    private MapValidationErrorService mapValidationErrorService ;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project , BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        // create instance of errorMap to check if there is any error while creating new project
        if(errorMap != null) return errorMap;
        //if errorMap is not null it means there are errors so it returns the errorMap instead of creating a new project

        Project project1 = projectService.saveOrUpdateProject(project);
        //initiate project1 and call projectService.saveOrUpdateProject to save project
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
        //confirm project was created
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){

        Project project = projectService.findProjectByIdentifier(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);

    }
    @GetMapping("/all")
    public Iterable<Project> findAllProjects(){
        return projectService.findAllProjects() ;
    }
    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
        projectService.deleteProjectById(projectId);
        return new ResponseEntity<String>("Project with id ' "+projectId+" ' was deleted", HttpStatus.OK);
    }
}
