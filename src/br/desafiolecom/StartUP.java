package br.desafiolecom;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;

import br.desafiolecom.db.HibernateUtil;

public class StartUP extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	public StartUP() {

		HibernateUtil.atualizarBD();

	}

}
