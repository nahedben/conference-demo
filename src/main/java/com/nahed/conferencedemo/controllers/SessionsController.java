package com.nahed.conferencedemo.controllers;


import com.nahed.conferencedemo.models.Session;
import com.nahed.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> listAll(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.findById(id).get();
    }


    @PostMapping
    @RequestMapping("/session")
    public Session create(@RequestBody Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public void delete(@PathVariable Long id){
        // also we need to check the children records before deleting
        sessionRepository.deleteById(id);
    }
    @PutMapping
    @RequestMapping("/{id}")
    public Session update( @RequestBody Session session, @PathVariable Long id){
        Session existingSession = sessionRepository.findById(id).get();
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
