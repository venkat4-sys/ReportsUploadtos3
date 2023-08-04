package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Citizen;

public interface CitizenRepos extends JpaRepository<Citizen,Integer>{

}
