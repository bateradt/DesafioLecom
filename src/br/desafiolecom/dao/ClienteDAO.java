package br.desafiolecom.dao;

import java.util.List;

import org.hibernate.Session;

import br.desafiolecom.bean.Cliente;
import br.desafiolecom.db.HibernateUtil;

public class ClienteDAO extends HibernateUtil {

	public boolean inserirCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean editarCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.merge(cliente);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean excluirCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(cliente);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscaTodosClientes() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			org.hibernate.Query pesquisa = session.createQuery("FROM Cliente ");
			List<Cliente> list = (List<Cliente>) pesquisa.list();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}
