package org.molgenis.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.molgenis.Database;
import org.molgenis.DatabaseException;
import org.molgenis.Query;
import org.molgenis.test.fields.DateEntity;
import org.molgenis.test.fields.IntEntity;
import org.molgenis.test.fields.OtherVarcharEntity;
import org.molgenis.test.fields.VarcharEntity;
import org.molgenis.test.fields.XrefEntity;
import org.molgenis.test.inheritance.BextendsA;
import org.molgenis.test.inheritance.ClassA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:applicationContext.xml")
public class TestJpaBackend extends AbstractTransactionalTestNGSpringContextTests
{
	Logger logger = Logger.getLogger(TestJpaBackend.class);

	@Autowired
	Database db;

	@Test
	@Transactional
	public void test1_getById() throws DatabaseException
	{
		// delete all
		db.remove(db.find(VarcharEntity.class));

		VarcharEntity e1 = new VarcharEntity();
		e1.setNormalVarchar("test1");

		Assert.assertNull(e1.getId());
		db.add(e1);
		Assert.assertNotNull(e1.getId());

		VarcharEntity e2 = db.getById(VarcharEntity.class, e1.getId());
		Assert.assertEquals(e1.getId(), e2.getId());
	}

	@Test
	@Transactional
	public void test2_subclass() throws DatabaseException
	{
		db.remove(db.find(ClassA.class));
		db.remove(db.find(BextendsA.class));

		ClassA a = new ClassA();
		a.setFieldA("a1");
		db.add(a);

		ClassA a2 = db.getById(ClassA.class, a.getId());
		Assert.assertEquals(a2.getFieldA(), "a1");

		BextendsA b = new BextendsA();
		b.setFieldA("a2");
		b.setFieldB("b2");
		db.add(b);

		BextendsA b2 = db.getById(BextendsA.class, b.getId());
		Assert.assertEquals(b2.getFieldA(), "a2");

		Assert.assertEquals(db.count(BextendsA.class), 1L);
		Assert.assertEquals(db.count(ClassA.class), 2L);

		ClassA a3 = new ClassA();
		a3.setFieldA("a3");
		db.add(a3);

		Query q = new Query();
		Assert.assertEquals(db.count(ClassA.class), 3L);
		q.eq(ClassA.FIELDA, "a1");
		Assert.assertEquals(db.count(ClassA.class,q), 1L);
		q.or();
		q.eq(ClassA.FIELDA, "a3");
		Assert.assertEquals(db.count(ClassA.class,q), 2L);

		BextendsA b4 = new BextendsA();
		b4.setFieldA("a4");
		b4.setFieldB("b4");
		db.add(b4);
	}

	@Test
	@Transactional
	public void test3_int() throws DatabaseException
	{
		db.remove(db.find(IntEntity.class));

		List<IntEntity> iList = new ArrayList<IntEntity>();
		for (int i = 0; i < 10; i++)
		{
			IntEntity ie = new IntEntity();
			ie.setNormalInt(i);
			ie.setReadonlyInt(i+10);
			iList.add(ie);
		}
		db.add(iList);

		Query q = new Query();
		Assert.assertEquals(10, db.count(IntEntity.class));

		q.gt(IntEntity.NORMALINT, 4);
		Assert.assertEquals(5, db.count(IntEntity.class,q));
		
		//check nested: (f1 > 3 or f2 > 13) and (f1 < 5 or f2 < 15)
		String f1 = IntEntity.NORMALINT;
		String f2 = IntEntity.READONLYINT;
		q = new Query();
		q.nest().gt(f1, 3).or().gt(f2, 3+10).unnest().nest().lt(f1, 5).lt(f2, 5+10).unnest();
		Assert.assertEquals(1, db.count(IntEntity.class,q));
		
		//check between
		q = new Query().rng(IntEntity.NORMALINT, 3, 5);
		Assert.assertEquals(1, db.count(IntEntity.class,q));
		
	}

	@Test
	@Transactional
	public void test4_date() throws DatabaseException
	{
		db.remove(db.find(DateEntity.class));

		Calendar cal = Calendar.getInstance();
		cal.set(2009, Calendar.DECEMBER, 12);

		Date d1 = cal.getTime();

		DateEntity i1 = new DateEntity();
		i1.setNormalDate(d1);
		i1.setReadonlyDate(d1);
		db.add(i1);

		cal.add(Calendar.YEAR, 1);

		Date d2 = cal.getTime();

		DateEntity i2 = new DateEntity();
		i2.setNormalDate(d2);
		i2.setReadonlyDate(d2);
		db.add(i2);

		Query q = new Query();
		Assert.assertEquals(2, db.count(DateEntity.class));

		q.gt(DateEntity.NORMALDATE, d1);
		Assert.assertEquals(1, db.count(DateEntity.class,q));
	}
	
	@Test @Transactional
	public void test5_limit_offset()
	{
		db.remove(db.find(IntEntity.class));

		List<IntEntity> iList = new ArrayList<IntEntity>();
		for (int i = 0; i < 10; i++)
		{
			IntEntity ie = new IntEntity();
			ie.setNormalInt(i);
			ie.setReadonlyInt(i+10);
			iList.add(ie);
		}
		db.add(iList);

		Query q = new Query();
		Assert.assertEquals(10, db.count(IntEntity.class));
		
		q.limit(5).page(2);
		int i = 0;
		for(IntEntity e: db.find(IntEntity.class,q)) i++;
		Assert.assertEquals(5, i);
		
		
	}
}