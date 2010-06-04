package br.com.javamagazine.jme.test;

import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.PersistableManager;
import br.com.javamagazine.jme.exception.LoginException;
import br.com.javamagazine.jme.model.User;
import jmunit.framework.cldc11.TestCase;

public class UserTest extends TestCase {

	public UserTest() {
		super(3, "UserTest");
	}

	public void test(int testNumber) throws Throwable {
		switch (testNumber) {
		case 0:
			validLoginAndPassword();
			break;
		case 1:
			invalidLogin();
			break;
		case 2:
			invalidPassword();
			break;
		}
	}

	public void setUp() throws Throwable {
		try {
			PersistableManager.getInstance().save(
					new User("sauloarruda", "secret"));
		} catch (FloggyException e) {
			fail(e.toString());
			e.printStackTrace();
		}
	}

	private void invalidPassword() {
		try {
			authenticate("sauloarruda", "invalid.password");
			fail("LoginException expected");
		} catch (LoginException e) {
			assertEquals("user.invalidPassword", e.getMessage());
		}
	}

	private void invalidLogin() {
		try {
			authenticate("invalid.login", "secret");
			fail("LoginException expected");
		} catch (LoginException e) {
			assertEquals("user.invalidLogin", e.getMessage());
		}
	}

	private void validLoginAndPassword() {
		User user = authenticate("sauloarruda", "secret");
		assertNotNull(user);
		assertEquals("sauloarruda", user.getLogin());
	}

	private User authenticate(String login, String password) {
		try {
			return User.authenticate(login, password);
		} catch (FloggyException e) {
			e.printStackTrace();
			fail(e.toString());
			return null;
		}
	}

}
