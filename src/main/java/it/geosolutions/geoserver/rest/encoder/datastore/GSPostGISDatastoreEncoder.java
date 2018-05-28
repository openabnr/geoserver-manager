/*
 *  GeoServer-Manager - Simple Manager Library for GeoServer
 *
 *  Copyright (C) 2007,2012 GeoSolutions S.A.S.
 *  http://www.geo-solutions.it
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package it.geosolutions.geoserver.rest.encoder.datastore;

import it.geosolutions.geoserver.rest.decoder.RESTDataStore;

/**
 * Encoder for a {@value #TYPE} datastore.
 *
 * @author Eric Grosso
 * @author ETj
 * @author Carlo Cancellieri - carlo.cancellieri@geo-solutions.it
 * @author Oscar Fonts
 */
public class GSPostGISDatastoreEncoder extends GSAbstractDatastoreEncoder {

	static final String TYPE = "PostGIS";

	static final String DEFAULT_DB_TYPE = "postgis";
	static final int DEFAULT_MIN_CONNECTIONS = 1;
	static final int DEFAULT_MAX_CONNECTIONS = 10;
	static final int DEFAULT_FETCH_SIZE = 1000;
	static final int DEFAULT_CONNECTION_TIMEOUT = 20;
	static final boolean DEFAULT_LOOSE_BBOX = true;
	static final boolean DEFAULT_PREPARED_STATEMENTS = true;
	static final int DEFAULT_MAX_OPEN_PREPARED_STATEMENTS = 50;
	static final boolean DEFAULT_ESTIMATED_EXTENDS = true;
    static final boolean DEFAULT_VALIDATE_CONNECTIONS = true;
    static final boolean DEFAULT_TEST_WHILE_IDLE = true;
    static final int DEFAULT_BATCH_INSERT_SIZE = 1;
    static final int DEFAULT_EVICTOR_RUN_PERIODICITY = 300;
    static final int DEFAULT_MAX_CONNECTION_IDLE_TIME = 300;
    static final int DEFAULT_EVICTOR_TESTS_PER_RUN = 3;
    static final boolean DEFAULT_ON_THE_FLY_GEOM_SIMPLIFICATION = true;

    /**
     * Create an {@value #TYPE} datastore with default connection parameters,
     * given a store name, and a database name.
     *
     * @param name datastore name
     * @param database database name
     */
    public GSPostGISDatastoreEncoder(String name, String database) {
        super(name);

        // Set mandatory parameter
        setType(TYPE);
        setDatabaseType(DEFAULT_DB_TYPE);
        setDatabase(database);

        // Set default values
        setMinConnections(DEFAULT_MIN_CONNECTIONS);
        setMaxConnections(DEFAULT_MAX_CONNECTIONS);
        setFetchSize(DEFAULT_FETCH_SIZE);
        setConnectionTimeout(DEFAULT_CONNECTION_TIMEOUT);
        setLooseBBox(DEFAULT_LOOSE_BBOX);
        setPreparedStatements(DEFAULT_PREPARED_STATEMENTS);
        setMaxOpenPreparedStatements(DEFAULT_MAX_OPEN_PREPARED_STATEMENTS);
        setEstimatedExtends(DEFAULT_ESTIMATED_EXTENDS);
        setBatchInsertSize(DEFAULT_BATCH_INSERT_SIZE);
        setValidateConnections(DEFAULT_VALIDATE_CONNECTIONS);
        setTestWhileIdle(DEFAULT_TEST_WHILE_IDLE);
        setEvictorRunPeriodicity(DEFAULT_EVICTOR_RUN_PERIODICITY);
        setMaxConnectionIdleTime(DEFAULT_MAX_CONNECTION_IDLE_TIME);
        setEvictorTestsPerRun(DEFAULT_EVICTOR_TESTS_PER_RUN);
        setSupportOnTheFlyGeometrySimplification(DEFAULT_ON_THE_FLY_GEOM_SIMPLIFICATION);
    }

    /**
     * Create an {@value #TYPE} datastore encoder from an existing store read from server.
     *
     * @param store The existing store.
     * @throws IllegalArgumentException if store type or mandatory parameters are not valid
     */
    public GSPostGISDatastoreEncoder(RESTDataStore store) {
    	super(store);

    	// Check mandatory parameter validity
		ensureValidDatabase(store.getConnectionParameters().get("database"));
    }

    public void setHost(String host) {
        connectionParameters.set("host", host);
    }

    public void setPort(int port) {
        connectionParameters.set("port", Integer.toString(port));
    }

    public void setNamespace(String namespace) {
        connectionParameters.set("namespace", namespace);
    }

    public void setDatabase(String database) {
        connectionParameters.set("database", database);
    }

    public void setSchema(String schema) {
        connectionParameters.set("schema", schema);
    }

    public void setUser(String user) {
        connectionParameters.set("user", user);
    }

    public void setPassword(String password) {
        connectionParameters.set("passwd", password);
    }

    public void setDatabaseType(String dbtype) {
        connectionParameters.set("dbtype", dbtype);
    }

    public void setJndiReferenceName(String jndiReferenceName) {
        connectionParameters.set("jndiReferenceName", jndiReferenceName);
    }

    public void setExposePrimaryKeys(boolean exposePrimaryKeys) {
    	connectionParameters.set("Expose primary keys", Boolean.toString(exposePrimaryKeys));
    }

    public void setMaxConnections(int maxConnections) {
    	connectionParameters.set("max connections", Integer.toString(maxConnections));
    }

    public void setMinConnections(int minConnections) {
    	connectionParameters.set("min connections", Integer.toString(minConnections));
    }

    public void setFetchSize(int fetchSize) {
    	connectionParameters.set("fetch size", Integer.toString(fetchSize));
    }

    public void setConnectionTimeout(int seconds) {
    	connectionParameters.set("Connection timeout", Integer.toString(seconds));
    }

    public void setValidateConnections(boolean validateConnections) {
    	connectionParameters.set("validate connections", Boolean.toString(validateConnections));
    }

    public void setPrimaryKeyMetadataTable(String primaryKeyMetadataTable) {
    	connectionParameters.set("Primary key metadata table", primaryKeyMetadataTable);
    }

    public void setLooseBBox(boolean looseBBox) {
    	connectionParameters.set("Loose bbox", Boolean.toString(looseBBox));
    }

    public void setPreparedStatements(boolean preparedStatements) {
    	connectionParameters.set("preparedStatements", Boolean.toString(preparedStatements));
    }

    public void setMaxOpenPreparedStatements(int maxOpenPreparedStatements) {
    	connectionParameters.set("Max open prepared statements", Integer.toString(maxOpenPreparedStatements));
    }

    public void setEstimatedExtends(boolean estimatedExtends){
    	connectionParameters.set("Estimated extends", Boolean.toString(estimatedExtends));
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        connectionParameters.set("Test while idle", Boolean.toString(testWhileIdle));
    }

    public void setBatchInsertSize(int batchInsertSize) {
        connectionParameters.set("Batch insert size", Integer.toString(batchInsertSize));
    }

    public void setEvictorRunPeriodicity(int evictorRunPeriodicity) {
        connectionParameters.set("Evictor run periodicity", Integer.toString(evictorRunPeriodicity));
    }

    public void setMaxConnectionIdleTime(int maxConnectionIdleTime) {
        connectionParameters.set("Max connection idle time", Integer.toString(maxConnectionIdleTime));
    }

    public void setEvictorTestsPerRun(int evictorTestsPerRun) {
        connectionParameters.set("Evictor tests per run", Integer.toString(evictorTestsPerRun));
    }

    public void setSupportOnTheFlyGeometrySimplification(boolean onTheFlySimplification) {
        connectionParameters.set("Support on the fly geometry simplification", Boolean.toString(onTheFlySimplification));
    }

    public void setEncodeFunctions(boolean encodeFunctions) {
        connectionParameters.set("encode functions", Boolean.toString(encodeFunctions));
    }

    /**
     * Check database validity.
     *
     * @param database the database name
     * @throws IllegalArgumentException if database is null or empty
     */
    private static void ensureValidDatabase(String database) {
		if (database == null || database.length() == 0) {
			throw new IllegalArgumentException(
				"Postgis store database cannot be null or empty");
		}
    }

    /**
     * @return {@value #TYPE}
     */
    protected String getValidType() {
    	return TYPE;
    }
}
