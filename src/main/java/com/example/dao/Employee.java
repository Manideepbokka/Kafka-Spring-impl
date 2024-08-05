/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.dao;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Employee extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2248264941249199361L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Employee\",\"namespace\":\"com.example.dao\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"firstName\",\"type\":\"string\"},{\"name\":\"middleName\",\"type\":\"string\",\"default\":\"\"},{\"name\":\"lastName\",\"type\":\"string\"},{\"name\":\"emailId\",\"type\":\"string\",\"default\":\"\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Employee> ENCODER =
      new BinaryMessageEncoder<Employee>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Employee> DECODER =
      new BinaryMessageDecoder<Employee>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Employee> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Employee> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Employee>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Employee to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Employee from a ByteBuffer. */
  public static Employee fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence id;
  @Deprecated public java.lang.CharSequence firstName;
  @Deprecated public java.lang.CharSequence middleName;
  @Deprecated public java.lang.CharSequence lastName;
  @Deprecated public java.lang.CharSequence emailId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Employee() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param firstName The new value for firstName
   * @param middleName The new value for middleName
   * @param lastName The new value for lastName
   * @param emailId The new value for emailId
   */
  public Employee(java.lang.CharSequence id, java.lang.CharSequence firstName, java.lang.CharSequence middleName, java.lang.CharSequence lastName, java.lang.CharSequence emailId) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.emailId = emailId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return firstName;
    case 2: return middleName;
    case 3: return lastName;
    case 4: return emailId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: firstName = (java.lang.CharSequence)value$; break;
    case 2: middleName = (java.lang.CharSequence)value$; break;
    case 3: lastName = (java.lang.CharSequence)value$; break;
    case 4: emailId = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'firstName' field.
   * @return The value of the 'firstName' field.
   */
  public java.lang.CharSequence getFirstName() {
    return firstName;
  }

  /**
   * Sets the value of the 'firstName' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.CharSequence value) {
    this.firstName = value;
  }

  /**
   * Gets the value of the 'middleName' field.
   * @return The value of the 'middleName' field.
   */
  public java.lang.CharSequence getMiddleName() {
    return middleName;
  }

  /**
   * Sets the value of the 'middleName' field.
   * @param value the value to set.
   */
  public void setMiddleName(java.lang.CharSequence value) {
    this.middleName = value;
  }

  /**
   * Gets the value of the 'lastName' field.
   * @return The value of the 'lastName' field.
   */
  public java.lang.CharSequence getLastName() {
    return lastName;
  }

  /**
   * Sets the value of the 'lastName' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.CharSequence value) {
    this.lastName = value;
  }

  /**
   * Gets the value of the 'emailId' field.
   * @return The value of the 'emailId' field.
   */
  public java.lang.CharSequence getEmailId() {
    return emailId;
  }

  /**
   * Sets the value of the 'emailId' field.
   * @param value the value to set.
   */
  public void setEmailId(java.lang.CharSequence value) {
    this.emailId = value;
  }

  /**
   * Creates a new Employee RecordBuilder.
   * @return A new Employee RecordBuilder
   */
  public static com.example.dao.Employee.Builder newBuilder() {
    return new com.example.dao.Employee.Builder();
  }

  /**
   * Creates a new Employee RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Employee RecordBuilder
   */
  public static com.example.dao.Employee.Builder newBuilder(com.example.dao.Employee.Builder other) {
    return new com.example.dao.Employee.Builder(other);
  }

  /**
   * Creates a new Employee RecordBuilder by copying an existing Employee instance.
   * @param other The existing instance to copy.
   * @return A new Employee RecordBuilder
   */
  public static com.example.dao.Employee.Builder newBuilder(com.example.dao.Employee other) {
    return new com.example.dao.Employee.Builder(other);
  }

  /**
   * RecordBuilder for Employee instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Employee>
    implements org.apache.avro.data.RecordBuilder<Employee> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence firstName;
    private java.lang.CharSequence middleName;
    private java.lang.CharSequence lastName;
    private java.lang.CharSequence emailId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.dao.Employee.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.middleName)) {
        this.middleName = data().deepCopy(fields()[2].schema(), other.middleName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.lastName)) {
        this.lastName = data().deepCopy(fields()[3].schema(), other.lastName);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.emailId)) {
        this.emailId = data().deepCopy(fields()[4].schema(), other.emailId);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Employee instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.dao.Employee other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.middleName)) {
        this.middleName = data().deepCopy(fields()[2].schema(), other.middleName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.lastName)) {
        this.lastName = data().deepCopy(fields()[3].schema(), other.lastName);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.emailId)) {
        this.emailId = data().deepCopy(fields()[4].schema(), other.emailId);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'firstName' field.
      * @return The value.
      */
    public java.lang.CharSequence getFirstName() {
      return firstName;
    }

    /**
      * Sets the value of the 'firstName' field.
      * @param value The value of 'firstName'.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder setFirstName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.firstName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'firstName' field has been set.
      * @return True if the 'firstName' field has been set, false otherwise.
      */
    public boolean hasFirstName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'firstName' field.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder clearFirstName() {
      firstName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'middleName' field.
      * @return The value.
      */
    public java.lang.CharSequence getMiddleName() {
      return middleName;
    }

    /**
      * Sets the value of the 'middleName' field.
      * @param value The value of 'middleName'.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder setMiddleName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.middleName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'middleName' field has been set.
      * @return True if the 'middleName' field has been set, false otherwise.
      */
    public boolean hasMiddleName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'middleName' field.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder clearMiddleName() {
      middleName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastName' field.
      * @return The value.
      */
    public java.lang.CharSequence getLastName() {
      return lastName;
    }

    /**
      * Sets the value of the 'lastName' field.
      * @param value The value of 'lastName'.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder setLastName(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.lastName = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'lastName' field has been set.
      * @return True if the 'lastName' field has been set, false otherwise.
      */
    public boolean hasLastName() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'lastName' field.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'emailId' field.
      * @return The value.
      */
    public java.lang.CharSequence getEmailId() {
      return emailId;
    }

    /**
      * Sets the value of the 'emailId' field.
      * @param value The value of 'emailId'.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder setEmailId(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.emailId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'emailId' field has been set.
      * @return True if the 'emailId' field has been set, false otherwise.
      */
    public boolean hasEmailId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'emailId' field.
      * @return This builder.
      */
    public com.example.dao.Employee.Builder clearEmailId() {
      emailId = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Employee build() {
      try {
        Employee record = new Employee();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.firstName = fieldSetFlags()[1] ? this.firstName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.middleName = fieldSetFlags()[2] ? this.middleName : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.lastName = fieldSetFlags()[3] ? this.lastName : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.emailId = fieldSetFlags()[4] ? this.emailId : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Employee>
    WRITER$ = (org.apache.avro.io.DatumWriter<Employee>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Employee>
    READER$ = (org.apache.avro.io.DatumReader<Employee>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
