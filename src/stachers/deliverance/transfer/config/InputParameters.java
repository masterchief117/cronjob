package stachers.deliverance.transfer.config;

public interface InputParameters {

	/**
	 * String that reads as: Oh no's! Looks like you put in invalid params!! Do
	 * --help for the helps!
	 */
	static String INCORRECT_PARAMETERS = "Oh no's! Looks like you put in invalid params!!"
			+ " Do --help for the helps!";
	/**
	 * String that reads as: Howdie! Lets make some help options together!
	 * either: -host <param> -time <param> or: -host <param> or: -time <param>
	 * -host <param> OPTIONAL param should be the host for your MongoDB! ie
	 * 192.168.0.44 -time <YYYY:MM:DD> OPTIONAL ie: 1941-12-21
	 */
	static String HELP_PARAMETERS = "Howdie! Lets make some help options together!\n"
			+ "either: -host <param> -time <param>\n"
			+ "or: -host <param>\n"
			+ "or: -time <param>\n"
			+ "-host <param>  OPTIONAL param should be the host for your MongoDB! ie 192.168.0.44\n"
			+ "-time <YYYY:MM:DD> OPTIONAL ie: 1941-12-21";
	/**
	 * String that reads as: You must have your -time parameter in YYYY-MM-DD
	 * format!
	 */
	static String INCORRECT_DATE_FORMAT = "You must have your -time parameter in YYYY-MM-DD format!";

	static String DEFAULT_SERVER_ADDRESS = "192.168.0.44";

	static String ORACLE_SERVER = "jdbc:oracle:thin:@192.168.0.44:1521:MongoDemo";
	static String ORACLE_USERNAME = "oe";
	static String ORACLE_PASSWORD = "oe";
}
