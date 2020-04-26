package com.nahed.conferencedemo.repositories;

import com.nahed.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long>{

}

