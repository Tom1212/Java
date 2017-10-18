/**
 * 
 */
package monstergame.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author kinfmax
 *
 */
public class HTMLTabler {

	private final String HEAD = "<html> <table border='0'>";
	private ArrayList<TH> ths = new ArrayList<TH>();
	private ArrayList<TR> trs = new ArrayList<TR>();
	
	private final String TAIL = "</table></html>";
	
	private int col;
	
	public HTMLTabler()
	{
		
	}
	
	public HTMLTabler(int num)
	{
		this.col = num;
	}
	
	public String out()
	{
		String str = HEAD;
		str += "<tr>";
		for (TH th : ths)
		{
			str += th.out();
		}
		str += "</tr>";
		for (TR tr : trs)
		{
			str += tr.out();
		}
		
		str += TAIL;
		return str;
	}
	
	public void addTH(String strByPipeLine)
	{
		StringTokenizer st = new StringTokenizer(strByPipeLine,"|");
		while(st.hasMoreElements())
		{
			ths.add(new TH(st.nextToken()));
		}
	}
	
	public void addTR(String strByPipeLine)
	{
		StringTokenizer st = new StringTokenizer(strByPipeLine,"|");
		TR tr = new TR();
		while(st.hasMoreElements())
		{
			tr.addTD(st.nextToken());
		}
		this.trs.add(tr);
	}
	
	public static void main(String[] args)
	{
		HTMLTabler tablers = new HTMLTabler();
		
		tablers.addTH("Index|Name|Score");
		tablers.addTR("1|Kinfmax|100");
		tablers.addTR("2|John|99");
		
		System.out.println(tablers.out());
	}
	
}

class TR{ //for table row
	private ArrayList<TD> tds = new ArrayList<TD>();
	
	private String prefix = "<tr>";
	private String suffix = "</tr>";
	
	public String out()
	{
		String str = this.prefix;
		for (TD td : tds)
		{
			str += td.out();
		}
		str += this.suffix;
		return str;
	}
	
	public void addTD(String data)
	{
		tds.add(new TD(data));
	}
	
	
}

class TH{ //for table header
	private String prefix = "<th>";
	private String suffix = "</th>";
	private String data;
	
	public TH(String data)
	{
		this.data = data;
	}
	
	public String out()
	{
		String str = this.prefix;
		str += this.data;
		str += this.suffix;
		return str;
	}
}

class TD{ //for table data
	private String prefix = "<td>";
	private String suffix = "</td>";
	private String data;
	
	public TD(String data)
	{
		this.data = data;
	}
	
	public String out()
	{
		String str = this.prefix;
		str += this.data;
		str += this.suffix;
		return str;
	}
}
