package io.miti.dbconn.util;

/**
 * Encapsulate a database column.
 * 
 * @author mwallace
 * @version 1.0
 */
public final class TableColumn
{
  /**
   * Integer column type.
   */
  public static final int COL_INT = 0;
  
  /**
   * Double column type.
   */
  public static final int COL_DOUBLE = 1;
  
  /**
   * Float column type.
   */
  public static final int COL_FLOAT = 2;
  
  /**
   * String column type.
   */
  public static final int COL_STRING = 3;
  
  /**
   * Short column type.
   */
  public static final int COL_SHORT = 4;
  
  /**
   * Long column type.
   */
  public static final int COL_LONG = 5;
  
  /**
   * Char column type.
   */
  public static final int COL_CHAR = 6;
  
  /**
   * Byte column type.
   */
  public static final int COL_BYTE = 7;
  
  /**
   * Date column type.
   */
  public static final int COL_DATE = 8;
  
  /**
   * Boolean column type.
   */
  public static final int COL_BOOLEAN = 9;
  
  /**
   * Decimal column type.
   */
  public static final int COL_DECIMAL = 10;
  
  /** Clobs. */
  public static final int COL_CLOB = 11;
  
  /** XML. */
  public static final int COL_XMLTYPE = 12;
  
  /** Other/Object/SDO_GEOMETRY. */
  public static final int COL_OBJECT = 13;
  
  /** Blobs. */
  public static final int COL_BLOB = 14;
  
  public static final int COL_UNKNOWN = 20;
  
  /**
   * The column name.
   */
  private String colName = null;
  
  /**
   * The type for the column.
   */
  private int colType = -1;
  
  /**
   * Whether this column is the primary key.
   */
  private boolean isPrimaryKey = false;
  
  /**
   * The field name.
   */
  private String fieldName = null;
  
  
  /**
   * Default constructor.
   */
  public TableColumn()
  {
    super();
  }
  
  
  /**
   * Constructor taking the class member values.
   * 
   * @param name the column name
   * @param javaType the column type (as a Java type)
   * @param fldName the name to use for the Java class field
   * @param isPK whether this column is the primary key
   */
  public TableColumn(final String name,
                     final int javaType,
                     final String fldName,
                     final boolean isPK)
  {
    super();
    colName = name;
    colType = javaType;
    fieldName = fldName;
    isPrimaryKey = isPK;
  }
  
  
  /**
   * Returns the column name.
   * 
   * @return the colName
   */
  public String getColName()
  {
    return colName;
  }
  
  
  /**
   * Returns the column type.
   * 
   * @return the colType
   */
  public int getColType()
  {
    return colType;
  }
  
  
  /**
   * Returns the field name.
   * 
   * @return the field name
   */
  public String getFieldName()
  {
    return fieldName;
  }
  
  
  /**
   * Return whether this column is the primary key.
   * 
   * @return whether this column is the primary key
   */
  public boolean isPrimaryKey()
  {
    return isPrimaryKey;
  }
  
  
  /**
   * Convert a database type to a Java type.
   * 
   * @param dbType the database type
   * @param typeStr the database type as a String
   * @return the corresponding Java type
   */
  public static int getJavaTypeForDBType(final int dbType, final String typeStr)
  {
    // The Java type
    int javaType = -1;
    
    // Handle the different database types
    switch (dbType)
    {
      case java.sql.Types.BIGINT:
        /* This won't work for unsigned bigints */
        javaType = COL_LONG;
        break;
      
      case java.sql.Types.BOOLEAN:
      case java.sql.Types.BIT:
        javaType = COL_BOOLEAN; // was COL_BYTE
        break;
      
      case java.sql.Types.CHAR:
        javaType = COL_STRING;
        break;
      
      case java.sql.Types.NUMERIC:
      case java.sql.Types.DOUBLE:
      case java.sql.Types.REAL:
        javaType = COL_DOUBLE;
        break;
      
      case java.sql.Types.DECIMAL:
        javaType = COL_DECIMAL;
        break;
        
      case java.sql.Types.FLOAT:
        javaType = COL_FLOAT;
        break;
        
      case java.sql.Types.INTEGER:
        javaType = COL_INT;
        break;
        
      case java.sql.Types.TINYINT:
      case java.sql.Types.SMALLINT:
        javaType = COL_SHORT;
        break;
        
      case java.sql.Types.VARCHAR:
      case java.sql.Types.LONGVARCHAR:
        javaType = COL_STRING;
        break;
        
      case java.sql.Types.DATE:
      case java.sql.Types.TIMESTAMP:
      	javaType = COL_DATE;
      	break;
      
      case java.sql.Types.CLOB:
        javaType = COL_CLOB;
        break;
        
        case java.sql.Types.BLOB:
          javaType = COL_BLOB;
          break;
        
      case 2007: // XML
        javaType = COL_XMLTYPE;
        break;
        
      case java.sql.Types.OTHER:
      case java.sql.Types.VARBINARY:
        javaType = COL_OBJECT;
        break;
        
      default:
        javaType = COL_UNKNOWN;
        // throw new RuntimeException("Unknown type: " + typeStr + " / " + dbType);
        System.out.println("Unknown type: " + typeStr + " / " + dbType);
    }
    
    // Return the corresponding Java type
    return javaType;
  }
  
  
  /**
   * Return this object as a string.
   * 
   * @return this object as a string
   */
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder(40);
    sb.append("Name: ").append(colName).append("  Type: ").append(colType);
    return sb.toString();
  }
}
