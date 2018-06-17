package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConteudoPages {

	static WebDriver navegador;

	public ConteudoPages(WebDriver navegador) {
		this.navegador = navegador;
	}

	public void EditarConteudo() {
		//Editar o Conteudo para testar a melhoria de limite de campo
		navegador.findElement(By.id("mn-content")).click();
		navegador.findElement(By.className("edit-media-link")).click();
		navegador.findElement(By.name("title")).clear();
		navegador.findElement(By.name("title")).sendKeys("01");
		navegador.findElement(By.id("description")).clear();
		navegador.findElement(By.id("description")).sendKeys(
				"Lorem ipsum ligula vestibulum potenti enim et quam, commodo ornare aaaaaptent asasassodales nunc maecenas consectetur, platea feugiat hac diam curae conubia. sed tincidunt sem quam phasellus hac conubia praesent scelerisque, velit magna convallis donec mattis risus tellus, accumsan integer class sit class eu aptent. ad tincidunt varius a facilisis ultrices elit senectus curae egestas ante ornare nec, tellus suspendisse cubilia quis sapien taciti curabitur commodo integer dapibus neque dapibus a, urna sagittis eleifend mauris per mollis donec vehicula class tincidunt luctus. ornare potenti senectus eu dolor placerat at, curabitur litora id proin dui torquent praesent, consequat cubilia etiam ullamcorper curabitur.as velit nisi potenti est, malesuada enim cubilia enim orci curabitur morbi risus et est, dictum dui nec fames felis egestas molestie venenatis. vulputate enim dictumst a nostra at varius viverra ultrices ipsum tincidunt, inceptos ante fringilla etiam nostra rutrum lacus lobortis lu");
		navegador.findElement(By.name("save")).click();
		String msgSucesso = navegador.findElement(By.className("alert alert-success hide")).getText();
		assertEquals("01 foi editado com sucesso!", msgSucesso);
			}

	public void ExcluirConteudo() {

	}

}
