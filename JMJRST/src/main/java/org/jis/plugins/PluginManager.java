package org.jis.plugins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * Knows all available plugins and is responsible for using the service loader
 * API to detect them.
 *
 */
public final class PluginManager {

	/**
	 * No constructor for utility class.
	 */
	private PluginManager() {

	}

	/**
	 * @return all available plugins sorted alphabetically by their name in
	 *         ascending order.
	 */
	public static List<JmjrstPlugin> getPlugins() {
		List<JmjrstPlugin> pluginList = new ArrayList<JmjrstPlugin>();
		try {
			ServiceLoader<JmjrstPlugin> loader = ServiceLoader
					.load(JmjrstPlugin.class);
			Iterator<JmjrstPlugin> plugins = loader.iterator();
			while (plugins.hasNext()) {
				JmjrstPlugin plugin = plugins.next();
				pluginList.add(plugin);
			}
		} catch (ServiceConfigurationError serviceError) {
			serviceError.printStackTrace();
		}
		Collections.sort(pluginList);
		return pluginList;
	}
}
