package br.ba.swaglabs_anacarolina.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.ba.swaglabs_anacarolina.core.BaseTeste;
import br.ba.swaglabs_anacarolina.pages.CarrinhoPage;
import br.ba.swaglabs_anacarolina.pages.LoginPage;
import br.ba.swaglabs_anacarolina.pages.ProdutosPage;


public class CarrinhoTeste extends BaseTeste {
	
	LoginPage loginPage = new LoginPage();
	CarrinhoPage carrinhoPage = new CarrinhoPage();
	ProdutosPage produtosPage = new ProdutosPage();
	
	@Before
	public void inicializa() {
		loginPage.irParaTeladeLogin("https://www.saucedemo.com/");
		loginPage.preencherCampoUsername("user-name", "standard_user");
		loginPage.preencherCampoSenha("password", "secret_sauce");
		loginPage.clicarBotaoLogin("login-button");
	}
	
	
	@Test
	public void adicionarUmItemEChecarValor() {
		produtosPage.clicarItemPorId("add-to-cart-sauce-labs-backpack");
		carrinhoPage.clicarCarrinho("shopping_cart_link");
		String valor = carrinhoPage.obterValordaCompra("inventory_item_price");
		Assert.assertEquals("$29.99", valor);
	}
	
	@Ignore
	@Test
	public void adicionarDoiItensEChecaValor() {
		produtosPage.clicarItemPorId("add-to-cart-sauce-labs-backpack");
		produtosPage.clicarItemPorId("add-to-cart-sauce-labs-bike-light");
		carrinhoPage.clicarCarrinho("shopping_cart_link");
		String valor = carrinhoPage.obterValordaCompra("inventory_item_price");
		Assert.assertEquals("$29.99", valor);
	}
	
	@Test
	public void removerItemPelaTelaDeCarrinho() {
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-backpack");
		produtosPage.clicarItemPorId("add-to-cart-sauce-labs-bike-light");
		produtosPage.removerProdutoCarrinho("remove-sauce-labs-backpack");
		Assert.assertNotEquals("2", produtosPage.obterContadorCarrinho("//span[@class=\"shopping_cart_badge\"]"));
	}
	
	@Test
	public void clicarBotaoCheckout() {
		produtosPage.clicarItemPorId("add-to-cart-sauce-labs-backpack");
		carrinhoPage.clicarCarrinho("shopping_cart_link");
		carrinhoPage.clicarCheckout("checkout");
		Assert.assertTrue(carrinhoPage.checarFormularioVisivel("first-name"));
		
	}
}
