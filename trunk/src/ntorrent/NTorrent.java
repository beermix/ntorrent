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

package ntorrent;

import java.io.IOException;
import java.net.BindException;

import javax.swing.UIManager;

import ntorrent.io.socket.Client;
import ntorrent.io.socket.Server;
import ntorrent.settings.Constants;

public class NTorrent{
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		//start socket server
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Server s = new Server();
			//start process
			System.out.println(Constants.getLicense());
			s.setController(new Controller(args));
			s.start();
		} catch(BindException e) {
			System.out.println("Server already started");
			//Server already started.
			//connect to existing process
			try {
				new Client(args);
			} catch (IOException x) {
				x.printStackTrace();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
