package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    public LoginPage() {
        super(null);
        browser.navigate().to("http://localhost:8080/login");
    }

    public void preencheFormularioDeLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage submeteFormulario() {
        browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(browser);
    }

    public boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals("http://localhost:8080/login");
    }

    public String getNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegaParaPaginadDeLances() {
        browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String s) {
        return browser.getPageSource().contains(s);
    }

    public boolean isPaginaDeLoginComDadosInvalidos() {
        return browser.getCurrentUrl().equals("http://localhost:8080/login?error");
    }
}
