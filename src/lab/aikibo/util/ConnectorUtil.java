package lab.aikibo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ConnectorUtil {  
	
	private AnnotationConfiguration config;
	private SessionFactory sf;
	
	public ConnectorUtil() {
		init();
	}
	
	private void init() {
		config = new AnnotationConfiguration();
		config.configure();
		String username = config.getProperty("connection.username");
		System.out.println("User " + username);
		sf = config.configure().buildSessionFactory();
		username = config.getProperty("connection.username");
		System.out.println("User " + username);
	}
	
	public SessionFactory getSF() {
		return sf;
	}

}
