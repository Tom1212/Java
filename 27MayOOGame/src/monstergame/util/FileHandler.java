/**
 * This class handles all the file related operation
 */
package monstergame.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import monstergame.model.user.GameUser;

/**
 * @author kinfmax
 *
 */
public class FileHandler {
	
	public static String filename = "user_info.txt";
	
	public static void save(GameUser user)
	{
		try{
			
			File f = new File(filename);
			FileWriter fw;
			
			if (f.exists()  && !f.isDirectory())
			{
				fw = new FileWriter(filename,true);
			}
			else
			{
				fw = new FileWriter(filename);
			}
			
			fw.write(user.toString() + System.lineSeparator());
			
			fw.close();	
			
		}catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public static ArrayList<GameUser> load()
	{
//		Hashtable<String, GameUser> data = new Hashtable<String, GameUser>();
		ArrayList<GameUser> data = new ArrayList<GameUser>();
		
		File f = new File(filename);
		try {
			Scanner sc;
			if (f.exists() && !f.isDirectory())
			{
				sc = new Scanner(f);
				while(sc.hasNextLine())
				{
					GameUser user = GameUser.getUser(sc.nextLine()); // design pattern, factory pattern
//					data.put(user.getUsername(), user);
					data.add(user);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return data;
	}

}
