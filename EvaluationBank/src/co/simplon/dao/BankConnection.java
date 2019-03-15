package  co.simplon.dao ;
import  java.io.FileInputStream ;
import  java.io.FileNotFoundException ;
import  java.io.IOException ;
import  java.sql.Connection ;
import  java.sql.DriverManager ;
import java.sql.SQLException;
import  java.sql.Statement ;
import  java.util.Properties ;

 public class BankConnection {
	 private static Connection connection =  null ;	
	
	  private BankConnection () {		
		Properties props =  new  Properties ();		
		try ( FileInputStream fis =  new  FileInputStream ( " conf.propertie" )) {
			props.load (fis);
		} catch ( FileNotFoundException e1) {			
			e1 . printStackTrace ();
		} catch ( IOException e1) {			
			e1 . printStackTrace ();
		}		
		String url = props . getProperty ( " db.url " );
		String user = props . getProperty ( " db.user " );
		String pwd = props . getProperty ( " db.passwd " );
		
		try {
			Class . forName (props . getProperty ( " jdbc.driver.class " ));
			connection =  DriverManager . getConnection (url, user, pwd);
			Statement statement = connection . createStatement ();
			statement . executeQuery ( " créer une base de données s'il n'existe pas de banque; " );
			statement . executeQuery ( " use Bank; " );
		} catch ( ClassNotFoundException e) {
			e . printStackTrace ();
		} 				
		catch ( SQLException e) {
			e.printStackTrace();
		} 
	}
	
	   public static Connection getConnection () { 
		if (connection ==  null ) {
			new  BankConnection ();
		}
		return connection ;
	}
}