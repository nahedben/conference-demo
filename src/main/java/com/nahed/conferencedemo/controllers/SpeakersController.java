package com.nahed.conferencedemo.controllers;


import com.nahed.conferencedemo.models.Session;
import com.nahed.conferencedemo.models.Speaker;
import com.nahed.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> listAll(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }


    @PostMapping
    @RequestMapping("/speaker")
    public Speaker create(@RequestBody Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }
    @DeleteMapping
   @RequestMapping("/{id}")
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
   }

   @PutMapping
    @RequestMapping("/{id}")
    public Speaker update(@RequestBody Speaker speaker, @PathVariable Long id){
        Speaker existSpeaker =speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existSpeaker);
    }


}
