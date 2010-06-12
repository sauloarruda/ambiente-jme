package br.com.javamagazine.jme.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import br.com.javamagazine.jme.Application;

public class HomeForm extends Form {

	public HomeForm() {
		super("Home");
		append("Welcome Back " + Application.getUser().getLogin());
		addCommand(new Command("Exit", Command.EXIT, 1));
		setCommandListener(new CommandListener() {
			public void commandAction(Command arg0, Displayable arg1) {
				Application.exit();
			}
		});
	}
}
