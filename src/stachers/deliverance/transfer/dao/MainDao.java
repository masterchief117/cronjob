package stachers.deliverance.transfer.dao;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

import stachers.deliverance.transfer.config.InputParameters;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class MainDao {

	private MongoClient mongoClient;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private DB db;
	private DBCollection collection;
	private GridFS gridFS;
	private GridFSInputFile gridFSInputFile;

	private long time;

	/**
	 * No-Argument constructor. Sets the MongoClient to default host. Also does
	 * not use time as a feature.
	 * 
	 * @throws UnknownHostException
	 *             catch if you don't want it to crashes!
	 * @throws SQLException
	 */
	public MainDao() throws UnknownHostException, SQLException {
		setupDriver();

		setDefaultHost();
	}

	/**
	 * Time constructor. Sets the MongoClient to default host. Uses the time as
	 * a "nothing before this date" on SQL grab from RDMS.
	 * 
	 * @param time
	 * @throws SQLException
	 */
	public MainDao(long time) throws UnknownHostException, SQLException {
		setupDriver();
		this.time = time;
	}

	/**
	 * Host constructor. Sets the Mongo client host to be of specific value.
	 * 
	 * @param host
	 *            ie "192.168.0.44" or "Brents-VirtualBox"
	 */
	public MainDao(String host) throws UnknownHostException, SQLException {
		setupDriver();
	}

	/**
	 * Host and Time constructor. Sets the MongoClient host to be of specific
	 * value. Uses the time as a "nothing before this date" on SQL grab from
	 * RDMS.
	 * 
	 * @param host
	 * 
	 * @param time
	 */
	public MainDao(String host, long time) throws UnknownHostException,
			SQLException {
		setupDriver();
	}

	/**
	 * 
	 * 
	 * @throws UnknownHostException
	 *             catch if you don't want it to crashes!
	 */
	private void setDefaultHost() throws UnknownHostException {
		mongoClient = new MongoClient(new ServerAddress(
				InputParameters.DEFAULT_SERVER_ADDRESS));
	}

	/**
	 * Sets the DriverManager
	 * 
	 * @throws SQLException
	 */
	private void registerDriver() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
	}

	/**
	 * Set the Connection
	 * 
	 * @throws SQLException
	 */
	private void setConnection() throws SQLException {
		this.connection = DriverManager.getConnection(
				InputParameters.ORACLE_SERVER, InputParameters.ORACLE_USERNAME,
				InputParameters.ORACLE_PASSWORD);
	}

	private void setupDriver() throws SQLException {
		registerDriver();
		setConnection();
	}

	private void closeOracle() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
