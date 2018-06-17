package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampanhaPages {

	WebDriver navegador;
	static LoginPages LoginPages;
	public CampanhaPages(WebDriver navegador) {

		this.navegador = navegador;
	}

	public void CriarCampanha() {
		//Criar uma campanha para testar bug de nao criar campanha	
		//LoginPages.PreencherCamposSucesso();
		navegador.findElement(By.name("j_username")).sendKeys("avaliacao_qa_samba@sambatech.com.br");
		navegador.findElement(By.name("j_password")).sendKeys("123456789");
		navegador.findElement(By.id("login")).click();
		
		// fim do login
						
		navegador.findElement(By.id("mn-monetization")).click();		
		navegador.findElement(By.id("create-campaign")).click();
		navegador.findElement(By.name("name")).sendKeys("Criacao de campanha 01");
		//Escolher arquivo
		navegador.findElement(By.id("upload")).click();
		WebElement file_input = navegador.findElement(By.id("upload"));
		file_input.click();
		file_input.sendKeys("C:\\Users\\cmarg\\Downloads\\Video Linxo 20s.mp4");
		//
		navegador.findElement(By.name("urlClickThrough")).sendKeys("Sambatech.com.br");
		navegador.findElement(By.id("select-existing-channels")).click();
		navegador.findElement(By.id("publishDate")).sendKeys("19/06/2018");
		navegador.findElement(By.id("unpublishDate")).sendKeys("30/06/2018");
		navegador.findElement(By.name("target")).sendKeys("10");
		navegador.findElement(By.name("grossValue")).sendKeys("100");
		navegador.findElement(By.className("btn btn-primary")).click();
	    navegador.findElement(By.className("alert alert-error fixed-errors"));
		String msgSucessoCampanha = navegador.findElement(By.className("alert alert-error fixed-errors")).getText();
		assertEquals("com sucesso!", msgSucessoCampanha);
			}}