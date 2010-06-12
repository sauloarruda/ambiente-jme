package br.com.javamagazine.jme.view;

import br.com.javamagazine.jme.Application;

import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextField;
import com.sun.lwuit.layouts.BoxLayout;

public class LoginForm extends Form {

	private Label lblError = new Label();
	private TextField txtLogin = new TextField("");
	private TextField txtPassword = new TextField("");
	private Command commandEntrar = new Command("Entrar");
	private Command commandSair = new Command("Sair");

	public LoginForm() {
		super();
		this.construirForm();
	}

	private void construirForm() {
		txtPassword.setConstraint(com.sun.lwuit.TextField.PASSWORD);
		this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		this.addComponent(this.lblError);
		Container form = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		form.addComponent(new Label(Application.getMessage("auth.login")));
		form.addComponent(txtLogin);
		form.addComponent(new Label(Application.getMessage("auth.password")));
		form.addComponent(txtPassword);
		this.addComponent(form);
		this.addCommand(commandSair);
		this.addCommand(commandEntrar);
		this.setFocused(txtLogin);
	}

	public TextField getTxtLogin() {
		return txtLogin;
	}

	public TextField getTxtPassword() {
		return txtPassword;
	}

	public Command getCommandEntrar() {
		return commandEntrar;
	}

	public void setStatus(String message) {
		lblError.setText(message);
		repaint();
	}

}
