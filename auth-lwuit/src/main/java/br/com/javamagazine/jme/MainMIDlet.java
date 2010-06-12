package br.com.javamagazine.jme;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.javamagazine.jme.controller.LoginController;

import com.sun.lwuit.Display;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;

public class MainMIDlet extends MIDlet implements ActionListener {

	protected void startApp() throws MIDletStateChangeException {
		Application.initialize();
		Display.init(this);
		Application.setMIDlet(this);
		Application.setTheme("/theme.res", "theme1");
		try {
			new LoginController();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
	}

	protected void pauseApp() {
	}

	public void exit() {
		try {
			destroyApp(false);
		} catch (MIDletStateChangeException e) {
			e.printStackTrace();
		}
		notifyDestroyed();
	}

	public void actionPerformed(ActionEvent arg0) {
		notifyDestroyed();
	}
}
