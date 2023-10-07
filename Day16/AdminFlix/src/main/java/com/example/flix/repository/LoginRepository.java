package com.example.flix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.flix.model.Login;

import java.util.Optional;


@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	@Query("select count(d) from Login d where d.name = ?1")
	public List<Integer> usernameExists(String name);
	
	@Query("select password from Login d where d.email = ?1")
	public String passwordExists(String password);
 
    @Query(value = "SELECT * FROM users u WHERE u.email=? AND u.password=?",nativeQuery=true)//SELECT * FROM USERS u WHERE u.status = 1
    public Login verifyUser(String email,String password);

    Optional<Login> findByEmail(String name);

    Login findByUid(Long uid);

    void deleteByUid(Long uid);

}
