package pageObject;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Arquivo;

public class CampanhaPages {

	WebDriver navegador;
	By monetizacao = By.id("mn-monetization");
	By criarCampanha = By.id("create-campaign");
	By titulo = By.name("name");
	By enviarAnuncio = By.xpath("//*[@id=\"new-campaign\"]/article[1]/div[2]/form/div[1]/div[2]/input");
	By urlDestino = By.name("urlClickThrough");
	By categoria = By.id("select-existing-channels");
	By dataInicio = By.id("publishDate");
	By dataFim = By.id("unpublishDate");
	By meta = By.name("target");
	By custo = By.name("grossValue");
	By gravar = By.xpath("//*[@id=\"new-campaign\"]/div[5]/div[1]/button[2]");

	static LoginPages LoginPages;

	public CampanhaPages(WebDriver navegador) {

		this.navegador = navegador;
	}

	public void CriarCampanha() throws AWTException, InterruptedException {
		// Criar uma campanha para testar bug de nao criar campanha

		navegador.findElement(monetizacao).click();
		navegador.findElement(criarCampanha).click();
		navegador.findElement(titulo).sendKeys("Criacao de campanha 01");
		Thread.sleep(2000);
		navegador.findElement(enviarAnuncio).click();
		Thread.sleep(2000);
		// Escolher arquivo
		Arquivo video = new Arquivo();
		video.ArquivoTela("Video Linxo 20s.mov");
		navegador.findElement(urlDestino).sendKeys("Sambatech.com.br");
		navegador.findElement(categoria).click();
		navegador.findElement(dataInicio).sendKeys("19/06/2018");
		navegador.findElement(dataFim).sendKeys("30/06/2018");
		navegador.findElement(meta).sendKeys("10");
		navegador.findElement(custo).sendKeys("100");
		navegador.findElement(gravar).isDisplayed();
		navegador.findElement(gravar).click();

		String msgSucessoCampanha = navegador.findElement(By.className("alert alert-error fixed-errors")).getText();
		assertEquals("com sucesso!", msgSucessoCampanha);
	}

	public void ValidarCampoSemLimite() {
		// Testa a falta de limite de caracteres nos campos Custo e meta que
		// impossibilita o calculo da previsao da receita.

		navegador.findElement(monetizacao).click();
		navegador.findElement(criarCampanha).click();
		navegador.findElement(meta).sendKeys("1000000000000000000000");
		navegador.findElement(custo).sendKeys("1000");
		String previsaoReceita = navegador.findElement(By.className("campaign-value")).getText();
		assertEquals("1000000000000000000000.00", previsaoReceita);

	}
}