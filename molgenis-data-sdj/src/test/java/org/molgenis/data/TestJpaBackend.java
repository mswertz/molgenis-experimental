package org.molgenis.data;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.molgenis.data.Query;
import org.molgenis.data.RepositoryException;
import org.molgenis.test.fields.DateEntity;
import org.molgenis.test.fields.DateEntityRepository;
import org.molgenis.test.fields.IntEntity;
import org.molgenis.test.fields.IntEntityRepository;
import org.molgenis.test.fields.VarcharEntity;
import org.molgenis.test.fields.VarcharEntityRepository;
import org.molgenis.test.inheritance.BextendsA;
import org.molgenis.test.inheritance.BextendsARepository;
import org.molgenis.test.inheritance.ClassA;
import org.molgenis.test.inheritance.ClassARepository;
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
	VarcharEntityRepository db;

	@Test
	@Transactional
	public void test1_getById() throws RepositoryException
	{
		// delete all
		db.deleteAll();

		VarcharEntity e1 = new VarcharEntity();
		e1.setNormalVarchar("test1");

		Assert.assertNull(e1.getId());
		db.save(e1);
		Assert.assertNotNull(e1.getId());

		VarcharEntity e2 = db.findOne(e1.getId());
		Assert.assertEquals(e1.getId(), e2.getId());
	}
	

//	@Autowired
//	ClassARepository classA;
//	
//	@Autowired
//	BextendsARepository classB;
//
//	@Test
//	@Transactional
//	public void test2_subclass()
//	{
//		classA.deleteAll();
//		classB.deleteAll();
//
//		ClassA a = new ClassA();
//		a.setFieldA("a1");
//		classA.save(a);
//
//		ClassA a2 = classA.findOne(a.getId());
//		Assert.assertEquals(a2.getFieldA(), "a1");
//
//		BextendsA b = new BextendsA();
//		b.setFieldA("a2");
//		b.setFieldB("b2");
//		classB.save(b);
//
//		BextendsA b2 = classB.findOne(b.getId());
//		Assert.assertEquals(b2.getFieldA(), "a2");
//
//		Assert.assertEquals(classB.count(), 1L);
//		Assert.assertEquals(classA.count(), 2L);
//
//		ClassA a3 = new ClassA();
//		a3.setFieldA("a3");
//		classA.save(a3);
//
//		Query q = new Query();
//		Assert.assertEquals(classA.count(), 3L);
//		q.eq(ClassA.FIELDA, "a1");
//		Assert.assertEquals(classA.count(q), 1L);
//		q.or();
//		q.eq(ClassA.FIELDA, "a3");
//		Assert.assertEquals(classA.count(q), 2L);
//
//		BextendsA b4 = new BextendsA();
//		b4.setFieldA("a4");
//		b4.setFieldB("b4");
//		classB.save(b4);
//	}
//
//	@Autowired
//	IntEntityRepository intEntity;
//	
//	@Test
//	@Transactional
//	public void test3_int()
//	{
//		intEntity.deleteAll();
//
//		List<IntEntity> iList = new ArrayList<IntEntity>();
//		for (int i = 0; i < 10; i++)
//		{
//			IntEntity ie = new IntEntity();
//			ie.setNormalInt(i);
//			ie.setReadonlyInt(i+10);
//			iList.add(ie);
//		}
//		intEntity.save(iList);
//
//		Query q = new Query();
//		Assert.assertEquals(10, intEntity.count());
//
//		q.gt(IntEntity.NORMALINT, 4);
//		Assert.assertEquals(5, intEntity.count(q));
//		
//		//check nested: (f1 > 3 or f2 > 13) and (f1 < 5 or f2 < 15)
//		String f1 = IntEntity.NORMALINT;
//		String f2 = IntEntity.READONLYINT;
//		q = new Query();
//		q.nest().gt(f1, 3).or().gt(f2, 3+10).unnest().nest().lt(f1, 5).lt(f2, 5+10).unnest();
//		Assert.assertEquals(1, intEntity.count(q));
//		
//		//check between
//		q = new Query().rng(IntEntity.NORMALINT, 3, 5);
//		Assert.assertEquals(1, intEntity.count(q));
//		
//	}
//
//	@Autowired
//	DateEntityRepository dateEntity;
//	
//	@Test
//	@Transactional
//	public void test4_date()
//	{
//		dateEntity.deleteAll();
//
//		Calendar cal = Calendar.getInstance();
//		cal.set(2009, Calendar.DECEMBER, 12);
//
//		Date d1 = cal.getTime();
//
//		DateEntity i1 = new DateEntity();
//		i1.setNormalDate(d1);
//		i1.setReadonlyDate(d1);
//		dateEntity.save(i1);
//
//		cal.add(Calendar.YEAR, 1);
//
//		Date d2 = cal.getTime();
//
//		DateEntity i2 = new DateEntity();
//		i2.setNormalDate(d2);
//		i2.setReadonlyDate(d2);
//		dateEntity.save(i2);
//
//		Query q = new Query();
//		Assert.assertEquals(2, dateEntity.count());
//
//		q.gt(DateEntity.NORMALDATE, d1);
//		Assert.assertEquals(1, dateEntity.count(q));
//	}
//	
//	@Test @Transactional
//	public void test5_limit_offset()
//	{
//		intEntity.deleteAll();
//
//		List<IntEntity> iList = new ArrayList<IntEntity>();
//		for (int i = 0; i < 10; i++)
//		{
//			IntEntity ie = new IntEntity();
//			ie.setNormalInt(i);
//			ie.setReadonlyInt(i+10);
//			iList.add(ie);
//		}
//		intEntity.save(iList);
//
//		Query q = new Query();
//		Assert.assertEquals(10, intEntity.count());
//		
//		q.limit(5).page(2);
//		int i = 0;
//		for(IntEntity e: intEntity.findAll(q)) i++;
//		Assert.assertEquals(5, i);
//		
//		
//	}
}