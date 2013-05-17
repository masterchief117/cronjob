package stachers.deliverance.transfer.main;

import stachers.deliverance.transfer.config.InputParameters;
import stachers.deliverance.transfer.service.TransferService;

public class ExecuteTransfer implements InputParameters {
	/**
	 * main method. Input parameters. Searches for --help, -host, -time
	 * 
	 * @param userArgs
	 */
	public static void main(String[] userArgs) {
		System.out.println(TransferService.performTransfer(userArgs));
	}
}
