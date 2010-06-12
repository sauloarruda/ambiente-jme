package br.com.javamagazine.jme.controller;

import net.sourceforge.floggy.persistence.FloggyException;
import br.com.javamagazine.jme.Application;
import br.com.javamagazine.jme.exception.LoginException;
import br.com.javamagazine.jme.model.User;
import br.com.javamagazine.jme.view.HomeForm;
import br.com.javamagazine.jme.view.LoginLwuit;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;

/**
 * Controller para a tela de login do sistema.
 */
public class LoginController {

    private LoginLwuit loginLwuit;

    public LoginController() {
	super();
	loginLwuit = new LoginLwuit();
	this.autenticar();
	loginLwuit.show();
    }

    public void autenticar() {
	loginLwuit.addCommandListener(new ActionListener() {
	    public void actionPerformed(ActionEvent event) {
		if (event.getCommand().equals(loginLwuit.getCommandEntrar())) {
		    try {
			User user = User.authenticate("jeffmor", "agent");
			Application.setUser(user);
			adicionarMensagem("Deu certo");
//			Application.getDisplay().setCurrent(new HomeForm());
		    } catch (FloggyException e) {
			adicionarMensagem("Erro:"
				+ e.getMessage());
		    } catch (LoginException e) {
			adicionarMensagem("Erro ao autenticar:"
				+ e.getMessage());
		    }
		} else {
		    Application.exit();
		}
	    }

	});
    }

    /**
     * Mostra a mensagem no formul‡rio.
     * 
     * @param mensagem
     */
    private void adicionarMensagem(String mensagem) {
	loginLwuit.getMensagem().setText(mensagem);
	loginLwuit.getMensagem().setVisible(true);
	loginLwuit.getMensagem().setIcon(null);
	loginLwuit.show();
    }

}
