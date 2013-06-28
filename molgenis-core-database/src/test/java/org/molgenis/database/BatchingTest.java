package org.molgenis.database;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.molgenis.Database;
import org.molgenis.test.fields.VarcharEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:applicationContext.xml")
public class BatchingTest extends AbstractTransactionalTestNGSpringContextTests
{
	Logger logger = Logger.getLogger(BatchingTest.class);

	@Autowired
	Database db;

	@Test
	@Transactional
	@Rollback(false)
	public void test1()
	{
		long count = db.count(VarcharEntity.class);

		long time = System.currentTimeMillis();

		db.remove(db.find(VarcharEntity.class));

		long duration = System.currentTimeMillis() - time;

		if (count > 0) System.out.println("remove of " + count + " took " + duration + "ms (" + Math.round(1000*(double)count/duration)
				+ " per sec)");

	}

//	@Test
//	@Transactional
//	public void test2()
//	{
//		int size = 10000;
//
//		List<VarcharEntity> vList = new ArrayList<VarcharEntity>();
//
//		for (int i = 0; i <= size; i++)
//		{
//			VarcharEntity v = new VarcharEntity();
//			v.setNormalVarchar("value" + i);
//			vList.add(v);
//		}
//		System.out.println("begin");
//		long time = System.currentTimeMillis();
//		db.add(vList);
//		long duration = System.currentTimeMillis() - time;
//		System.out.println("insert of " + size + " took " + duration + "ms ("
//				+ Math.round(1000 * ((double) size / duration)) + " per sec)");
//
//	}

	@Test
	@Transactional
	@Rollback(false)
	public void test3()
	{
		int size = 10000;

		List<VarcharEntity> vList = new ArrayList<VarcharEntity>();

		for (int i = 0; i <= size; i++)
		{
			VarcharEntity v = new VarcharEntity();
			v.setNormalVarchar("value" + i);
			vList.add(v);
		}
		System.out.println("begin");
		long time = System.currentTimeMillis();
		db.add(vList);
		long duration = System.currentTimeMillis() - time;
		System.out.println("insert of " + size + " took " + duration + "ms ("
				+ Math.round(1000 * ((double) size / duration)) + " per sec)");

	}
}
