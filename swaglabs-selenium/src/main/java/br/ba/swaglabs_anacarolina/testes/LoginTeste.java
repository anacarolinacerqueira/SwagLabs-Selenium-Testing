package br.ba.swaglabs_anacarolina.testes;

import org.junit.Test;

import br.ba.swaglabs_anacarolina.core.BaseTeste;
import br.ba.swaglabs_anacarolina.core.Propriedades;
import br.ba.swaglabs_anacarolina.pages.LoginPage;



public class LoginTeste extends BaseTeste {
	
	LoginPage loginPage = new LoginPage();
	
	@Test
	public void fazerLoginCorretamente() {
		loginPage.irParaTeladeLogin("https://www.saucedemo.com/");
		loginPage.preencherCampoUsername("user-name", "standard_user");
		loginPage.preencherCampoSenha("password", "secret_sauce");
		loginPage.clicarBotaoLogin("login-button");
		
	}
	
}
