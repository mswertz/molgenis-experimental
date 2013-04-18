package org.molgenis.backend;

import org.molgenis.backend.memory.MemoryBackend;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.fields.VarcharEntity;

public class TestMemoryBackend
{
	@Test
	public void test1() throws BackendException
	{
		VarcharEntity a = new VarcharEntity();
		a.setNormalVarchar("hello world");
		
		Backend b = new MemoryBackend();
		b.add(a);
		
		Query<VarcharEntity> q = b.query(VarcharEntity.class);
		Assert.assertEquals(q.count(),1);
		
		VarcharEntity a2 = new VarcharEntity();
		a2.setNormalVarchar("john doe");
		b.add(a2);
		
		Assert.assertEquals(q.count(),2);
		
		q.eq(VarcharEntity.NORMALVARCHAR, "john doe");
		
		Assert.assertEquals(q.count(),1);

		
	}
}
