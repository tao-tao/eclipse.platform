package org.eclipse.update.internal.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.StringTokenizer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.update.core.AbstractFeature;
import org.eclipse.update.core.AbstractSite;
import org.eclipse.update.core.IFeature;
import org.eclipse.update.core.IPluginEntry;
import org.eclipse.update.core.ISiteChangedListener;
import org.eclipse.update.core.VersionedIdentifier;

public class FileSite extends URLSite {

	private String path;
	public static final String INSTALL_FEATURE_PATH = "install/features/";

	/**
	 * Constructor for FileSite
	 */
	public FileSite(URL siteReference) {
		super(siteReference);
	}

	private String getPath() {
		if (path == null) {
			path = getURL().getPath();
			if (path.startsWith(File.separator))
				path = path.substring(1);
		}
		return path;
	}

	/**
	 * @see AbstractSite#createExecutableFeature(IFeature)
	 */
	public AbstractFeature createExecutableFeature(IFeature sourceFeature) {
		return new DefaultExecutableFeature(sourceFeature, this);
	}

	/**
	 * @see IPluginContainer#store(IPluginEntry, String, InputStream)
	 */
	public void store(
		IPluginEntry pluginEntry,
		String contentKey,
		InputStream inStream) {
		try {

			// TEST: what if SiteURL is not valid ? 

			File pluginSite = new File(getPath() + DEFAULT_PLUGIN_PATH);
			if (!pluginSite.exists()) {
				if (!CREATE_PATH) {
					//FIXME: Serviceability
					throw new IOException("The Path:" + pluginSite.toString() + "does not exist.");
				} else {
					//FIXME: Serviceability
					if (!pluginSite.mkdirs())
						throw new IOException("Cannot create:" + pluginSite.toString());
				}
			}

			// create plugin if doesn't exist
			// FIXME: mkdir or mkdirs ?
			String pluginPath =
				getPath() + DEFAULT_PLUGIN_PATH + pluginEntry.getIdentifier().toString();
			File pluginDirectory = new File(pluginPath);
			if (!pluginDirectory.exists()) {
				pluginDirectory.mkdir();
			}

			// create directory if doesn't exist
			int lastSeparator = contentKey.lastIndexOf('/');
			if (lastSeparator != -1) {
				String path = contentKey.substring(0, lastSeparator);
				StringTokenizer tokenizer = new StringTokenizer(path, File.separator);
				String currentPath = pluginPath + File.separator;
				while (tokenizer.hasMoreTokens()) {
					File currentDir = new File(currentPath + tokenizer.nextToken());
					if (!currentDir.exists())
						currentDir.mkdir();
					currentPath = currentPath + currentDir + File.separator;
				}
			}
			// create file if the entry is a file
			if (!contentKey.endsWith("/")) {
				FileOutputStream currentFile =
					new FileOutputStream(pluginPath + File.separator + contentKey);
				transferStreams(inStream, currentFile);
			}

		} catch (IOException e) {
			//FIXME: 
			e.printStackTrace();
		} finally {
			try {
				// close stream
				inStream.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * store Feature files
	 */
	public void storeFeatureInfo(
		VersionedIdentifier featureIdentifier,
		String contentKey,
		InputStream inStream) {
		try {

			// TEST: what if SiteURL is not valid ? 

			File featureSite = new File(getPath() + INSTALL_FEATURE_PATH);
			if (!featureSite.exists()) {
				if (!CREATE_PATH) {
					//FIXME: Serviceability
					throw new IOException("The Path:" + featureSite.toString() + "does not exist.");
				} else {
					//FIXME: Serviceability
					if (!featureSite.mkdirs())
						throw new IOException("Cannot create:" + featureSite.toString());
				}
			}

			// create feature if doesn't exist
			// FIXME: mkdir or mkdirs ?
			String featurePath =
				getPath() + INSTALL_FEATURE_PATH + featureIdentifier.toString();
			File featureDirectory = new File(featurePath);
			if (!featureDirectory.exists()) {
				featureDirectory.mkdir();
			}

			// create directory if doesn't exist
			int lastSeparator = contentKey.lastIndexOf('/');
			if (lastSeparator != -1) {
				String path = contentKey.substring(0, lastSeparator);
				StringTokenizer tokenizer = new StringTokenizer(path, File.separator);
				String currentPath = featurePath + File.separator;
				while (tokenizer.hasMoreTokens()) {
					File currentDir = new File(currentPath + tokenizer.nextToken());
					if (!currentDir.exists())
						currentDir.mkdir();
					currentPath = currentPath + currentDir + File.separator;
				}
			}

			// create file if the entry is a file
			if (!contentKey.endsWith("/")) {
				FileOutputStream currentFile =
					new FileOutputStream(featurePath + File.separator + contentKey);
				transferStreams(inStream, currentFile);
			}

		} catch (IOException e) {
			//FIXME: 
			e.printStackTrace();
		} finally {
			try {
				// close stream
				inStream.close();
			} catch (Exception e) {
			}
		}

	}

}