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
package org.eclipse.update.internal.ui.wizards;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.help.*;
import org.eclipse.update.core.*;
import org.eclipse.update.internal.ui.*;
import org.eclipse.update.operations.*;

public class LicensePage extends WizardPage implements IDynamicPage {
	private static final String KEY_TITLE = "InstallWizard.LicensePage.title"; //$NON-NLS-1$
	private static final String KEY_DESC = "InstallWizard.LicensePage.desc"; //$NON-NLS-1$
	private static final String KEY_DESC2 = "InstallWizard.LicensePage.desc2"; //$NON-NLS-1$
	private static final String KEY_ACCEPT = "InstallWizard.LicensePage.accept"; //$NON-NLS-1$
	private static final String KEY_DECLINE = "InstallWizard.LicensePage.decline"; //$NON-NLS-1$
	private static final String KEY_ACCEPT2 = "InstallWizard.LicensePage.accept2"; //$NON-NLS-1$
	private static final String KEY_DECLINE2 = "InstallWizard.LicensePage.decline2"; //$NON-NLS-1$
	private boolean multiLicenseMode = false;
	private IInstallFeatureOperation[] jobs;
	private Text text;
	private Table table;

	/**
	 * Constructor for LicensePage2
	 */
	public LicensePage(boolean multiLicenseMode) {
		super("License"); //$NON-NLS-1$
		setTitle(UpdateUI.getString(KEY_TITLE));
		setPageComplete(false);
		this.multiLicenseMode = multiLicenseMode;
		UpdateUI.getDefault().getLabelProvider().connect(this);
		setDescription(
			UpdateUI.getString(
				multiLicenseMode ? KEY_DESC2 : KEY_DESC));
	}
	public void dispose() {
		UpdateUI.getDefault().getLabelProvider().disconnect(this);
		super.dispose();
	}

	public LicensePage(IInstallFeatureOperation job) {
		this(false);
		setJobs(new IInstallFeatureOperation[] { job });
	}

	public void setJobs(IInstallFeatureOperation[] jobs) {
		this.jobs = jobs;
	}

	/**
	 * @see DialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite client = new Composite(parent, SWT.NULL);
		client.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		client.setLayout(layout);
		
		WorkbenchHelp.setHelp(client, "org.eclipse.update.ui.LicensePage2"); //$NON-NLS-1$

		if (multiLicenseMode) {
			layout.numColumns = 3;
			layout.makeColumnsEqualWidth = true;

			table = new Table(client, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);

			table.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					if (e.item != null) {
						Object data = e.item.getData();
						text.setText((data == null) ? "" : (String) data); //$NON-NLS-1$
					}
				}
			});
			table.setLayoutData(new GridData(GridData.FILL_BOTH));
		}
		text =
			new Text(
				client,
				SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.READ_ONLY);

		GridData gd = new GridData(GridData.FILL_BOTH);
		if (multiLicenseMode)
			gd.horizontalSpan = 2;
		text.setLayoutData(gd);
		text.setBackground(text.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));

		Composite buttonContainer = new Composite(client, SWT.NULL);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		if (multiLicenseMode)
			gd.horizontalSpan = 3;
		buttonContainer.setLayout(new GridLayout());
		buttonContainer.setLayoutData(gd);

		final Button acceptButton = new Button(buttonContainer, SWT.RADIO);
		acceptButton.setText(
			UpdateUI.getString(multiLicenseMode ? KEY_ACCEPT2 : KEY_ACCEPT));
		acceptButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(acceptButton.getSelection());
			}
		});
		Button declineButton = new Button(buttonContainer, SWT.RADIO);
		declineButton.setText(
			UpdateUI.getString(multiLicenseMode ? KEY_DECLINE2 : KEY_DECLINE));
		declineButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(acceptButton.getSelection());
			}
		});
		setControl(client);
		
		Dialog.applyDialogFont(parent);
	}

	public void setVisible(boolean visible) { // TO DO: Optimize out the case where a feature does not have a license?
		if (visible) {
			if (multiLicenseMode) {
				TableItem item;
				for (int i = 0; i < jobs.length; i++) {
					IFeature feature = jobs[i].getFeature();
					item = new TableItem(table, SWT.NONE);
					String label =
						feature.getLabel()
							+ " " //$NON-NLS-1$
							+ feature.getVersionedIdentifier().getVersion().toString();
					item.setText(label);
					item.setImage(
						UpdateUI.getDefault().getLabelProvider().get(
							feature.isPatch()
								? UpdateUIImages.DESC_EFIX_OBJ
								: UpdateUIImages.DESC_FEATURE_OBJ));
					String license = feature.getLicense().getAnnotation();
					// Question: Can this ever be null? What is the runtime cost?
					item.setData(license);
				}

				table.setSelection(0);
			}
			showLicenseText();
		} else {
			if (multiLicenseMode) {
				TableItem items[] = table.getItems();
				for (int i = items.length - 1; i >= 0; i--) {
					table.getItem(i).dispose();
				}
			}
		}
		super.setVisible(visible);
	}

	private void showLicenseText() {
		if (!multiLicenseMode) {
			text.setText(jobs[0].getFeature().getLicense().getAnnotation());
			return;
		}
		TableItem[] selectedItems = table.getSelection();
		if (selectedItems.length == 0) {
			text.setText(""); //$NON-NLS-1$
		} else {
			Object data = selectedItems[0].getData();
			text.setText((data == null) ? "" : (String) data); //$NON-NLS-1$
		}
	}
}
