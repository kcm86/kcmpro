package com.example.demo;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.bezkoder.spring.jdbc.mysql.model.Tutorial;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/regis")
public class regisController {
	@Autowired(required=true)
	  registrasi regisRepo;
	@Autowired(required=true)
	regisInterface regisDAO;
	@PostMapping(value="/registrasi", consumes={"application/xml","application/json"})
	  public ResponseEntity<String> regiStrasi(@RequestBody model modell) {
	    try {
	    	System.out.println(modell.getEmail()+" "+modell.getUsername()+" "+modell.getPassword());
	      regisRepo.save(new model(modell.getEmail(),modell.getUsername(),modell.getPassword()));
	      return new ResponseEntity<>("was created successfully.", HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>("Gagal", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	@GetMapping(value="/masuk", consumes={"application/xml","application/json"})
	public ResponseEntity<model> logIn(@RequestBody model modelLog) {
	    model model = regisRepo.login(new model(modelLog.getEmail(),modelLog.getPassword()));
	    if (model != null) {
	      return new ResponseEntity<>(model, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	
}
