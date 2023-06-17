package ma.ismo.crjj.efm.idao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ismo.crjj.efm.beans.Etablissement;

import ma.ismo.crjj.util.HibernateUtil;


public class daoEtablissement implements IDao<Etablissement> {
	@Override
	public List<Etablissement> getAll() {
		Session s = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		List<Etablissement> etab = s.createQuery("from Etablissement").list();

		t.commit();
		s.close();
		return etab;
	}

	@Override
	public Etablissement getOne(int id) {

		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Etablissement etab = session.get(Etablissement.class, id);

		t.commit();
		session.close();

		return etab;
	}

	@Override
	public boolean save(Etablissement obj) {
		try {
			Session s = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			
			s.save(obj);
			
			t.commit();
			s.close();
			
			return true;
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Etablissement obj) {
		try {
			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Etablissement obj) {
		try {
			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
