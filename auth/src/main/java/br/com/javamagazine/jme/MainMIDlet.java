package br.com.javamagazine.jme;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.javamagazine.jme.view.LoginForm;

public class MainMIDlet extends MIDlet {

	protected void startApp() throws MIDletStateChangeException {
		Application.initialize();
		LoginForm form = new LoginForm();
		Application.setMIDlet(this);
		Application.getDisplay().setCurrent(form);
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
}
