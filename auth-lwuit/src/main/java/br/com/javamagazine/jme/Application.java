package br.com.javamagazine.jme;

import java.io.IOException;
import java.util.Hashtable;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;

import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.PersistableManager;
import br.com.javamagazine.jme.model.User;

public class Application {

	private static MIDlet midlet;
	private static User user;
	private static Display display;
	private static Resources theme;
	private static Hashtable L10N;

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

	public static String getMessage(String key) {
		if (L10N != null && L10N.get(key) != null) {
			return (String) L10N.get(key);
		}
		return key;
	}

	private static String getLocale() {
		return "pt";
	}

	public static void setTheme(String themeFile, String themeName) {
		try {
			theme = Resources.open(themeFile);
			UIManager.getInstance().addThemeProps(theme.getTheme(themeName));
			try {
				L10N = theme.getL10N(theme.getL10NResourceNames()[0],
						getLocale());
			} catch (ArrayIndexOutOfBoundsException e) {
				// no L10N
			}
		} catch (IOException e) {
			error("Theme load failed", e);
		}
	}
}
