package Config.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

  
@Entity  
@Table(name="cadastro")  
public class Cadastro implements Serializable {

	private static final long serialVersionUID = 3862024889868951158L; 
	
	@Id
    private Long cpf; 
    private String name;  
    private String email;  
    private String job;
   
    
    public Cadastro() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}
    
}  