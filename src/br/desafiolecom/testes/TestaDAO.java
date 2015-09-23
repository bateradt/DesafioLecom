package br.desafiolecom.testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.desafiolecom.bean.Cliente;
import br.desafiolecom.bean.OrdemServico;
import br.desafiolecom.bean.Servico;
import br.desafiolecom.dao.ClienteDAO;
import br.desafiolecom.dao.OrdemServicoDAO;
import br.desafiolecom.dao.ServicoDAO;

import com.google.gson.Gson;

public class TestaDAO {

	public static void main(String[] args) {
		// chamaTestesDAO();
		// chamaListaServicos();
		// gravaOS();
		chamaListaOrdemServicos();
	}

	private static void chamaListaServicos() {
		ServicoDAO servicoDAO = new ServicoDAO();
		List<Servico> lista = new ArrayList<Servico>();
		Gson json = new Gson();
		String retorno = "";

		lista = servicoDAO.buscaTodosServicos();
		for (Servico ser : lista) {
			retorno = retorno + (json.toJson(ser));
			// System.out.println("Serviço " + ser.getDescricao() + " Valor: "
			// + ser.getValor().toString());
		}
		System.out.println(retorno);
	}

	private static void chamaListaOrdemServicos() {
		OrdemServicoDAO osDAO = new OrdemServicoDAO();
		List<OrdemServico> lista = new ArrayList<OrdemServico>();
		Date data = new Date();
		lista = osDAO.buscaTodasOrdemServico();
		for (OrdemServico os : lista) {

			System.out.println("Faltam  "
					+ Double.valueOf(OrdemServicoDAO.retornaDiasParaFimDaOS(os
							.getDataFinal())) + " dias para o fim da O.S "
					+ os.getId().toString());

			System.out.println(" NOVO Faltam  "
					+ OrdemServicoDAO.dataDiff(data, os.getDataFinal())
					+ " dias para o fim da O.S " + os.getId().toString());
		}

	}

	private static void chamaTestesDAO() {
		ClienteDAO cliDAO = new ClienteDAO();
		ServicoDAO serDAO = new ServicoDAO();
		OrdemServicoDAO osDAO = new OrdemServicoDAO();

		Cliente cli1 = new Cliente();
		cli1.setNome("MARCELO");
		cli1.setDocumento("123.456.789-00");
		cli1.setEmail("marcelo@gmail.com");

		cliDAO.inserirCliente(cli1);

		Cliente cli2 = new Cliente();
		cli2.setNome("TESTE");
		cli2.setDocumento("999.999.999-00");
		cli2.setEmail("teste@gmail.com");

		cliDAO.inserirCliente(cli2);

		Cliente cli3 = new Cliente();
		cli3.setId(1L);
		cli3.setNome("TESTE ALTERADO");
		cli3.setDocumento("999.999.999-00");
		cli3.setEmail("teste@gmail.com");

		cliDAO.editarCliente(cli3);

		// Cliente cli4 = new Cliente();
		// cli4.setId(3L);
		// cliDAO.excluirCliente(cli4);

		List<Cliente> list = new ArrayList<Cliente>();
		list = cliDAO.buscaTodosClientes();
		if (list != null) {
			for (Cliente cli : list) {
				System.out.println("Cliente : " + cli.getNome()
						+ " Documento: " + cli.getDocumento() + " E-mail: "
						+ cli.getEmail());
			}
		}
		/***************************************************/

		Servico ser1 = new Servico();
		ser1.setDescricao("DESENVOLVIMENTO DE SOFTWARE");
		ser1.setValor(1000.00);

		serDAO.inserirServico(ser1);

		Servico ser2 = new Servico();
		ser2.setDescricao("ANALISE DE SISTEMAS");
		ser2.setValor(2000.00);

		serDAO.inserirServico(ser2);

		Servico ser3 = new Servico();
		ser3.setId(1L);
		ser3.setDescricao("ANALISE DE SISTEMAS NOVO");
		ser3.setValor(3000.00);

		serDAO.editarServico(ser3);

		// Servico ser4 = new Servico();
		// ser4.setId(3L);
		// serDAO.excluirServico(ser4);

		List<Servico> listSer = new ArrayList<Servico>();
		listSer = serDAO.buscaTodosServicos();
		if (listSer != null) {
			for (Servico ser : listSer) {
				System.out.println("Servico : " + ser.getDescricao()
						+ " Valor: " + ser.getValor().toString());
			}
		}

		Date data = new Date();
		OrdemServico os1 = new OrdemServico();
		os1.setCliente(cli1);
		os1.setServicos(ser1);

		os1.setDataInicial(data);
		data.setDate(data.getDate() + 30);
		os1.setDataFinal(data);

		osDAO.inserirOrdemServico(os1);
	}

	private static void gravaOS() {
		OrdemServicoDAO osDAO = new OrdemServicoDAO();

		Cliente cli1 = new Cliente();
		cli1.setId(1L);

		Servico ser3 = new Servico();
		ser3.setId(1L);

		Date data = new Date();
		Date datai = new Date();
		OrdemServico os1 = new OrdemServico();
		os1.setCliente(cli1);
		os1.setServicos(ser3);

		os1.setDataInicial(datai);

		data.setDate(data.getDate() + 30);
		os1.setDataFinal(data);

		osDAO.inserirOrdemServico(os1);
	}

}
