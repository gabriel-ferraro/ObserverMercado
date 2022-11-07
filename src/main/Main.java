package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Product;
import publisher.MarketInventory;
import subscribers.Cashier;
import windowClients.CashierWindowClient;
import windowClients.InventoryManagerWindow;

public class Main {

	public static void main(String[] args) {
		MarketInventory estoque = new MarketInventory(); //publisher instanciado
		
		CashierWindowClient janelaCaixa = new CashierWindowClient(); //janela do caixa
		Cashier caixa = new Cashier(estoque, janelaCaixa); //subscriber caixa instanciado
		
		//"estoque" de produtos inicial do mercado
		List<Product> productList = new ArrayList<>();
		Product prod1 = new Product("coca", 5.5f);
		Product prod2 = new Product("bibs", 8.5f);
		Product prod3 = new Product("fanta", 5);
		Product prod4 = new Product("desodorante", 9.9f);
		Collections.addAll(productList, prod1, prod2, prod3, prod4);
		
		System.out.println("caixa vazio: " + caixa.getCashierProducts());
		
		estoque.setProducts(productList); //publisher estoque atualiza o estoque e notifica observer caixa
		System.out.println("estoque faz set dos produtos no estoque e notifica o caixa do novo estoque de produtos: ");
		System.out.println(caixa.getCashierProducts());

		//instancia da janela do caixa
		janelaCaixa.generateCashierWindow(caixa);
		
		//Instancia da janela de manipulacao do estoque
		InventoryManagerWindow inventory = new InventoryManagerWindow(estoque);
		inventory.generateManagerWindow();
	}
}
