package br.com.javamagazine.jme.controller;

import net.sourceforge.floggy.persistence.FloggyException;
import br.com.javamagazine.jme.Application;
import br.com.javamagazine.jme.exception.LoginException;
import br.com.javamagazine.jme.model.User;
import br.com.javamagazine.jme.view.LoginForm;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;

public class LoginController {

	private LoginForm loginForm;

	public LoginController() {
		super();
		loginForm = new LoginForm();
		this.autenticar();
		loginForm.show();
	}

	public void autenticar() {
		loginForm.addCommandListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getCommand().equals(loginForm.getCommandEntrar())) {
					try {
						User user = User.authenticate(loginForm.getTxtLogin()
								.getText(), loginForm.getTxtPassword()
								.getText());
						Application.setUser(user);
						loginForm.setStatus("OK!");
						// TODO redirecionar
					} catch (FloggyException e) {
						Application.error(Application
								.getMessage("user.loginError"), e);
					} catch (LoginException e) {
						loginForm.setStatus(Application.getMessage(e
								.getMessage()));
					}
				} else {
					Application.exit();
				}
			}

		});
	}

}
