/**
 *
 * @author dulaj
 */
import StockMarket.*;
 
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;
import java.util.*;
 
public class StartClient {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try {
	    ORB orb = ORB.init(args, null);
	    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    StockServer myStockServer = (StockServer) StockServerHelper.narrow(ncRef.resolve_str("ABC"));
 
	    String[] stockSymbols = myStockServer.getStockSymbols();
	    
	    for (int i = 0; i < stockSymbols.length; i++) {
	    	 System.out.println(stockSymbols[i] + " " +
	    			 myStockServer.getStockValue(stockSymbols[i]));
	    }
	    
	    
       }
       catch (Exception e) {
          System.out.println("Hello Client exception: " + e);
	  e.printStackTrace();
       }
 
    }
 
}