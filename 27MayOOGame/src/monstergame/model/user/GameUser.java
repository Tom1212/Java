/**
 * 
 */
package monstergame.model.user;

import java.util.StringTokenizer;

/**
 * @author kinfmax
 *
 */
public class GameUser {
	
	private String name;
	private String address;
	private String username;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public GameUser(String name, String address, String username,
			String password) {
		super();
		this.name = name;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public String toString()
	{
		return name + "|" + address + "|" + username + "|" + password;
	}
	
	public static GameUser getUser(String userText)
	{
		StringTokenizer st = new StringTokenizer(userText,"|");
		
		String name = st.nextToken();
		String address = st.nextToken();
		String username = st.nextToken();
		String password = st.nextToken();
		
		return new GameUser(name,address,username,password);
	}
}
