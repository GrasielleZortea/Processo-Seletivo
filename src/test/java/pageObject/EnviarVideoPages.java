package pageObject;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

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

	public void UploadoSucesso() throws AWTException {

		navegador.findElement(enviar).click();
		
		delay(1000);
		Robot robot= new Robot();
		robot.setAutoDelay(1000);
		File f= new File("src\\test\\java\\arquivos\\Video Linxo 20s.mov");
		StringSelection strAnx= new StringSelection(f.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strAnx, null);
		
		WebElement file_input = navegador.findElement(upload);
		/*robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//navegador.findElement(upload).click();
		// clicar item do windows e abrir
		
		//file_input.click();
		//file_input.sendKeys("src\\test\\java\\arquivos\\Video Linxo 20s.mov");
		// clicar item do windows e abrir

		String uploadSucesso = navegador.findElement(By.className("progress progress-large progress-success"))
				.getText();
				assertEquals("O conteúdo está pronto!", uploadSucesso);*/

	}

	private void delay(int i) {
		// TODO Auto-generated method stub
		
	}
}
