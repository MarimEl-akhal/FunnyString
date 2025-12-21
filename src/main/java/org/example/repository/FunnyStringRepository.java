package org.example.repository;

import org.example.entity.FunnyStringEntity;

import org.springframework.data.jpa.repository.JpaRepository;



public interface FunnyStringRepository extends JpaRepository<FunnyStringEntity,Integer> {


}
