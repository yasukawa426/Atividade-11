package model;

public class Usuario {
	private int id;
	private String fone;
	private String email;
	private String nome;
	private String password;
	
	public Usuario () {
		
	}
	
	public Usuario(String nome, String password) {
		this.password=password;
		this.nome=nome;
		
	}
	public Usuario(String fone, String email, String nome, String password) {
		this.fone=fone;
		this.email=email;
		this.nome=nome;
		this.password=password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id= "+ id + "fone=" + fone + ", email=" + email + ", nome=" + nome + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
