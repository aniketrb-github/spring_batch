package com.techprimers.springbatchexample1.repository;

import com.techprimers.springbatchexample1.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Here again u need to provide that class into which u need to persist ur data
 * for ex. User.java is a class written in Connect Server Side
 * UserDTO.java is a class written on JobManger Bridge side so as to map the Connect V4 API data & save it in our side
 * 
 * therefore we provided UserDto as class & Integer is nothin but the Primary key of that class
 * 
 * so here we need to identify what will be our primary key when we provide it in JobRepo
 * 
 * @author abharsa
 *
 */
public interface UserReSTRepository extends JpaRepository<UserDTO, Integer> {
}
