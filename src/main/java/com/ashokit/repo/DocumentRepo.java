package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Document;

public interface DocumentRepo extends JpaRepository<Document,Integer>{

}
