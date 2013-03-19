
/* File:        test/model/InterfaceA.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.inheritance;

/**
 * InterfaceA: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
public interface InterfaceA extends org.molgenis.db.Entity
{
	public String get__Type();
	public void set__Type(String __type);
	public java.util.List<org.molgenis.db.common.ValueLabel> get__TypeOptions();
	public Integer getId();
	public void setId(Integer id);
	public String getFieldA();
	public void setFieldA(String fieldA);
}

