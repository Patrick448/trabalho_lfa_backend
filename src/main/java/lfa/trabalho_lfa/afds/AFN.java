
package lfa.trabalho_lfa.afds;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * Classe para a criacao de um automato finito n�o-determin�stico
 * 
 * @author Fabio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */

public class AFN {

	private ConjuntoSimbolo simbolos;
	private ConjuntoEstados estados;
	private ConjuntoEstados estadosFinais;
	private ConjuntoEstados cestadoInicial;
	private ConjuntoTransicaoN funcaoPrograma;
	private Estado estadoInicial;

	/**
	 * Metodo construtor de um Automato finito deterministico
	 * 
	 * @param simbolos
	 *            ConjuntoSimbolo que representa o alfabeto do automato finito
	 *            deterministico
	 * @param estados
	 *            ConjuntoEstados que representa o conjunto de estados do
	 *            automato finito determinostico
	 * @param funcaoPrograma
	 *            ConjuntoTransicaoD que representa a funcao programa do
	 *            automato finito deterministico
	 * @param estadoInicial
	 *            Estado que representa o estado inicial do automato finito
	 *            deterministico
	 * @param estadosFinais
	 *            ConjuntoEstados que representa o conjunto de estados finais do
	 *            automato finito nao-deterministico
	 */
	public AFN(ConjuntoSimbolo simbolos, ConjuntoEstados estados,
			ConjuntoTransicaoN funcaoPrograma, Estado estadoInicial,
			ConjuntoEstados estadosFinais) {

		this.simbolos = simbolos.clonar();
		this.estados = estados.clonar();
		this.funcaoPrograma = funcaoPrograma.clonar();
		this.estadoInicial = estadoInicial.clonar();
		this.estadosFinais = estadosFinais.clonar();
	}

        public AFN(){
		simbolos = new ConjuntoSimbolo();
		estados = new ConjuntoEstados();
		estadosFinais = new ConjuntoEstados();
		funcaoPrograma = new ConjuntoTransicaoN();
	}

	/**
	 * Obtem o estado inicial do automato finito nao-deterministico
	 * 
	 * @return estadoInicial - Estado que representa o estado inicial do
	 *         aut�mato finito n�o-determin�stico
	 */
	public Estado getEstadoInicial() {
		return estadoInicial.clonar();
	}

	/**
	 * Ajusta o estado inicial do aut�mato finito n�o-determin�stico para o
	 * valor passado como par�metro
	 * 
	 * @param estadoInicial
	 *            um Estado a ser definido como estado inicial do aut�mato
	 *            finito n�o-determin�stico
	 */
	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial.clonar();
	}

	/**
	 * Obt�m o conjunto de estados finais do aut�mato finito n�o-determin�stico
	 * 
	 * @return estados - ConjuntoEstados que representa o conjunto de estados
	 *         finais do aut�mato finito n�o-determin�stico
	 */
	public ConjuntoEstados getEstados() {
		return estados.clonar();
	}

	/**
	 * Ajusta o conjunto de estados do aut�mato finito n�o-determin�stico para o
	 * valor passado como par�metro
	 * 
	 * @param estados
	 *            um ConjuntoEstados a ser definido como o conjunto de estados
	 *            do aut�mato finito n�o-determin�stico
	 */
	public void setEstados(ConjuntoEstados estados) {
		this.estados = estados.clonar();
	}

	/**
	 * Obt�m o conjunto de estados finais do aut�mato finito n�o-determin�stico
	 * 
	 * @return estadosFinais - ConjuntoEstados que representa o conjunto de
	 *         estados finais do aut�mato finito n�o-determin�stico
	 */
	public ConjuntoEstados getEstadosFinais() {
		return estadosFinais.clonar();
	}

	/**
	 * Ajusta o conjunto de estados finais do aut�mato finito n�o-determin�stico
	 * para o valor passado como par�metro
	 * 
	 * @param estadosFinais
	 *            um ConjuntoEstados a ser definido como o conjunto de estados
	 *            finais do aut�mato finito n�o-determin�stico
	 */
	public void setEstadosFinais(ConjuntoEstados estadosFinais) {
		this.estadosFinais = estadosFinais.clonar();
	}

	/**
	 * Obt�m a fun��o programa do aut�mato finito n�o-determin�stico
	 * 
	 * @return funcaoPrograma - ConjuntoTransicaoN que representa a fun��o
	 *         programa do aut�mato finito n�o-determin�stico
	 */
	public ConjuntoTransicaoN getFuncaoPrograma() {
		return funcaoPrograma.clonar();
	}

	/**
	 * Ajusta a fun��o programa do aut�mato finito n�o-determin�stico para o
	 * valor passado como par�metro
	 * 
	 * @param funcaoPrograma
	 *            um ConjuntoTransicaoN a ser definido como a fun��o programa do
	 *            aut�mato finito n�o-determin�stico
	 */
	public void setFuncaoPrograma(ConjuntoTransicaoN funcaoPrograma) {
		this.funcaoPrograma = funcaoPrograma.clonar();
	}

	/**
	 * Obt�m o alfabeto do aut�mato finito n�o-determin�stico
	 * 
	 * @return simbolos - ConjuntoSimbolo que representa o alfabeto do aut�mato
	 *         finito n�o-determin�stico
	 */
	public ConjuntoSimbolo getSimbolos() {
		return simbolos.clonar();
	}

	/**
	 * Ajusta o alfabeto do aut�mato finito n�o-determin�stico para o valor
	 * passado como par�metro
	 * 
	 * @param simbolos
	 *            um ConjuntoSimbolo a ser definido como o alfabeto do aut�mato
	 *            finito n�o-determin�stico
	 */
	public void setSimbolos(ConjuntoSimbolo simbolos) {
		this.simbolos = simbolos.clonar();
	}

	/**
	 * Cria e retorna uma copia do objeto AFN
	 * 
	 * @return um clone desse AFN
	 */
	public AFN clonar() {
		return new AFN(simbolos, estados, funcaoPrograma, estadoInicial,
				estadosFinais);
	}

	public String toString() {
		String s = new String();
		s += "(";
		s += simbolos.toString();
		s += ",";
		s += estados.toString();
		s += ",";
		s += this.getFuncaoPrograma().toString();
		s += ",";
		s += estadoInicial.toString();
		s += ",";
		s += estadosFinais.toString();
		s += ")";
		return s;
	}

	/**
	 * Funcao Programa
	 * 
	 * @return conjunto de estados alcancaveis depois de processar o Simbolo s a
	 *         partir de estados e
	 * @param Estado
	 *            estado onde iniciara o processamento
	 * @param Simbolo
	 *            simbolo a ser processado
	 */

	public ConjuntoEstados p(Estado e, Simbolo s) {
		ConjuntoTransicaoN fp;
		TransicaoN t;
		fp = getFuncaoPrograma();
		for (Iterator iter = fp.getElementos().iterator(); iter.hasNext();) {
			t = (TransicaoN) iter.next();
			if (t.getOrigem().igual(e) && t.getSimbolo().igual(s))
				return t.getDestino();
		}

		ConjuntoEstados cevazio = new ConjuntoEstados();
		return cevazio;
	}

	/**
	 * Fun��o Programa Estendida
	 * 
	 * @return conjunto de estados alcan�aveis depois de processar a palavra p a
	 *         partir de um conjunto de estados
	 * @param ConjuntoEstados
	 *            Conjunto de estados onde iniciar� o processamento
	 * @param String
	 *            palavra a ser processada
	 */
	public ConjuntoEstados pe(ConjuntoEstados e, String p) {
		if (p.equals("")) {
			return e;
		} else {
			ConjuntoEstados enovo = new ConjuntoEstados();
			Simbolo s = new Simbolo(p.charAt(0));
			for (Iterator iter = e.iterator(); iter.hasNext();) {
				Estado est = (Estado) iter.next();
				enovo = enovo.uniao(p(est, s));
			}
			return pe(enovo, p.substring(1));
		}
	}

	/**
	 * Retorna se uma palavra � aceita ou n�o por determinado AFN
	 * 
	 * @return true caso a palavra � aceita; false caso contr�rio
	 * @param String
	 *            palavra a ser avaliada
	 */
	public boolean Aceita(String p) {
		cestadoInicial = new ConjuntoEstados();
		cestadoInicial.inclui(getEstadoInicial());
		ConjuntoEstados cestadoFinal = getEstadosFinais();
		for (Iterator iter = pe(cestadoInicial, p).iterator(); iter.hasNext();) {
			Estado e = (Estado) iter.next();
			if (cestadoFinal.pertence(e))
				return true;
		}

		return false;
	}

	/**
	 * Converte um AFN para um AFD
	 * 
	 * @return retorna o AFD equivalente
	 */
	public AFD toAFD() {

		// Paramentros para criar o novo AFD
		ConjuntoSimbolo novoCsi = this.getSimbolos().clonar();
		ConjuntoEstados novoCe = new ConjuntoEstados();
		ConjuntoTransicaoD novoCtD = new ConjuntoTransicaoD();
		//Estado novoEi = this.getEstadoInicial().clonar();
                // "<" e ">" utilizado para o nome do estado ficar do tipo <estados>
                Estado novoEi = new Estado("<" + this.getEstadoInicial().toString() + ">");
		ConjuntoEstados novoCef = new ConjuntoEstados();
		Estado novoE = new Estado();
		TransicaoD novaTD;

		// Conjunto de estados finais atual
		ConjuntoEstados atualCef = this.getEstadosFinais();

		// Parametros para o controle de fluxo do algoritmo
		ConjuntoConjuntoEstados cceAtual = new ConjuntoConjuntoEstados();
		ConjuntoEstados ceAtual = new ConjuntoEstados();
		Estado eAtual = this.getEstadoInicial().clonar();
		Simbolo siAtual;

		// Parametro temporario necessario para criacao do novo Estado
		ConjuntoEstados ceTemp;

		// Inclusao do estado inicial
		ceAtual.inclui(eAtual);
		cceAtual.inclui(ceAtual);

                // Inclusão no conjunto de estados finais
                if (atualCef.pertence(eAtual))
                        novoCef.inclui(novoEi);

		novoCe.inclui(novoEi);



		// Iteracao sobre os conjuntos de estados que serao analizados
		Iterator iterCce = cceAtual.iterator();
		// Enquanto houver estado para analisar
		while (iterCce.hasNext()) {
			ceAtual = (ConjuntoEstados) iterCce.next();
			// Remove o elemento do Conjunto de analis�veis pois este ser�
			// analizado
			cceAtual.removerElemento(ceAtual);
			// Renova o parametro temporario
			ceTemp = new ConjuntoEstados();

			// parametro para verificar se o estado vai pertencer ao conjunto de
			// estados finais
			boolean efinal = false;

			// Iteracao sobre o conjunto de simbolos do Alfabeto
			for (Iterator iterSi = novoCsi.iterator(); iterSi.hasNext();) {
				siAtual = (Simbolo) iterSi.next();

				// Itera��o sobre os Estados que formam o estado atual
				ceTemp = new ConjuntoEstados();
				for (Iterator iterCe = ceAtual.iterator(); iterCe.hasNext();) {
					eAtual = (Estado) iterCe.next();
					// Novo estado ser� a uni�o de todos o retorno da fun��o
					// programa para um determinado simbolo
					ceTemp = ceTemp.uniao(p(eAtual, siAtual));

				}

				// Verifica se a uni�o � vazia
				if (!ceTemp.vazio()) {
					// nome do novo estado
					String novoNome = ceTemp.toString();
					// retira as { } presentes no inicio e no final do nome
					novoNome = novoNome.substring(1, novoNome.length() - 1);
					// insere o < e >
					novoE = new Estado("<" + novoNome + ">");

					// Verifica se o estado vai pertencer ao Conjunto de estados
					// finais
					for (Iterator iterEFinal = ceTemp.iterator(); iterEFinal
							.hasNext();) {
						if (atualCef.pertence((Estado) iterEFinal.next()))
							efinal = true;
					}

					// Se no novo Conjunto de Estados n�o houver nenhum estado
					// igual ao novo
					// inclui o novo estado e cria nova transi��o
					if (!novoCe.pertence(novoCe.retornaIgual(novoE))) {

						novoCe.inclui(novoE);

						// Se for estado final inclui no conjunto de estados
						// finais
						if (efinal) {
							novoCef.inclui(novoE);
							efinal = false;
						}

						// Cria nova transi��oD
						novaTD = new TransicaoD();
						String nomeOrigem = ceAtual.toString();
						nomeOrigem = "<"
								+ nomeOrigem.substring(1,
										nomeOrigem.length() - 1) + ">";
						// Busca origem j� exitente no novo Conjunto de Estados
						Estado novaOrigem = novoCe.retornaIgual(new Estado(
								nomeOrigem));
						novaTD.setOrigem(novaOrigem);
						novaTD.setSimbolo(siAtual);
						novaTD.setDestino(novoE);

						novoCtD.inclui(novaTD.clonar());

						cceAtual.inclui(ceTemp);

					}

					// Caso j� exista estado igual no novo conjunto de estados
					// Cria somente nova transi��o
					else {
						novaTD = new TransicaoD();
						String nomeOrigem = ceAtual.toString();
						nomeOrigem = "<"
								+ nomeOrigem.substring(1,
										nomeOrigem.length() - 1) + ">";
						Estado novaOrigem = novoCe.retornaIgual(new Estado(
								nomeOrigem));
						novaTD.setOrigem(novaOrigem);
						novaTD.setSimbolo(siAtual);
						novaTD.setDestino(novoE);

						novoCtD.inclui(novaTD.clonar());

					}
				}

			}

			// Atualiza o iterator pois foi retirado o elemento que j� foi
			// analizado
			iterCce = cceAtual.iterator();
		}

		// Cria o novo AFD
		AFD novoAFD = new AFD(novoCsi, novoCe, novoCtD, novoEi, novoCef);
		return novoAFD;
	}

	/*
	 * Cria arquivo XML do AFN com nome de filename.xml
	 * 
	 * @param filename Nome do arquivo XML que será criado sem a extensão.
	 */
	public void toXML(String filename) throws IOException {
		FileWriter writer = new FileWriter(filename + ".xml");
		PrintWriter saida = new PrintWriter(writer);

		saida.println("<AFN>");
		saida.println();

		saida.println("\t<simbolos>");
		for (Object s : this.getSimbolos().getElementos()) {
			saida.println("\t\t<elemento valor= \"" + s.toString() + "\"/>");
		}
		saida.println("\t</simbolos>");
		saida.println();

		saida.println("\t<estados>");
		for (Object s : this.getEstados().getElementos()) {
			saida.println("\t\t<elemento valor= \"" + s.toString() + "\"/>");
		}
		saida.println("\t</estados>");
		saida.println();

		saida.println("\t<estadosFinais>");
		for (Object s : this.getEstadosFinais().getElementos()) {
			saida.println("\t\t<elemento valor= \"" + s.toString() + "\"/>");
		}
		saida.println("\t</estadosFinais>");
		saida.println();

		saida.println("\t<funcaoPrograma>");
		for (Iterator iter = this.getFuncaoPrograma().getElementos().iterator(); iter
				.hasNext();) {
			TransicaoN element = (TransicaoN) iter.next();
			ConjuntoEstados estados = element.getDestino();
			for (Iterator iterator = estados.getElementos().iterator(); iterator
					.hasNext();) {
				Estado e = (Estado) iterator.next();
				saida.println("\t\t<elemento origem= \""
						+ element.getOrigem().toString() + "\" destino= \""
						+ e.toString() + "\" simbolo= \""
						+ element.getSimbolo().toString() + "\"/>");
			}
		}
		saida.println("\t</funcaoPrograma>");
		saida.println();

		saida.println("\t<estadoInicial valor= \""
				+ this.getEstadoInicial().toString() + "\"/>");
		saida.println();

		saida.println("</AFN>");

		saida.close();
		writer.close();
	}

        /**
	* Le as informaoces de um AFN em um arquivo XML passado como parametro
	*
	* @param pathArquivo
	*            define o arquivo de onde será lido as informacoes do automato
	* @return retorna o automato lido
	*/

	public void ler(String pathArquivo) throws Exception {
		String xmlPathname = pathArquivo;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlPathname);

		Element elem = doc.getDocumentElement();
		NodeList nl0 = elem.getElementsByTagName("simbolos");
		NodeList nl1 = elem.getElementsByTagName("estados");
		NodeList nl2 = elem.getElementsByTagName("estadosFinais");
		NodeList nl3 = elem.getElementsByTagName("funcaoPrograma");
		NodeList nl4 = elem.getElementsByTagName("estadoInicial");

		getChildTagValue(0, (Element) nl0.item(0), "elemento");
		getChildTagValue(1, (Element) nl1.item(0), "elemento");
		getChildTagValue(2, (Element) nl2.item(0), "elemento");
		Element eI = (Element) nl4.item(0);
		estadoInicial = new Estado(eI.getAttribute("valor"));

		getChildTagValue((Element) nl3.item(0), "elemento");

	}
	private void getChildTagValue(int tipo, Element elem, String tagName)
			throws Exception {
		NodeList children = elem.getElementsByTagName(tagName);

		if (children != null) {
			for (int i = 0; i < children.getLength(); i++) {
				Element child = (Element) children.item(i);

				if (child != null) {
					switch (tipo) {
					case 0:
						char[] c = child.getAttribute("valor").toCharArray();
						simbolos.inclui(new Simbolo(c[0]));
						break;
					case 1:
						estados.inclui(new Estado(child.getAttribute("valor")));
						break;
					case 2:
						estadosFinais.inclui(new Estado(child
								.getAttribute("valor")));
						break;
					}
				}
			}
		}
	}
	private void getChildTagValue(Element elem, String tagName)
			throws Exception {
		ConjuntoEstados ce = new ConjuntoEstados();
		TransicaoN transN, transTMP ;
		NodeList children = elem.getElementsByTagName(tagName);
		if (children != null) {
			for (int i = 0; i < children.getLength(); i++) {
				Element child = (Element) children.item(i);
				if (child != null) {
					transN = new TransicaoN();
					transN.setOrigem(new Estado(child.getAttribute("origem")));
					char[] c = child.getAttribute("simbolo").toCharArray();
					transN.setSimbolo(new Simbolo(c[0]));
					for (Iterator iter = funcaoPrograma.iterator(); iter.hasNext();) {
						transTMP = (TransicaoN) iter.next();
						if (transTMP.getOrigem().igual(transN.getOrigem()) &&
							transTMP.getSimbolo().igual(transN.getSimbolo())){
							transN.setDestino(transTMP.getDestino());
							funcaoPrograma.removerElemento(transTMP);
							break;
						}
					}
                                        ce = transN.getDestino();
					ce.inclui(new Estado(child.getAttribute("destino")));
					transN.setDestino(ce);
					funcaoPrograma.inclui(transN);
				}
			}
		}
	}

}
