package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnviarVideoPages {

	WebDriver navegador;
	By enviar = By.id("mn-upload");
	By upload = By.xpath("//*[@id=\"uploader\"]/div[2]/input");

	public EnviarVideoPages(WebDriver navegador) {
		this.navegador = navegador;
	}

	public void UploadoSucesso() {

		navegador.findElement(enviar).click();
		//navegador.findElement(upload).click();
		// clicar item do windows e abrir
		WebElement file_input = navegador.findElement(upload);
		file_input.click();
		file_input.sendKeys("C:\\Users\\cmarg\\Downloads\\Video Linxo 20s.mp4");
		// clicar item do windows e abrir

		String uploadSucesso = navegador.findElement(By.className("progress progress-large progress-success"))
				.getText();
		// Nao consegui comparar com nome do usuario
		assertEquals("O conteúdo está pronto!", uploadSucesso);

	}
}
