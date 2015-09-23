package br.desafiolecom.principal;

import br.desafiolecom.db.HibernateUtil;

public class CriaBanco {

	public static void main(String[] args) {
		HibernateUtil.atualizarBD();
	}

}
