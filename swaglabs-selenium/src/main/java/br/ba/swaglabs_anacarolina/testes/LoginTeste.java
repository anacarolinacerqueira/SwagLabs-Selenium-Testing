package br.ba.swaglabs_anacarolina.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ba.swaglabs_anacarolina.core.BaseTeste;
import br.ba.swaglabs_anacarolina.pages.LoginPage;


public class LoginTeste extends BaseTeste {
	
	LoginPage loginPage = new LoginPage();
	
	@Before
	public void inicializa() {
		loginPage.irParaTeladeLogin("https://www.saucedemo.com/");
	}
	
	@Test
	public void fazerLoginCorretamente() {
		loginPage.preencherCampoUsername("user-name", "standard_user");
		loginPage.preencherCampoSenha("password", "secret_sauce");
		loginPage.clicarBotaoLogin("login-button");
		
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.obterUrlAtual());
	}
	
	@Test
	public void fazerLoginComSenhaIncorreta() {
		loginPage.preencherCampoUsername("user-name", "standard_user");
		loginPage.preencherCampoSenha("password", "Wrong_pass");
		loginPage.clicarBotaoLogin("login-button");
		
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", 
				loginPage.obterTextoByXpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/form/div[3]/h3")); 
	}
	
	//Refatorar xPath para o WebElement que exibe mensagens de erro.
	
	@Test
	public void fazerLoginComUsuarioIncorreto() {
		loginPage.preencherCampoUsername("user-name", "incorrect_user");
		loginPage.preencherCampoSenha("password", "secret_sauce");
		loginPage.clicarBotaoLogin("login-button");
		
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", 
				loginPage.obterTextoByXpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/form/div[3]/h3")); 
	}
	
	@Test
	public void fazerLoginCampoSenhaVazio() {
		loginPage.preencherCampoUsername("user-name", "standard_user");
		loginPage.preencherCampoSenha("password", "");
		loginPage.clicarBotaoLogin("login-button");
		
		Assert.assertEquals("Epic sadface: Password is required", 
				loginPage.obterTextoByXpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/form/div[3]/h3")); 
	}
	
	@Test
	public void fazerLoginCampoUsernameVazio() {
		loginPage.preencherCampoUsername("user-name", "");
		loginPage.preencherCampoSenha("password", "secret_sauce");
		loginPage.clicarBotaoLogin("login-button");
		
		Assert.assertEquals("Epic sadface: Username is required", 
				loginPage.obterTextoByXpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/form/div[3]/h3")); 
	}
}
