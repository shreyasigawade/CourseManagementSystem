package com.example.cmsspringbootrestjpamavenproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.cmsspringbootrestjpamavenproject.dao.entity.InstructorEntity;

@Repository
public interface InstructorDao extends JpaRepository<InstructorEntity, Integer> {

}
