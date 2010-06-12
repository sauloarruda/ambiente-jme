package br.com.javamagazine.jme.model;

import br.com.javamagazine.jme.exception.LoginException;
import net.sourceforge.floggy.persistence.Filter;
import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.ObjectSet;
import net.sourceforge.floggy.persistence.Persistable;
import net.sourceforge.floggy.persistence.PersistableManager;

public class User implements Persistable {

	private String login;
	private String password;

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public static User authenticate(String login, String password)
			throws FloggyException {
		ObjectSet os = PersistableManager.getInstance().find(User.class,
				new User.LoginFilter(login), null);
		if (os.size() > 0) {
			User user = (User) os.get(0);
			if (password.equals(user.password)) {
				return user;
			} else {
				throw new LoginException("user.invalidPassword");
			}
		} else {
			throw new LoginException("user.invalidLogin");
		}
	}

	public Object getLogin() {
		return this.login;
	}

	static class LoginFilter implements Filter {

		private String login;

		public LoginFilter(String login) {
			this.login = login;
		}

		public boolean matches(Persistable o) {
			User user = (User) o;
			return user.getLogin().equals(login);
		}

	}

}
