package br.ba.swaglabs_anacarolina.core;

import static br.ba.swaglabs_anacarolina.core.DriverFactory.getDriver; //importa o método que cria uma instância do driver na classe DriverFactory

import org.openqa.selenium.By;
	
	public class BasePage {
		
		public String texto;
		
		/* Cria a DSL (domain specific language) para facilidade e reuso dos métodos de interação com os WebElements.
			Quando um outro método precisar realizar a mesma ação, deve invocá-lo ao invés de duplicar o código. */
		
		//Método para encontrar um campo e preenchê-lo (limpando antes do preenchimento com .clear() e enviando com .sendKeys()).
		
		public void preencherCampoById(String id_campo, String texto){
			getDriver().findElement(By.id(id_campo)).clear();
			getDriver().findElement(By.id(id_campo)).sendKeys(texto);
		} 
		
		public void clicarBotaoPorId(String id) {
			getDriver().findElement(By.id(id)).click();
		}
		
		public String obterUrlAtual() {
			String url = getDriver().getCurrentUrl();
			return url;
		}
		
		public String obterTextoByXpath(String xpath) {
			String texto = getDriver().findElement(By.xpath(xpath)).getText();
			return texto;
		}

}
