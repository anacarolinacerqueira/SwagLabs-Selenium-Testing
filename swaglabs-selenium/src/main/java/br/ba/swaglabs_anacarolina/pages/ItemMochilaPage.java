package br.ba.swaglabs_anacarolina.pages;

import static br.ba.swaglabs_anacarolina.core.DriverFactory.getDriver;
import org.openqa.selenium.By;
import br.ba.swaglabs_anacarolina.core.BasePage;

public class ItemMochilaPage extends BasePage{
	
	public void clicarBotaoVoltar(String id) {
		getDriver().findElement(By.id(id)).click();
	}

}
