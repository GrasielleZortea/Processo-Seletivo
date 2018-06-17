package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {

	 WebDriver navegador;

	public LoginPages(WebDriver navegador)	{
		this.navegador = navegador;
	}
public void PreencherCamposSucesso() {

	navegador.findElement(By.name("j_username")).sendKeys("avaliacao_qa_samba@sambatech.com.br");
	navegador.findElement(By.name("j_password")).sendKeys("123456789");
	navegador.findElement(By.id("login")).click();
	String autentifica = navegador.findElement(By.id("navbar-client-name")).getText();
	//Nao consegui comparar com nome do usuario
	assertEquals("Processo Seletivo", autentifica);

}
public void PreencherCamposSemSucesso() {
//Uso de login invalido
	navegador.findElement(By.name("j_username")).sendKeys("avaliacao_qa_samba@sambatech.com");
	navegador.findElement(By.name("j_password")).sendKeys("123456789");
	navegador.findElement(By.id("login")).click();
	navegador.findElement(By.id("password_incorrect"));


}
}
