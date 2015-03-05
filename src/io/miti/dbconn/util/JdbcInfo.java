package io.miti.dbconn.util;

public final class JdbcInfo implements Comparable<JdbcInfo> {
	
	private String name = null;
	private String ref = null;
	private String driver = null;
	private String web = null;
	
	public JdbcInfo() {
		super();
	}
	
	public JdbcInfo(String name, String ref, String driver, String web) {
		super();
		this.name = name;
		this.ref = ref;
		this.driver = driver;
		this.web = web;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Override
	public int compareTo(JdbcInfo o) {
		return name.compareTo(o.name);
	}
}
