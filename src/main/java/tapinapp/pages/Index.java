package tapinapp.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import tapinapp.base.BasePage;

public class Index extends BasePage {

	@Inject
	private Logger log;

	// ----------------------------------------------------------------------------
	// -- Tapestry events - Tapestry events - Tapestry events - Tapestry events --
	// ----------------------------------------------------------------------------

	void onActivate() {
		log.info("INDEX page was smashed!");
	}

}