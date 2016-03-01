package tapinapp.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Locale;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.Request;
import org.slf4j.Logger;

/**
 * Base class for all our pages.
 */
public abstract class BasePage extends BaseComponent {

	@Inject
	private Locale					currentLocale;

	@Inject
	private PageRenderLinkSource	linkRenderer;

	@Inject
	private BeanModelSource			beanModelSource;

	@Inject
	private Messages				messages;

	@Inject
	private Request					request;

	public Date getCurrentTime() {
		return new Date();
	}

	public Locale getLocale() {
		return currentLocale;
	}

	protected void logEnter(Logger l, EventContext ctx) {
		l.debug("[ENTER] onActivate(" + toString(ctx) + ")");
	}

	protected void logExit(Logger l, EventContext ctx) {
		l.debug("[ EXIT] onActivate(" + toString(ctx) + ")");
	}

	protected String getRequestParameter(String name) {
		return request.getParameter(name);
	}

	public static String toString(EventContext ctx) {
		StringBuilder b = new StringBuilder();
		String[] ss = ctx.toStrings();
		for (String s : ss) {
			if (b.length() > 0)
				b.append(",");
			b.append(s);
		}
		return b.toString();
	}

	protected static boolean nullSafeEquals(Object pObj1, Object pObj2) {
		if (null == pObj1 || null == pObj2)
			return pObj1 == pObj2;
		else
			return pObj1.equals(pObj2);
	}

	/**
	 * @param text
	 * @return
	 */
	protected static boolean anyEmpty(String... texts) {
		for (String text : texts)
			if ((text == null) || text.trim().isEmpty())
				return true;
		return false;
	}

	/**
	 * @param text
	 * @return
	 */
	protected static boolean empty(String text) {
		return allEmpty(text);
	}

	/**
	 * @param text
	 * @return
	 */
	protected static boolean allEmpty(String... texts) {
		for (String text : texts)
			if ((text != null) && !text.trim().isEmpty())
				return false;
		return true;
	}

	/**
	 * @param text
	 * @return
	 */
	protected static boolean anyNull(Object... objects) {
		for (Object o : objects)
			if (o == null)
				return true;
		return false;
	}

	protected static boolean same(Long l1, Long l2) {
		if (l1 == null || l2 == null)
			return l1 == l2;
		else
			return l1.equals(l2);
	}

	public String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		t.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}

	protected String fmt(String fmt, Object... args) {
		return String.format(fmt, args);
	}

}
