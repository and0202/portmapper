package org.chris.portmapper.gui;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import org.chris.portmapper.PortMapperApp;
import org.chris.portmapper.model.PortMapping;

/**
 * @author chris
 * @version $Id$
 */
public class PortMappingsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private final ArrayList<PortMapping> mappings;

	public PortMappingsTableModel() {
		super();
		this.mappings = new ArrayList<PortMapping>();
	}

	public void setMappings(Collection<PortMapping> mappings) {
		this.mappings.clear();
		this.mappings.addAll(mappings);
		super.fireTableDataChanged();
	}

	public int getColumnCount() {
		return 6;
	}

	public int getRowCount() {
		return mappings.size();
	}

	public PortMapping getPortMapping(int index) {
		return mappings.get(index);
	}

	public Object getValueAt(int row, int col) {
		final PortMapping mapping = mappings.get(row);
		switch (col) {
		case 0:
			return mapping.getProtocol();
		case 1:
			return (mapping.getRemoteHost() != null ? mapping.getRemoteHost()
					: ""); //$NON-NLS-1$
		case 2:
			return mapping.getExternalPort();
		case 3:
			return mapping.getInternalClient();
		case 4:
			return mapping.getInternalPort();
		case 5:
			return mapping.getDescription();
		default:
			throw new IllegalArgumentException("Column " + col //$NON-NLS-1$
					+ " does not exist"); //$NON-NLS-1$
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return PortMapperApp.getResourceMap().getString(
					"mainFrame.mappings.protocol"); //$NON-NLS-1$
		case 1:
			return PortMapperApp.getResourceMap().getString(
					"mainFrame.mappings.remote_host"); //$NON-NLS-1$
		case 2:
			return PortMapperApp.getResourceMap().getString(
					"mainFrame.mappings.external_port"); //$NON-NLS-1$
		case 3:
			return PortMapperApp.getResourceMap().getString(
					"mainFrame.mappings.internal_client"); //$NON-NLS-1$
		case 4:
			return PortMapperApp.getResourceMap().getString(
					"mainFrame.mappings.internal_port"); //$NON-NLS-1$
		case 5:
			return PortMapperApp.getResourceMap().getString(
					"mainFrame.mappings.description"); //$NON-NLS-1$
		default:
			throw new IllegalArgumentException("Column " + col //$NON-NLS-1$
					+ " does not exist"); //$NON-NLS-1$
		}
	}
}
