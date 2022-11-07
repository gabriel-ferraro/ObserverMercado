package domain;

public class Product {
	
	public String name;
	public float value;
	
	public Product(String nome, float value){
		this.name = nome;
		this.value = value;
	}
	
	public String toString() {
		return this.name;
	}
}
