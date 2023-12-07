package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AkunRepo extends JpaRepository<Akun, String>{
	@Query("select a from Akun a where a.email= :email and a.katasandi= :katasandi")
	List<Akun> findByLogin(@Param("email")String  email,@Param("katasandi") String katasandi);
   
	
}
