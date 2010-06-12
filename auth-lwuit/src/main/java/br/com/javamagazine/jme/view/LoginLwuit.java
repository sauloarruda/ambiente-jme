package br.com.javamagazine.jme.view;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextField;
import com.sun.lwuit.layouts.BoxLayout;

public class LoginLwuit extends Form {

    private TextField campoLogin = new TextField("jeffmor");
    private TextField campoSenha = new TextField("agent");
    private Button mensagem = new Button("Digite a sua senha");
    private Command commandEntrar = new Command("Entrar");
    private Command commandSair = new Command("Sair");

    public LoginLwuit() {
	super();
	this.construirForm();
    }

    private void construirForm() {
	this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
	this.mensagem.setVisible(true);
	this.mensagem.setAlignment(CENTER);
	this.addComponent(this.mensagem);
	Container form = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	form.getStyle().setPadding(5, 5, 5, 5);
	form.addComponent(campoLogin);
	campoSenha.setConstraint(com.sun.lwuit.TextField.PASSWORD);
	form.addComponent(campoSenha);
	this.addComponent(form);
	this.addCommand(commandSair);
	this.addCommand(commandEntrar);
	this.setFocused(campoLogin);
    }

    public TextField getCampoLogin() {
	return campoLogin;
    }

    public TextField getCampoSenha() {
	return campoSenha;
    }

    public Command getCommandEntrar() {
	return commandEntrar;
    }

    public Label getMensagem() {
	return mensagem;
    }

}
