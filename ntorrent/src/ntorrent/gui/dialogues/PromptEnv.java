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

package ntorrent.gui.dialogues;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PromptEnv {
	private JFrame window = new JFrame();
	private JTextField host = new JTextField();
	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();

	public PromptEnv(ActionListener listener) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setAlwaysOnTop(true);
		Dimension textsize = new Dimension(220,20);
		GridLayout layout = new GridLayout(0,1);
		window.setPreferredSize(new Dimension(320,180));
		Container c = window.getContentPane();
		c.setLayout(layout);
		JLabel hostlabel = new JLabel("host:port/rpc_mountpoint");
		c.add(hostlabel);
		host.setPreferredSize(textsize);
		host.setText("http://");
		c.add(host);
		JLabel userlabel = new JLabel("username");
		c.add(userlabel);
		username.setPreferredSize(textsize);
		c.add(username);
		JLabel passlabel = new JLabel("password");
		c.add(passlabel);
		c.add(password);
		JButton ok = new JButton("OK!");
		ok.addActionListener(listener);
		c.add(ok);
		
		window.setVisible(true);
		window.pack();
		window.validate();
	}
	
	public void closeWindow(){
		window.setVisible(false);
	}
	
	public JFrame getWindow() {
		return window;
	}
	
	public String getHost() {
		return host.getText();
	}
	
	public String getUsername() {
		return username.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return password.getText();
	}
}
