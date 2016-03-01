package tapinapp.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Cookies;
import org.slf4j.Logger;

import tapinapp.base.BaseComponent;

/**
 * Layout for our pages.
 */
public class Layout extends BaseComponent {
	/**
	 * Page title.
	 */
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String	title;

	@Inject
	private Cookies	cookies;

	@Inject
	private Logger	log;

	@Property
	private String	passwordHint;

	@Property
	private String	emailHint;

	@Property
	private String	password;

	@Property
	private String	email;

	@Component(id = "loginForm")
	private Form	loginForm;

	@Property
	private boolean	loggedIn;

	// ---------------------------------------------------------------------------
	// -- Tapestry events - Tapestry events - Tapestry events - Tapestry events --
	// ---------------------------------------------------------------------------

	void setupRender() {
	}

	// ------------------------------------------------------------------------------
	// -- TML helper's - TML helper's - TML helper's - TML helper's - TML helper's --
	// ------------------------------------------------------------------------------

	public String getFileClass() {
		return "active";
	}

	public String getTitle() {
		return title;
	}
	// ---------------------------------------------------------------------------------------
	// Private - Private - Private - Private - Private - Private - Private - Private - Private
	// ---------------------------------------------------------------------------------------

}