package br.desafiolecom.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	public static SessionFactory session = null;

	private static void buildSession() {

		try {
			Configuration cfg = hibernateConfig();
			session = cfg.buildSessionFactory();

		} catch (Exception b) {
			b.printStackTrace();
			System.out.println("Ocorreu um erro \n" + b);
			throw new ExceptionInInitializerError();
		}
	}

	private static Configuration hibernateConfig() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		return cfg;
	}

	public static SessionFactory getSessionFactory() {
		if (session == null) {
			buildSession();
		}
		return session;
	}

	/**
	 * Atualiza o Schema do Banco de Dados
	 */
	public static void atualizarBD() {
		try {
			/*
			 * SchemaUpdate su = new SchemaUpdate(hibernateConfig());
			 * su.execute(true, true);
			 */
			buildSession();
		} catch (Exception e) {
		}
	}
}
