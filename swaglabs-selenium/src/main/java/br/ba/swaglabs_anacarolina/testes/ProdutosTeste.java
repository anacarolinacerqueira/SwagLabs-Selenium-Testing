package br.ba.swaglabs_anacarolina.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.ba.swaglabs_anacarolina.core.BaseTeste;
import br.ba.swaglabs_anacarolina.pages.LoginPage;
import br.ba.swaglabs_anacarolina.pages.ProdutosPage;


public class ProdutosTeste extends BaseTeste {
	
	LoginPage loginPage = new LoginPage();
	ProdutosPage produtosPage = new ProdutosPage();
	
	
	@Before
	public void inicializa() {
		loginPage.irParaTeladeLogin("https://www.saucedemo.com/");
		loginPage.preencherCampoUsername("user-name", "standard_user");
		loginPage.preencherCampoSenha("password", "secret_sauce");
		loginPage.clicarBotaoLogin("login-button");
	}
	
	@Test
	public void acessarPaginaProduto() {
		produtosPage.acessarProdutoMochila("item_4_title_link");
		Assert.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", loginPage.obterUrlAtual());
	}
	
	@Test
	public void adicionarUmProdutoCarrinhoVerificaBotao() {
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-backpack");
		Assert.assertEquals("REMOVE", produtosPage.obterTextoBotao("remove-sauce-labs-backpack"));
	}
	
	@Test
	public void adicionarUmProdutoCarrinhoVerificaCarrinho() {
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-bike-light");
		Assert.assertEquals("1", produtosPage.obterContadorCarrinho("//span[@class=\"shopping_cart_badge\"]"));
	}
	
	@Test
	public void RemoverProdutoDoCarrinhoViaBotao() {
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-backpack");
		Assert.assertEquals("REMOVE", produtosPage.obterTextoBotao("remove-sauce-labs-backpack"));
		produtosPage.removerProdutoCarrinho("remove-sauce-labs-backpack");
		Assert.assertEquals("ADD TO CART", produtosPage.obterTextoBotao("add-to-cart-sauce-labs-backpack"));
	}
	
	@Test
	public void adicionarTresProdutosCarrinho() {
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-bolt-t-shirt");
		produtosPage.adicionarProdutoCarrinho("add-to-cart-test.allthethings()-t-shirt-(red)");
		produtosPage.adicionarProdutoCarrinho("add-to-cart-sauce-labs-fleece-jacket");
		Assert.assertEquals("3", produtosPage.obterContadorCarrinho("//span[@class=\"shopping_cart_badge\"]"));
	}
	
	@Ignore
	public void filtrarPorNome() {
		//produtosPage.selecionarFiltro("product_sort_container", "Name (Z to A)");
	}
	
	@Ignore
	public void filtrarPorPreco() {
	}
}
