//package org.molgenis.query;
//
//import java.util.List;
//
//import junit.framework.Assert;
//
//import org.molgenis.Version;
//import org.molgenis.framework.db.Database;
//import org.molgenis.framework.db.DatabaseException;
//import org.molgenis.omx.observ.DataSet;
//import org.molgenis.omx.observ.ObservableFeature;
//import org.molgenis.omx.observ.ObservationSet;
//import org.molgenis.omx.observ.ObservedValue;
//import org.molgenis.omx.observ.Protocol;
//import org.molgenis.omx.observ.target.Individual;
//import org.molgenis.temp.DatabaseFactory;
//import org.molgenis.util.tuple.Record;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class TestQuery
//{
//	@Autowired
//	Backend db;
//	
//	@BeforeClass
//	public void setup() throws DatabaseException, Exception
//	{
//		System.out.println(Version.convertToString());
//		
//		// add some data
//		Individual i = new Individual();
//		i.setIdentifier("ind1");
//		i.setName("ind1");
//
//		Individual i2 = new Individual();
//		i2.setIdentifier("ind2");
//		i2.setName("ind2");
//
//		db.remove(db.find(Individual.class));
//
//		db.add(i);
//		db.add(i2);
//
//		// create a data set
//		db.remove(db.find(ObservedValue.class));
//		db.remove(db.find(ObservationSet.class));
//		db.remove(db.find(DataSet.class));
//		db.remove(db.find(Protocol.class));
//		db.remove(db.find(ObservableFeature.class));
//
//		ObservableFeature f0 = new ObservableFeature();
//		f0.setIdentifier("id");
//		f0.setName("id");
//		db.add(f0);
//		
//		ObservableFeature f1 = new ObservableFeature();
//		f1.setIdentifier("f1");
//		f1.setName("f1");
//		db.add(f1);
//
//		ObservableFeature f2 = new ObservableFeature();
//		f2.setIdentifier("f2");
//		f2.setName("f2");
//		db.add(f2);
//
//		Protocol p1 = new Protocol();
//		p1.setIdentifier("p1");
//		p1.setName("p1");
//		p1.getFeatures().add(f0);
//		p1.getFeatures().add(f1);
//		p1.getFeatures().add(f2);
//		db.add(p1);
//
//		DataSet ds1 = new DataSet();
//		ds1.setName("ds1");
//		ds1.setIdentifier("ds1");
//		ds1.setProtocolUsed(p1);
//		db.add(ds1);
//
//		ObservationSet o1 = new ObservationSet();
//		o1.setPartOfDataSet(ds1);
//		db.add(o1);
//		
//		ObservedValue v10 = new ObservedValue();
//		v10.setFeature(f0);
//		v10.setValue("1");
//		v10.setObservationSet(o1);
//		db.add(v10);
//
//		ObservedValue v11 = new ObservedValue();
//		v11.setFeature(f1);
//		v11.setValue("11");
//		v11.setObservationSet(o1);
//		db.add(v11);
//
//		ObservedValue v12 = new ObservedValue();
//		v12.setFeature(f2);
//		v12.setValue("12");
//		v12.setObservationSet(o1);
//		db.add(v12);
//
//		ObservationSet o2 = new ObservationSet();
//		o2.setPartOfDataSet(ds1);
//		db.add(o2);
//		
//		ObservedValue v20 = new ObservedValue();
//		v20.setFeature(f0);
//		v20.setValue("2");
//		v20.setObservationSet(o2);
//		db.add(v20);
//
//		ObservedValue v21 = new ObservedValue();
//		v21.setFeature(f1);
//		v21.setValue("21");
//		v21.setObservationSet(o2);
//		db.add(v21);
//
//		ObservedValue v22 = new ObservedValue();
//		v22.setFeature(f2);
//		v22.setValue("22");
//		v22.setObservationSet(o2);
//		db.add(v22);
//	}
//
//	@Test
//	public void test1_getQueryForClass()
//	{
//		Query<Individual> qs = new QueryFactoryImp().query(Individual.class);
//
//		Assert.assertNotNull(qs);
//	}
//
//	@Test
//	public void test2_testSimpleQuery() throws QueryException
//	{
//		Query<Individual> qs = new QueryFactoryImp().query(Individual.class);
//
//		Assert.assertEquals(2, qs.count());
//
//		int i = 1;
//		for (Individual ind : qs)
//		{
//			Assert.assertEquals(ind.getName(), "ind" + i);
//			i++;
//		}
//	}
//
//	@Test
//	public void test3_testTupleTableQuery() throws QueryException
//	{
//		QueryFactory qs = new QueryFactoryImp();
//		List<String> sets = qs.getSets();
//
//		Assert.assertTrue(sets.contains("ds1"));
//
//		Query<? extends Record> q = qs.query("ds1");
//
//		Assert.assertEquals(2, q.count());
//	}
//}
