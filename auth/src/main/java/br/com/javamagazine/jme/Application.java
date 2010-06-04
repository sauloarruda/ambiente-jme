package br.com.javamagazine.jme;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.PersistableManager;
import br.com.javamagazine.jme.model.User;

public class Application {

	private static MIDlet midlet;
	private static User user;
	private static Display display;

	private Application() {
	}

	public static void initialize() {
		try {
			PersistableManager.getInstance().save(
					new User("sauloarruda", "secret"));
			PersistableManager.getInstance().save(new User("jeffmor", "agent"));
		} catch (FloggyException e) {
			error(e.getMessage(), e);
		}
	}

	public static void setMIDlet(MIDlet midlet) {
		Application.midlet = midlet;
		Application.display = Display.getDisplay(Application.midlet);
	}

	public static void error(String message, Throwable exception) {
		exception.printStackTrace();
		Alert alert = new Alert(message);
		display.setCurrent(alert);
	}

	public static void setUser(User user) {
		Application.user = user;
	}

	public static User getUser() {
		return user;
	}

	public static Display getDisplay() {
		return Application.display;
	}

	public static void exit() {
		midlet.notifyDestroyed();
	}

}
