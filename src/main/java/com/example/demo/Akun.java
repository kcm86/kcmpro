package com.example.demo;
      
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;
//JPA: Java rasa Javascript
@Entity
@Table
public class Akun {
	@Id
	public String email;
	@NonNull
    public String namapengguna;
	@NonNull
    public String katasandi;
    	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNamapengguna() {
		return namapengguna;
	}
	public void setNamapengguna(String namapengguna) {
		this.namapengguna = namapengguna;
	}
	public String getKatasandi() {
		return katasandi;
	}
	public void setKatasandi(String katasandi) {
		this.katasandi = katasandi;
	}
 
    
}
