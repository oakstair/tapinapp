package tapinapp.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.IOCSymbols;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to configure and extend
 * Tapestry, or to place your own service definitions.
 */
public class TapinappModule {

	private static Logger log = LoggerFactory.getLogger(TapinappModule.class);

	static {
		log.info("Tapinapp module was initialized");
	}

	@ApplicationDefaults
	@Contribute(SymbolProvider.class)
	public static void contributeApplicationDefaults(MappedConfiguration<String, String> c) {

		c.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");

		c.add(SymbolConstants.SUPPORTED_LOCALES, "en");

		// -- App engine setup --
		c.add(SymbolConstants.PRODUCTION_MODE, "false");
		c.add(SymbolConstants.RESTRICTIVE_ENVIRONMENT, "true");
		c.add(IOCSymbols.THREAD_POOL_ENABLED, "false");

		c.add(SymbolConstants.APPLICATION_VERSION, "1.0");

		c.add(SymbolConstants.COMPRESS_WHITESPACE, "false");

		c.add(SymbolConstants.GZIP_COMPRESSION_ENABLED, "false");

		c.add(SymbolConstants.HMAC_PASSPHRASE, "AbraKadabraHokusPokus");
	}

}
