package org.molgenis.generate.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.molgenis.data.Backend;
import org.molgenis.data.BackendException;
import org.molgenis.data.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.fields.DateEntity;
import test.fields.IntEntity;
import test.fields.OtherVarcharEntity;
import test.fields.VarcharEntity;
import test.fields.XrefEntity;
import test.inheritance.BextendsA;
import test.inheritance.ClassA;

@ContextConfiguration("classpath:applicationContext.xml")
public class TestJpaBackend extends AbstractTransactionalTestNGSpringContextTests
{
	Logger logger = Logger.getLogger(TestJpaBackend.class);

	@Autowired
	Backend db;

	@Test
	@Transactional
	public void test1_getById() throws BackendException
	{
		// delete all
		db.remove(db.query(VarcharEntity.class));

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
	public void test2_subclass() throws BackendException
	{
		db.remove(db.query(ClassA.class));
		db.remove(db.query(BextendsA.class));

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

		Assert.assertEquals(db.query(BextendsA.class).count(), 1L);
		Assert.assertEquals(db.query(ClassA.class).count(), 2L);

		ClassA a3 = new ClassA();
		a3.setFieldA("a3");
		db.add(a3);

		Query<ClassA> q = db.query(ClassA.class);
		Assert.assertEquals(q.count(), 3L);
		q.eq(ClassA.FIELDA, "a1");
		Assert.assertEquals(q.count(), 1L);
		q.or();
		q.eq(ClassA.FIELDA, "a3");
		Assert.assertEquals(q.count(), 2L);

		BextendsA b4 = new BextendsA();
		b4.setFieldA("a4");
		b4.setFieldB("b4");
		db.add(b4);
	}

	@Test
	@Transactional
	public void test3_int() throws BackendException
	{
		db.remove(db.query(IntEntity.class));

		List<IntEntity> iList = new ArrayList<IntEntity>();
		for (int i = 0; i < 10; i++)
		{
			IntEntity ie = new IntEntity();
			ie.setNormalInt(i);
			ie.setReadonlyInt(i+10);
			iList.add(ie);
		}
		db.add(iList);

		Query<IntEntity> q = db.query(IntEntity.class);
		Assert.assertEquals(10, q.count());

		q.gt(IntEntity.NORMALINT, 4);
		Assert.assertEquals(5, q.count());
		
		//check nested: (f1 > 3 or f2 > 13) and (f1 < 5 or f2 < 15)
		String f1 = IntEntity.NORMALINT;
		String f2 = IntEntity.READONLYINT;
		q = db.query(IntEntity.class);
		q.nest().gt(f1, 3).or().gt(f2, 3+10).unnest().nest().lt(f1, 5).lt(f2, 5+10).unnest();
		Assert.assertEquals(1, q.count());
		
		//check between
		q = db.query(IntEntity.class).rng(IntEntity.NORMALINT, 3, 5);
		Assert.assertEquals(1, q.count());
		
	}

	@Test
	@Transactional
	public void test4_date() throws BackendException
	{
		db.remove(db.query(DateEntity.class));

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

		Query<DateEntity> q = db.query(DateEntity.class);
		Assert.assertEquals(2, q.count());

		q.gt(DateEntity.NORMALDATE, d1);
		Assert.assertEquals(1, q.count());
	}
	
	@Test
	@Transactional
	public void test5_xref() throws BackendException
	{
		//referenced object
		db.remove(db.query(XrefEntity.class));
		db.remove(db.query(OtherVarcharEntity.class));
		OtherVarcharEntity other = new OtherVarcharEntity();
		other.setNormalVarchar("hello");
		db.add(other); //we don't use cascade as this can become very messy!

		//set by object
		XrefEntity x = new XrefEntity();
		x.setNormalXref(other);
		db.add(x);
		
		//can we now find both back???
		Assert.assertNotNull(other.getId());
		OtherVarcharEntity other3 = db.getById(OtherVarcharEntity.class, other.getId());
		Assert.assertEquals("hello", other3.getNormalVarchar());
		Assert.assertEquals("hello", x.getNormalXref().getNormalVarchar());
		
		XrefEntity x2 = db.getById(XrefEntity.class, x.getId());
		Assert.assertEquals("hello", x2.getNormalXref().getNormalVarchar());
	}
	
	@Test
	@Transactional
	public void test5_xref_bylabel() throws BackendException
	{
		//referenced object
		db.remove(db.query(XrefEntity.class));
		db.remove(db.query(OtherVarcharEntity.class));
		OtherVarcharEntity other = new OtherVarcharEntity();
		other.setNormalVarchar("hello");
		db.add(other); //we don't use cascade as this can become very messy!

		//set by object
		XrefEntity x = new XrefEntity();
		x.setNormalXrefByLabel(other.getNormalVarchar());
		//x.loadXrefs(db);
		db.add(x);
		
		//can we now find  back???
		Assert.assertEquals("hello", x.getNormalXref().getNormalVarchar());
		
		XrefEntity x2 = db.getById(XrefEntity.class, x.getId());
		Assert.assertEquals("hello", x2.getNormalXref().getNormalVarchar());
	}
}
