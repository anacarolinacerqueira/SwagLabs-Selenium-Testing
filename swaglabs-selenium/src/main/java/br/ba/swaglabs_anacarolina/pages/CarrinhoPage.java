package br.ba.swaglabs_anacarolina.pages;
import static br.ba.swaglabs_anacarolina.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ba.swaglabs_anacarolina.core.BasePage;

public class CarrinhoPage extends BasePage {
	
	
	public void clicarCarrinho(String classe){
		clicarItemPorClasse(classe);
	}
	
	public String obterValordaCompra(String classe) {
		String texto = obterTextoByClasse(classe);
		return texto;
	}
	
	public void clicarCheckout(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean checarFormularioVisivel(String id) {
		boolean visivel = checarItemVisivelPorId(id);
		return visivel;
	}
	
	/* public void esperarCarregamento(int segundos) {
		espera(segundos);
	} */

}
