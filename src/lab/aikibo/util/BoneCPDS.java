package lab.aikibo.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.cfg.Configuration;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class BoneCPDS {
	
	private BoneCP cp;
	private Connection connection;
	private Configuration hibernateConf;
	
	public Connection getBoneCPConn() {
		cp = null;
		connection = null;
		
		try {
			// load database driver (make sure this is in your classpath!)
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			BoneCPConfig config = new BoneCPConfig();
			hibernateConf = new Configuration();
			hibernateConf.configure();
			config.setJdbcUrl(hibernateConf.getProperty("connection.url"));
			config.setUsername(hibernateConf.getProperty("connection.user"));
			config.setPassword(hibernateConf.getProperty("connection.password"));
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(2);
			config.setStatementsCacheSize(500000);
			cp = new BoneCP(config);
			connection = cp.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

}
