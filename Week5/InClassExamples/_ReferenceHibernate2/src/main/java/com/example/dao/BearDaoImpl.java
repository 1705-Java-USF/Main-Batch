package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.example.bean.Bear;
import com.example.bean.Cave;
import com.example.bean.HoneyPot;
import com.example.util.HibernateUtil;

public class BearDaoImpl implements BearDao {

	@Override
	public Bear getBearById(int bearId) {
		Session session = HibernateUtil.getSession();
		
		// session.get(Persistant class being interacted with, column property)
		Bear b = (Bear) session.get(Bear.class, bearId);
		
		session.close();
		return b;
	}

	@Override
	public void createBear() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Bear parent = new Bear("brown", "kodiak", 0, 700, new HoneyPot(100,100));
		//Note: created new honeypot for has-a relationship
				
		int i = (Integer) session.save(parent.getHoneyPot());
		
		System.out.println(i + ":generated honeypot ID");
		
		//has cubs!
		Bear child = new Bear("brown", "kodiak", 0, 600, new HoneyPot(30.0, 30.0));
		parent.getBearCubs().add(child);
		
		session.save(child.getHoneyPot());
		
		Cave newHome = new Cave("dark cave", 600);
		parent.setBearHome(newHome);
		child.setBearHome(newHome);
		session.save(newHome);
		session.save(parent);
		session.save(child);
		//session.save(parent);
		
		tx.commit();

		session.close();
	}

	@Override
	public void setBear(Bear bear) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Bear> getAllBears() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public Cave getCaveById(int caveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCave(Cave cave) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cave> getAllCaves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoneyPot getHoneyPotById(int honeyPotId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHoneyPot(HoneyPot honeyPot) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HoneyPot> getAllHoneyPots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bear getOrLoad(int id) {
		System.out.println("PERFORM GET");
		Session session = HibernateUtil.getSession();
		Bear bearGet = (Bear) session.get(Bear.class, id);	
		System.out.println("Get: " + bearGet);
		
		
		System.out.println("PERFORM LOAD");
		Bear bearLoad = (Bear) session.load(Bear.class, id);	
		System.out.println("Load: " + bearLoad);
		
		System.out.println("PERFORM GET2");
		Bear bearGet2 = (Bear) session.get(Bear.class, id);	
		System.out.println("Get: " + bearGet2);
		
		
		System.out.println("PERFORM GET FAIL");
		Bear bearGetFail = (Bear) session.get(Bear.class, id + 1234);	
		System.out.println("Get: " + bearGetFail);
		
		
		System.out.println("PERFORM LOAD FAIL");
		Bear bearLoadFail = (Bear) session.load(Bear.class, id + 1234);	
		System.out.println("Load: " + bearLoadFail);
		
		/*
		 * GET: EAGER fetch approach for grabbing data
		 * -Hits DB and persists all information of the class, as well as 
		 * 	all information of referenced classes.
		 * -As a result, if we hit something not in the database, we get
		 * 	null.
		 * LOAD: LAZY fetch approach for grabbing data.
		 * -Data is grabbed but we are provided a proxy representation of it.
		 * -The proxy provided gives us implementation of all the getters and
		 *  setters of the class. However, information is not persisted until 
		 *  we call the specific getter or setter.
		 */
		
		
		return null;
	}

	@Override
	public void criteriaDemo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryDemo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testCache() {
		// TODO Auto-generated method stub

	}
	
	public void mergeAndUpdate() {
		Session session = HibernateUtil.getSession();
		Bear b1 = null;
		Bear b2 = null;
		
		Transaction tx = session.beginTransaction();
		b1 = (Bear) session.get(Bear.class,50); //b1 persistent
		b1.setBearColor("Bobbert");
		
		session.close();
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		b2 = (Bear) session.get(Bear.class, 50); //b2 persisted
		session.update(b1); //What?
		
		tx.commit();
		session.close();
	}
	/*
	 * Both merge and update aim to re-attach detached objects to a persistent state
	 * -However there is a small difference between the two..
	 * 	-update will throw an exception if you try to invoke it while a session 
	 * 	current has a different persistent object representation
	 *  -in the event of using a different object update tries to sync a non
	 *  matching object with its DB representation. thus an exception occurs when you try
	 *  
	 *  -Merge, as its name suggests, will bring in the outside object, and merge it with 
	 *  the current persistent representation
	 *  -Use merge if you dont care about altering the session persistent object states
	 *  in your code. Update is "safer" to ensure you dont synchronize with different objects
	 */
	

	
	/*
	 * Key knowledge
	 * -Persist() vs Save()
	 * --Persist:
	 * 		-Make a transient object persistent.
	 * 		-DOES NOT guarantee an id right away..
	 * 			-When called, it does not have a spot in the DB JUST YET
	 * 		-This provides a useful means for long run transactions where
	 * 		manipulation of persistent object is numerous and want to minimize
	 * 		hits to DB to update it in a single transaction
	 * 		-Id is typically provided at flush time, or commit time
	 * 		-Flush time: time when objects synchronized with DB
	 * -Save:
	 * 		-Persists the object and provides the unique ID in the DB that
	 * 		represents it
	 * 		-If working with a generated ID, the object is inserted right
	 * 		away upon calling save 
	 * 		
	 * 
	 */
	
	public void hqlAndCriteria(){
		Session session = HibernateUtil.getSession();
		Query query;
		String hql;
		Transaction tx;
		
		System.out.println("---Get all bears---");
		hql ="FROM com.example.bean.Bear";
		query = session.createQuery(hql);
		List<Bear> bears = query.list();
		for(Object bear : bears){
			System.out.println(bear);
		}
		System.out.println("---Get all bears of specific fur color---");
		hql ="FROM com.example.bean.Bear WHERE bearColor = :bcolor";
		//Precede with a : to denote a variable to be replaced with a value
		query = session.createQuery(hql);
		query.setParameter("bcolor", "bobbert");
		
		bears = query.list();
		for(Object bear : bears){
			System.out.println(bear);
		}
		
		/*
		 * You can also do updates:
		 * Make the HQL = something like:
		 *  UPDATE Bear SET weight = weight + :num where bearId = :OtherVar
		 */
		System.out.println("--Criteria example--");
		Criteria criteria;
		bears = session.createCriteria(Bear.class).list(); //gives all bears
		
		bears = session.createCriteria(Bear.class).add(Restrictions.ilike("bearColor", "brown"))
				.list();
		/*
		 * Sets a criteria with a restriction to property bearColor that is LIKE
		 * "brown". Note: ilike is not case sensitive, like is case sensitive
		 */
		
		
	}
}
