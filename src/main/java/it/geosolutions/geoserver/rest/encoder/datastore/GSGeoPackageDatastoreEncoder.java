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
 * @author Oscar Fonts
 */
public class GSGeoPackageDatastoreEncoder extends GSAbstractDatastoreEncoder {
  
  static final String TYPE = "GeoPackage";
  
  static final String DEFAULT_DB_TYPE = "geopkg";
  
  /**
   * Create an {@value #TYPE} datastore with default connection parameters, given a store name, and a database name.
   *
   * @param name
   *          datastore name
   * @param database
   *          database name
   */
  public GSGeoPackageDatastoreEncoder(String name, String database) {
    super(name);
    
    // Set mandatory parameter
    setType(TYPE);
    setDatabaseType(DEFAULT_DB_TYPE);
    setDatabase(database);
  }
  
  /**
   * Create an {@value #TYPE} datastore encoder from an existing store read from server.
   *
   * @param store
   *          The existing store.
   * @throws IllegalArgumentException
   *           if store type or mandatory parameters are not valid
   */
  public GSGeoPackageDatastoreEncoder(RESTDataStore store) {
    super(store);
    
    // Check mandatory parameter validity
    ensureValidDatabase(store.getConnectionParameters().get("database"));
  }
  
  public void setDatabase(String database) {
    connectionParameters.set("database", database);
  }
  
  public void setUser(String user) {
    connectionParameters.set("user", user);
  }
  
  public void setDatabaseType(String dbtype) {
    connectionParameters.set("dbtype", dbtype);
  }
  
  /**
   * Check database validity.
   *
   * @param database
   *          the database name
   * @throws IllegalArgumentException
   *           if database is null or empty
   */
  private static void ensureValidDatabase(String database) {
    if (database == null || database.length() == 0) {
      throw new IllegalArgumentException("Postgis store database cannot be null or empty");
    }
  }
  
  /**
   * @return {@value #TYPE}
   */
  protected String getValidType() {
    return TYPE;
  }
}
