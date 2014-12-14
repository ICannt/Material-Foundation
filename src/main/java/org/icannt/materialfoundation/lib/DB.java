// Modifed code snippet from Stack Overflow: http://stackoverflow.com/questions/11923294/outputting-debug-information-in-console

package org.icannt.materialfoundation.lib;

public class DB
{
    public static boolean isEnabled()
    {
        return true;
    }
	public static void log(Object o)
	{
	    if(DB.isEnabled())
	    {
	        System.err.println(o.toString());
	    }           
	}
}
