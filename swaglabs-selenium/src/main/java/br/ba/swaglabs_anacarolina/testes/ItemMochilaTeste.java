package br.ba.swaglabs_anacarolina.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import br.ba.swaglabs_anacarolina.core.BaseTeste;
import br.ba.swaglabs_anacarolina.pages.LoginPage;
import br.ba.swaglabs_anacarolina.pages.ProdutosPage;
import br.ba.swaglabs_anacarolina.pages.ItemMochilaPage;


public class ItemMochilaTeste extends BaseTeste {
	
	LoginPage loginPage = new LoginPage();
	ProdutosPage produtosPage = new ProdutosPage();
	ItemMochilaPage mochilaPage = new ItemMochilaPage();
	
	
	@Before
	public void inicializa() {
		loginPage.irParaTeladeLogin("https://www.saucedemo.com/");
		loginPage.preencherCampoUsername("user-name", "standard_user");
		loginPage.preencherCampoSenha("password", "secret_sauce");
		loginPage.clicarBotaoLogin("login-button");
		produtosPage.acessarProdutoMochila("item_4_title_link");
	}
	
	@Test
	public void adicionarProdutoCarrinhoPaginaProdutoVerificaBotao() {
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-backpack");
		Assert.assertEquals("REMOVE", produtosPage.obterTextoBotao("remove-sauce-labs-backpack"));
	}
	
	@Test
	public void adicionarUmProdutoCarrinhoVerificaCarrinho() {
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-backpack");
		Assert.assertEquals("1", produtosPage.obterContadorCarrinho("//span[@class=\"shopping_cart_badge\"]"));
	}
	
	@Test
	public void RemoverProdutoDoCarrinhoViaBotaoPaginaProduto() {
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-backpack");
		produtosPage.removerProdutoCarrinho("remove-sauce-labs-backpack");
		Assert.assertEquals("ADD TO CART", produtosPage.obterTextoBotao("add-to-cart-sauce-labs-backpack"));
	}
	
	@Test
	public void clicarBotaoVoltarProdutos() {
		mochilaPage.clicarBotaoVoltar("back-to-products");
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.obterUrlAtual());
	}
	
}
