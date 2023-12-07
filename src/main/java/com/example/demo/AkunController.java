package com.example.demo;

import java.util.List;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regjpa")
public class AkunController {
	@Autowired
	public AkunRepo akunRepo;
	   
	
	
	@PostMapping("/pos")
	public Akun  posAkun(@RequestBody Akun akun){
    	return akunRepo.save(akun);	
	}
	@GetMapping("/dapat")
	public List<Akun>  dapatAkun(){
    	return akunRepo.findAll();	
	}
	//@SuppressWarnings("deprecation")
	@GetMapping("/dpt")
	//@Query("select * from akun where email= :email and katasandi= :katasandi")
	public  List<Akun>  dapatDImana(@RequestParam(required=false, name="email")String email,@RequestParam(required=false, name="katasandi")String katasandi){
		System.out.println(email);
    	return akunRepo.findByLogin(email, katasandi);
    			//.orElseThrow(() -> new ResourceNotFoundException("Comment", "id", email));
       			//akunRepo.getReferenceById(email);	
	}
}
