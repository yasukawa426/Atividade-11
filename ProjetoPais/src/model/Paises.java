package model;



public class Paises {
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	
	//construtores
	public Paises() {
		
	}
	public Paises(String nome, long populacao, double area) {
		this.nome=nome;
		this.populacao=populacao;
		this.area=area;
	}
	public Paises(int id, String nome, long populacao, double area) {
		this.id=id;
		this.nome=nome;
		this.populacao=populacao;
		this.area=area;
	}
	//gets  sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Paises [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", area=" + area + "]";
	}
	
	
	
}

