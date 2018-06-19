package pageObject;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Arquivo;

public class EnviarVideoPages {

	WebDriver navegador;
	By enviar = By.id("mn-upload");
	By upload = By.xpath("//*[@id=\"uploader\"]/div[2]/input");

	public EnviarVideoPages(WebDriver navegador) {
		this.navegador = navegador;
	}

	public void UploadoSucesso() throws AWTException, InterruptedException {

		navegador.findElement(enviar).click();
		navegador.findElement(upload).click();
		Arquivo video = new Arquivo();
		video.ArquivoTela("Video Linxo 20s.mov");
		String uploadSucesso = navegador.findElement(By.className("progress progress-large progress-success"))
				.getText();
		assertEquals("O conteúdo está pronto!", uploadSucesso);
	}
}
