package br.ba.swaglabs_anacarolina.pages;

import br.ba.swaglabs_anacarolina.core.BasePage;
import br.ba.swaglabs_anacarolina.core.DriverFactory;

public class LoginPage extends BasePage{
	
	public void irParaTeladeLogin(String url) {
		DriverFactory.getDriver().get(url);
	}
	
	 public void preencherCampoUsername(String id, String username) {
		preencherCampoById(id, username);
	} 
	 
	 public void preencherCampoSenha(String id, String senha) {
			preencherCampoById(id, senha);
		} 
	 
	 public void clicarBotaoLogin(String id) {
		 	clicarBotaoPorId(id);
	 }
	 
	 public String obterMensagemErro(String xpath) {
		 texto = obterTextoByXpath(xpath);
		 return texto;
	 }
	 
}