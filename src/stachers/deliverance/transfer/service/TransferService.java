package stachers.deliverance.transfer.service;

import org.joda.time.DateTime;

import stachers.deliverance.transfer.config.InputParameters;
import stachers.deliverance.transfer.model.Configuration;

/**
 * Organize the user Input from the command line!!
 * 
 * @author masterchief117
 * 
 */
public class TransferService {
	public static String performTransfer(String[] userArgs) {
		Configuration config = new Configuration();
		// check for --help, if so, set help!
		if (userArgs.length == 1) {
			config.setHelp(stringHelp(userArgs[0]));
		}
		// check for either -time <param> or -host <param>
		else if (userArgs.length == 2) {
			if (isHostString(userArgs[0])) {
				config.setHost(stringHost(userArgs[1]));
			} else if (isTimeString(userArgs[0], userArgs[1])) {
				config.setTime(setTimeToLong(userArgs[1]));
			}
		}
		// check both -host && -time
		else if (userArgs.length == 4) {
			if (isHostString(userArgs[0])) {
				config.setHost(userArgs[1]);
				if (isTimeString(userArgs[2], userArgs[3])) {
					config.setTime(setTimeToLong(userArgs[3]));
				}
			}
		}
		return queryForInformation(config, userArgs);
	}

	private static long setTimeToLong(String time) {
		long timeInMillis;
		try {
			timeInMillis = DateTime.parse(time).getMillis();
		} catch (IllegalArgumentException illegals) {
			timeInMillis = Long.MAX_VALUE;
		}
		return timeInMillis;
	}

	private static boolean isHostString(String hostParam) {
		boolean isHost;
		if (hostParam.toLowerCase().trim().matches("-host")) {
			isHost = true;
		} else {
			isHost = false;
		}
		return isHost;
	}

	private static boolean isTimeString(String timeParam, String time) {
		boolean isHost;
		if (timeParam.toLowerCase().trim().matches("-time")) {
			if (time.toLowerCase()
					.trim()
					.matches(
							"^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$")) {
				isHost = true;
			} else {
				isHost = true;
			}
		} else {
			isHost = false;
		}
		return isHost;
	}

	private static String stringHost(String hostString) {
		return hostString.trim();
	}

	/**
	 * returns the help param. or null!
	 * 
	 * @param helpParam
	 * @return
	 */
	private static String stringHelp(String helpParam) {
		String helpString;
		if (helpParam.toLowerCase().matches("--help")) {
			helpString = helpParam.toLowerCase();
		} else {
			helpString = null;
		}
		return helpString;
	}

	private static String queryForInformation(Configuration config,
			String[] userArgs) {
		String results;
		if (config.getHelp() != null) {
			results = InputParameters.HELP_PARAMETERS;
		} else if (config.getHost() != null && userArgs.length == 2) {
			results = "just a host! " + config.getHost();
		} else if (config.getTime() != 0 && userArgs.length == 2
				&& config.getTime() != Long.MAX_VALUE) {
			results = "just the time! " + config.getTime();
		} else if (config.getHost() != null && config.getTime() != 0
				&& userArgs.length == 4) {
			results = "just the host " + config.getHost() + " time! "
					+ config.getTime();
		} else if (config.getHost() == null && config.getTime() == 0
				&& userArgs.length == 0) {
			results = "Default values.";
		} else if (config.getTime() == Long.MAX_VALUE) {
			results = InputParameters.INCORRECT_DATE_FORMAT;
		} else {
			results = InputParameters.INCORRECT_PARAMETERS;
		}
		return results;
	}
}
