
/* File:        test/model/interfaceC.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.inheritance;

/**
 * InterfaceC: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
public interface InterfaceC extends org.molgenis.db.Entity
{
	public String get__Type();
	public void set__Type(String __type);
	public java.util.List<org.molgenis.db.common.ValueLabel> get__TypeOptions();
	public String getNameC();
	public void setNameC(String nameC);
	public test.fields.VarcharEntity getXrefC();
	public void setXrefC(test.fields.VarcharEntity xrefC);
    public Integer getXrefC_Id();
    public void setXrefC_Id(Integer xrefC);


	public void setXrefC_NormalVarchar(String xrefC_normalVarchar);

}

