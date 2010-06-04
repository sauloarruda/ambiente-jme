package br.com.javamagazine.jme.view;

import java.util.Hashtable;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

import net.sourceforge.floggy.persistence.FloggyException;
import br.com.javamagazine.jme.Application;
import br.com.javamagazine.jme.exception.LoginException;
import br.com.javamagazine.jme.model.User;

public class LoginForm extends Form {

	private TextField txtLogin = new TextField("Login", "", 20, TextField.ANY);
	private TextField txtPassword = new TextField("Password", "", 20,
			TextField.PASSWORD);
	private StringItem sitError = new StringItem("", "");
	private Command comSignIn = new Command("Sign in", Command.OK, 1);
	private Hashtable messages = new Hashtable();

	public LoginForm() {
		super("Sign in");
		initializeMessages();
		append(sitError);
		append(txtLogin);
		append(txtPassword);
		addCommand(comSignIn);
		this.setCommandListener(new CommandListener() {
			public void commandAction(Command cmd, Displayable display) {
				try {
					User user = User.authenticate(txtLogin.getString(),
							txtPassword.getString());
					Application.setUser(user);
					Application.getDisplay().setCurrent(new HomeForm());
				} catch (FloggyException e) {
					Application.error((String) messages.get("user.loginError"),
							e);
				} catch (LoginException e) {
					sitError.setText((String) messages.get(e.getMessage()));
				}
			}
		});
	}

	private void initializeMessages() {
		messages.put("user.invalidLogin", "Invalid Login");
		messages.put("user.invalidPassword", "Invalid Password");
		messages.put("user.loginError", "Unknown Error");
	}
}
