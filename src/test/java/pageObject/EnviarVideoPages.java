package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnviarVideoPages {

	static WebDriver navegador;

	public EnviarVideoPages(WebDriver navegador) {
		this.navegador = navegador;
	}

	public void UploadoSucesso() {

		navegador.findElement(By.id("mn-upload")).click();
		navegador.findElement(By.id("uploader-large")).click();
		// clicar item do windows e abrir
		String uploadSucesso = navegador.findElement(By.className("progress progress-large progress-success"))
				.getText();
		// Nao consegui comparar com nome do usuario
		assertEquals("O conteúdo está pronto!", uploadSucesso);

	}
}
