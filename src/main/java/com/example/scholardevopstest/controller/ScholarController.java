package com.example.scholardevopstest.controller;

import com.example.scholardevopstest.dtos.ScholarRequest;
import com.example.scholardevopstest.entities.Scholar;
import com.example.scholardevopstest.service.ScholarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scholar")
public class ScholarController {
    @Autowired
    ScholarService scholarService;
    @PostMapping("")
    public void saveScholar(@RequestBody ScholarRequest scholarRequest)  {
        //Adding scholar entry
        scholarService.create(scholarRequest);
    }
    @GetMapping("")
    public List<Scholar> findScholar()  {
        return  scholarService.findAllScholars() ;
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/scholar/{id}")
    public void deleteScholar(@PathVariable String id){
        scholarService.deleteScholar(id);
    }
    @GetMapping("/scholar/{id}")
    public Optional<Scholar> findScholarById(@PathVariable String id)  {
        return  scholarService.findScholarById(id) ;
    }

}
