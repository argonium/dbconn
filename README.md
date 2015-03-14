# DBConn
DBConn is a Java command-line application for working with any JDBC-compliant database.

Here is the list of supported commands:

* cat <file>
* check database
* close database
* connect <URL> [<user> [<pw>]]
* connections
* count rows <table>
* count tables
* dbinfo
* debug
* debug off
* debug on
* describe table
* dir [<path>]
* export data <table name> [<where-clause>]
* export schema <filename>
* gc
* head <file>
* help
* help <start of a command>
* jar <filename>
* list schemas
* list tables
* mem
* quit
* select connection
* time
* time <command>
* version

Most of these commands require a database connection.  To connect to a database, use the 'connect' command.  For example:

```
    connect jdbc:postgresql://localhost/test srogers passw0rd
```

The above command will connect to the test database on localhost as the srogers user.  The PostgreSQL JAR file needs to be in the classpath.

The 'export schema tables.xml' command is used to produce an XML file describing tables in the schema.  This is used by the SchemaBrowser application described elsewhere on this site.

DBConn uses the JLine2 library for command-line history.

To build the application, use Ant to run 'ant clean dist'.  To execute the application, you'll need the JDBC library for your database.  Execute via 'java -cp dbconn.jar:XYZ.jar io.miti.dbconn.app.DBConn', where XYZ.jar is your JDBC library.

The source code is released under the MIT license.
