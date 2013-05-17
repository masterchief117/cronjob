package stachers.deliverance.transfer.model;

/**
 * Configuration Model for the Dao
 * 
 * @author bstewart
 * 
 */
public class Configuration {

	private long time;
	private String host;
	private String help;

	public Configuration() {
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the help
	 */
	public String getHelp() {
		return help;
	}

	/**
	 * @param help
	 *            the host to help
	 */
	public void setHelp(String help) {
		this.help = help;
	}
}
