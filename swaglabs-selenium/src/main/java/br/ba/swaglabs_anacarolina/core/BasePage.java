package br.ba.swaglabs_anacarolina.core;

import static br.ba.swaglabs_anacarolina.core.DriverFactory.getDriver; //importa o método que cria uma instância do driver na classe DriverFactory

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class BasePage {
		
		public String texto;
		
		/* Cria a DSL (domain specific language) para facilidade e reuso dos métodos de interação com os WebElements.
			Quando um outro método precisar realizar a mesma ação, deve invocá-lo ao invés de duplicar o código. */
		
		//Método para encontrar um campo e preenchê-lo (limpando antes do preenchimento com .clear() e enviando com .sendKeys()).
		
		public void preencherCampoById(String id_campo, String texto){
			getDriver().findElement(By.id(id_campo)).clear();
			getDriver().findElement(By.id(id_campo)).sendKeys(texto);
		} 
		
		public void clicarItemPorId(String id) {
			getDriver().findElement(By.id(id)).click();
		}
		
		public void clicarItemPorClasse(String classe) {
			getDriver().findElement(By.className(classe)).click();
		}
		
		public void espera(int segundos) {
			getDriver().manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
		}
		
		public String obterUrlAtual() {
			String url = getDriver().getCurrentUrl();
			return url;
		}
		
		public String obterTextoByXpath(String xpath) {
			String texto = getDriver().findElement(By.xpath(xpath)).getText();
			return texto;
		}
		
		public String obterTextoById(String id) {
			String texto = getDriver().findElement(By.id(id)).getText();
			return texto;
		}
		
		public String obterTextoByClasse(String classe) {
			String texto = getDriver().findElement(By.className(classe)).getText();
			return texto;
		}
		
		public void selecionarItemSelect(String classe, String valor) {
			WebElement element = getDriver().findElement(By.className(classe));
			Select select = new Select(element);
			select.selectByVisibleText(valor);
		}
		
		public boolean checarItemVisivelPorId(String id) {
			boolean visivel = getDriver().findElement(By.id(id)).isDisplayed();
			return visivel;
		}
		
}
