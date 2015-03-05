package io.miti.dbconn.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class JdbcManager {
	
	private static final JdbcManager mgr;
	public List<JdbcInfo> jdbcs;
	
	static {
		mgr = new JdbcManager();
		mgr.jdbcs = new ArrayList<JdbcInfo>(15);
		mgr.init();
	}
	
	private JdbcManager() {
		super();
	}
	
	public static JdbcManager get() {
		return mgr;
	}
	
	public JdbcInfo findByUrl(final String url) {
		
		if ((url == null) || url.isEmpty()) {
			return null;
		}
		
		final int index1 = url.indexOf(':');
		if (index1 < 0) {
			return null;
		}
		final int index2 = url.indexOf(':', index1 + 1);
		final String key = url.substring(index1 + 1, index2);
		
		// Find a matching JDBC constructor
		JdbcInfo row = null;
		for (JdbcInfo info : jdbcs) {
			if (info.getRef().equals(key)) {
				row = info;
				break;
			}
		}
		
		return row;
	}
	
	public boolean loadClassByUrl(final String url) {
		
		boolean result = false;
		JdbcInfo info = findByUrl(url);
		if (info == null) {
			System.out.println("No matching JDBC reference found");
		} else {
			try {
				Class.forName(info.getDriver());
				System.out.println("Loaded driver class " + info.getDriver());
				result = true;
			} catch (ClassNotFoundException e) {
				System.out.println("Error: Cannot find class " + info.getDriver());
			}
		}
		
		return result;
	}
	
	private void init() {
		jdbcs.add(new JdbcInfo("Derby", "derby", "org.apache.derby.jdbc.EmbeddedDriver", "http://db.apache.org/derby/"));
		jdbcs.add(new JdbcInfo("H2", "h2", "org.h2.Driver", "http://h2database.com/"));
		jdbcs.add(new JdbcInfo("MySQL", "mysql", "com.mysql.jdbc.Driver", "http://www.mysql.com/"));
		jdbcs.add(new JdbcInfo("MariaDB", "mariadb", "org.mariadb.jdbc.Driver", "http://mariadb.com/"));
		jdbcs.add(new JdbcInfo("Oracle", "oracle", "oracle.jdbc.OracleDriver", "http://www.oracle.com/"));
		jdbcs.add(new JdbcInfo("Hive", "hive", "org.apache.hadoop.hive.jdbc.HiveDriver", "https://hive.apache.org/"));
		jdbcs.add(new JdbcInfo("Neo4J", "neo4j", "org.neo4j.jdbc.Driver", "http://neo4j.com/"));
		jdbcs.add(new JdbcInfo("PostgreSQL", "postgresql", "org.postgresql.Driver", "http://postgresql.org/"));
		jdbcs.add(new JdbcInfo("DB2", "db2", "com.ibm.db2.jcc.DB2Driver", "http://ibm.com/software/data/db2/"));
		jdbcs.add(new JdbcInfo("Redis", "redis", "br.com.svvs.jdbc.redis.RedisDriver", "http://redis.io/"));
		jdbcs.add(new JdbcInfo("Cassandra", "cassandra", "org.apache.cassandra.cql.jdbc.CassandraDriver", "http://cassandra.apache.org/"));
		jdbcs.add(new JdbcInfo("MongoDB", "mongo", "mongodb.jdbc.MongoDriver", "http://www.mongodb.org/"));
		jdbcs.add(new JdbcInfo("HBase (Phoenix)", "phoenix", "org.apache.phoenix.jdbc.PhoenixDriver", "http://phoenix.apache.org/"));
		jdbcs.add(new JdbcInfo("MS SQL Server", "sqlserver", "com.microsoft.sqlserver.jdbc.SQLServerDriver", "http://www.microsoft.com/SQLServer/"));
		jdbcs.add(new JdbcInfo("SQLite", "sqlite", "org.sqlite.JDBC", "http://sqlite.org/"));
		jdbcs.add(new JdbcInfo("Sybase (jTDS)", "jtds", "net.sourceforge.jtds.jdbc.Driver", "http://jtds.sourceforge.net/"));
		
		Collections.sort(jdbcs);
	}
}
