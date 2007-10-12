/**
 *   nTorrent - A GUI client to administer a rtorrent process 
 *   over a network connection.
 *   
 *   Copyright (C) 2007  Kim Eik
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.heldig.ntorrent.gui;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.heldig.ntorrent.event.ControllerEventListener;
import org.heldig.ntorrent.gui.file.FileList;
import org.heldig.ntorrent.gui.file.InfoPanel;
import org.heldig.ntorrent.gui.file.TrackerList;
import org.heldig.ntorrent.io.ErrorStream;
import org.heldig.ntorrent.language.Language;


/**
 * @author  Kim Eik
 */
public class FileTabComponent {
	JTabbedPane filePane = new JTabbedPane();
	InfoPanel infoPanel = new InfoPanel();
	JScrollPane logPane = new JScrollPane();
	TrackerList trackerList;
	FileList fileList;

	
	public FileTabComponent(ControllerEventListener e){
		fileList = new FileList(e);
		trackerList = new TrackerList(e);
		//filePane.addTab("peer list", new JLabel("not supported by rtorrent"));
		filePane.addTab(Language.Filetab_info.toString(), infoPanel.getInfoPanel());
		filePane.addTab(Language.Filetab_file_list.toString(), fileList.getFileList());
		filePane.addTab(Language.Filetab_tracker_list.toString(), trackerList.getTrackerlist());
		filePane.addTab(Language.Filetab_log.toString(),logPane);
		filePane.setSelectedIndex(3);
		//filePane.addTab("chunk list", new JLabel("not supported by rtorrent"));
		//filePane.addTab("chunks seen", new JLabel("not supported by rtorrent"));
		filePane.setVisible(true);
	}
	
	public void setLog(ErrorStream c){
		System.out.println(c);
		logPane.add(c.getTextArea());
	}
	
	/**
	 * @return
	 */
	public JTabbedPane getFilePane() {
		return filePane;
	}
	
	/**
	 * @return
	 */
	public InfoPanel getInfoPanel() {
		return infoPanel;
	}
	
	/**
	 * @return
	 */
	public FileList getFileList() {
		return fileList;
	}
	
	public TrackerList getTrackerList(String hash) {
		trackerList.setHash(hash);
		return trackerList;
	}
}