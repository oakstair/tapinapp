package tapinapp.base;

import java.util.Locale;

import org.apache.tapestry5.Link;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.Request;
import org.slf4j.Logger;

/**
 * Base class for all our components.
 */
public abstract class BaseComponent {
	@Inject
	private Logger					log;

	@Inject
	private Locale					currentLocale;

	@Inject
	private PageRenderLinkSource	linkRenderer;

	@Inject
	private Messages				messages;

	@Inject
	private Request					request;

	public boolean isEnglish() {
		return getLanguage().equals("en");
	}

	public boolean isSwedish() {
		return getLanguage().equals("sv");
	}

	public String getLanguage() {
		return currentLocale.getLanguage();
	}

	// -----------------------------------------------------------------------
	// -- Utility methods for all our children --
	// -----------------------------------------------------------------------

	protected Link gotoPageWithContext(String page, Object... context) {
		return linkRenderer.createPageRenderLinkWithContext(page, context);
	}

}
