/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.update.internal.ui;

import java.io.*;
import java.net.*;

import org.eclipse.core.internal.boot.*;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.resource.*;
import org.eclipse.swt.graphics.*;

/**
 * Bundle of all images used by the PDE plugin.
 */
public class UpdateUIImages {


	private static final String NAME_PREFIX= UpdateUI.getPluginId()+"."; //$NON-NLS-1$

	private final static URL BASE_URL = UpdateUI.getDefault().getDescriptor().getInstallURL();


	private static ImageRegistry PLUGIN_REGISTRY;
	
	public final static String ICONS_PATH = "icons/full/"; //$NON-NLS-1$

	/**
	 * Set of predefined Image Descriptors.
	 */
	
	private static final String PATH_OBJ= ICONS_PATH+"obj16/"; //$NON-NLS-1$
	private static final String PATH_VIEW = ICONS_PATH+"cview16/"; //$NON-NLS-1$
	private static final String PATH_LCL= ICONS_PATH+"elcl16/"; //$NON-NLS-1$
	private static final String PATH_LCL_HOVER= ICONS_PATH+"clcl16/"; //$NON-NLS-1$
	private static final String PATH_LCL_DISABLED= ICONS_PATH+"dlcl16/"; //$NON-NLS-1$
	private static final String PATH_OVR = ICONS_PATH + "ovr16/"; //$NON-NLS-1$
	private static final String PATH_WIZBAN = ICONS_PATH + "wizban/"; //$NON-NLS-1$
	public static final String PATH_FORMS = ICONS_PATH + "forms/"; //$NON-NLS-1$


	/**
	 * Frequently used images
	 */
	public static final String IMG_FORM_BANNER = NAME_PREFIX+"FORM_BANNER"; //$NON-NLS-1$
	public static final String IMG_FORM_BANNER_SHORT = NAME_PREFIX+"FORM_BANNER_SHORT"; //$NON-NLS-1$
	public static final String IMG_FORM_UNDERLINE = NAME_PREFIX + "FORM_UNDERLINE"; //$NON-NLS-1$

	/**
	 * OBJ16
	 */
	public static final ImageDescriptor DESC_APP_OBJ = create(PATH_OBJ, "app_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_BFOLDER_OBJ = create(PATH_OBJ, "bfolder_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_CATEGORY_OBJ = create(PATH_OBJ, "category_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_CD_OBJ = create(PATH_OBJ, "cd_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_COMPUTER_OBJ = create(PATH_OBJ, "computer_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_CONFIG_OBJ = create(PATH_OBJ, "config_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_FEATURE_OBJ = create(PATH_OBJ, "feature_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_EFIX_OBJ = create(PATH_OBJ, "efix2_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_FLOPPY_OBJ = create(PATH_OBJ, "floppy_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_HISTORY_OBJ = create(PATH_OBJ, "history_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_LSITE_OBJ = create(PATH_OBJ, "lsite_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_PSITE_OBJ = create(PATH_OBJ, "psite_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ESITE_OBJ = create(PATH_OBJ, "esite_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SITE_OBJ = create(PATH_OBJ, "site_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_WEB_SITE_OBJ = create(PATH_OBJ, "web_bkmrk_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_PLACES_OBJ = create(PATH_OBJ, "places_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SAVED_OBJ = create(PATH_OBJ, "saved_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_UNCONF_FEATURE_OBJ = create(PATH_OBJ, "unconf_feature_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_UPDATES_OBJ = create(PATH_OBJ, "updates_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_VFIXED_OBJ = create(PATH_OBJ, "vfixed_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_VREMOTE_OBJ = create(PATH_OBJ, "vremote_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_VREMOVABLE_OBJ = create(PATH_OBJ, "vremovable_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_NOTINST_FEATURE_OBJ = create(PATH_OBJ, "notinstalled_feature_obj.gif");	 //$NON-NLS-1$
	public static final ImageDescriptor DESC_SHOW_SEARCH = create(PATH_OBJ, "tsearch_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ERR_ST_OBJ = create(PATH_OBJ, "error_st_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_OK_ST_OBJ = create(PATH_OBJ, "ok_st_obj.gif"); //$NON-NLS-1$

	
	/**
	 * OVR16
	 */
	public static final ImageDescriptor DESC_LINKED_CO   = create(PATH_OVR, "linked_co.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_UPDATED_CO   = create(PATH_OVR, "updated_co.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_INSTALLABLE_CO = create(PATH_OVR, "installable_co.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_CURRENT_CO = create(PATH_OVR, "current_co.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ERROR_CO = create(PATH_OVR, "error_co.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_WARNING_CO = create(PATH_OVR, "warning_co.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MOD_CO = create(PATH_OVR, "mod_co.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ADD_CO = create(PATH_OVR, "add_stat.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_DEL_CO = create(PATH_OVR, "del_stat.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_UNCONF_CO = create(PATH_OVR, "unconfigured_co.gif"); //$NON-NLS-1$

	/**
	 * VIEW16
	 */

	public static final ImageDescriptor DESC_CONFIGS_VIEW = create(PATH_VIEW, "configs.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SITES_VIEW = create(PATH_VIEW, "updates.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SELECTED_UPDATES_VIEW = create(PATH_VIEW, "selected_updates.gif"); //$NON-NLS-1$

	/**
	 * LCL
	 */
	public static final ImageDescriptor DESC_BACKWARD_NAV = create(PATH_LCL, "backward_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_BACKWARD_NAV_H = create(PATH_LCL_HOVER, "backward_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_BACKWARD_NAV_D = create(PATH_LCL_DISABLED, "backward_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_FORWARD_NAV = create(PATH_LCL, "forward_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_FORWARD_NAV_H = create(PATH_LCL_HOVER, "forward_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_FORWARD_NAV_D = create(PATH_LCL_DISABLED, "forward_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_HOME_NAV = create(PATH_LCL, "home_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_HOME_NAV_H = create(PATH_LCL_HOVER, "home_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_HOME_NAV_D = create(PATH_LCL_DISABLED, "home_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_REFRESH_NAV = create(PATH_LCL, "refresh_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_REFRESH_NAV_H = create(PATH_LCL_HOVER, "refresh_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_REFRESH_NAV_D = create(PATH_LCL_DISABLED, "refresh_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_STOP_NAV = create(PATH_LCL, "stop_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_STOP_NAV_H = create(PATH_LCL_HOVER, "stop_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_STOP_NAV_D = create(PATH_LCL_DISABLED, "stop_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_GO_NAV = create(PATH_LCL, "go_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_GO_NAV_H = create(PATH_LCL_HOVER, "go_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_GO_NAV_D = create(PATH_LCL_DISABLED, "go_nav.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SHOW_UNCONF = create(PATH_LCL, "show_unconf.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SHOW_UNCONF_H = create(PATH_LCL_HOVER, "show_unconf.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SHOW_UNCONF_D = create(PATH_LCL_DISABLED, "show_unconf.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_COLLAPSE_ALL = create(PATH_LCL, "collapseall.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SHOW_HIERARCHY = create(PATH_LCL, "hierarchicalLayout.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SHOW_HIERARCHY_H = create(PATH_LCL_HOVER, "hierarchicalLayout.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SHOW_HIERARCHY_D = create(PATH_LCL_DISABLED, "hierarchicalLayout.gif"); //$NON-NLS-1$

	/**
	 * WIZ
	 */
	public static final ImageDescriptor DESC_INSTALL_WIZ  = create(PATH_WIZBAN, "install_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_UPDATE_WIZ  = create(PATH_WIZBAN, "update_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_CONFIG_WIZ  = create(PATH_WIZBAN, "config_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_UNINSTALL_WIZ  = create(PATH_WIZBAN, "uninstall_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_INSTALL_BANNER  = create(PATH_WIZBAN, "def_wizban.jpg"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_FORM_BANNER  = create(PATH_FORMS, "form_banner.jpg"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_FORM_BANNER_SHORT  = create(PATH_FORMS, "form_banner.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_FORM_UNDERLINE  = create(PATH_FORMS, "form_underline.jpg"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_PROVIDER = create(PATH_FORMS, "def_provider.jpg"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ITEM = create(PATH_FORMS, "topic.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_NEW_BOOKMARK  = create(PATH_WIZBAN, "new_bookmark_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_NEW_FOLDER  = create(PATH_WIZBAN, "new_folder_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_NEW_SEARCH  = create(PATH_WIZBAN, "new_search_wiz.gif"); //$NON-NLS-1$

	private static ImageDescriptor create(String prefix, String name) {
		return ImageDescriptor.createFromURL(makeImageURL(prefix, name));
	}


	public static Image get(String key) {
		if (PLUGIN_REGISTRY==null) initialize();
		return PLUGIN_REGISTRY.get(key);
	}


public static ImageDescriptor getImageDescriptorFromPlugin(
	IPluginDescriptor pluginDescriptor, 
	String subdirectoryAndFilename) {
	URL installURL = pluginDescriptor.getInstallURL();
	try {
		URL newURL = new URL(installURL, subdirectoryAndFilename);
		return ImageDescriptor.createFromURL(newURL);
	}
	catch (MalformedURLException e) {
	}
	return null;
}


public static Image getImageFromPlugin(
	IPluginDescriptor pluginDescriptor,
	String subdirectoryAndFilename) {
	URL installURL = pluginDescriptor.getInstallURL();
	Image image = null;
	try {
		URL newURL = new URL(installURL, subdirectoryAndFilename);
		String key = newURL.toString();
		if (PLUGIN_REGISTRY==null) initialize();
		image = PLUGIN_REGISTRY.get(key);
		if (image==null) {
			ImageDescriptor desc = ImageDescriptor.createFromURL(newURL);
			image = desc.createImage();
			PLUGIN_REGISTRY.put(key, image);
		}
	}
	catch (MalformedURLException e) {
	}
	return image;
}
/* package */
private static final void initialize() {
	PLUGIN_REGISTRY = new ImageRegistry();
	manage(IMG_FORM_BANNER_SHORT, DESC_FORM_BANNER_SHORT);
	manage(IMG_FORM_BANNER, DESC_FORM_BANNER);
	manage(IMG_FORM_UNDERLINE, DESC_FORM_UNDERLINE);
}


private static URL makeImageURL(String prefix, String name) {
	String path = prefix + name;
	URL url = null;
	try {
		url = new URL(BASE_URL, path);
	}
	catch (MalformedURLException e) {
		return null;
	}
	return url;
}

public static Image manage(String key, ImageDescriptor desc) {
	Image image = desc.createImage();
	PLUGIN_REGISTRY.put(key, image);
	return image;
}

public static URL getDefaultProviderImageURL() {
	URL url = makeImageURL(PATH_FORMS, "def_provider.jpg"); //$NON-NLS-1$
	try {
		url = InternalBootLoader.resolve(url);
	}
	catch (IOException e) {
	}
	return url; 
}

}
