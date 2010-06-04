package br.com.javamagazine.jme;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class MainMIDlet extends MIDlet {

	protected void startApp() throws MIDletStateChangeException {
		Form form = new Form("MIDlet");
		form.addCommand(new Command("Sair", Command.EXIT, 1));
		form.append("Olá Mundo!");
		form.setCommandListener(new CommandListener() {
			public void commandAction(Command arg0, Displayable arg1) {
				try {
					destroyApp(false);
				} catch (MIDletStateChangeException e) {
					e.printStackTrace();
				}
				notifyDestroyed();
			}
		});
		Display.getDisplay(this).setCurrent(form);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
	}

	protected void pauseApp() {
	}

}
