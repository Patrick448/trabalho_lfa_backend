/**
 * Classe para a criacao de um automato finito deterministico
 * @author Fabio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jose Melquiades
 * @author Claudio Soares Junior, Gildo
 */

package lfa.trabalho_lfa.afds;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class AFD {
	private ConjuntoSimbolo simbolos;
	private ConjuntoEstados estados;
	private ConjuntoEstados estadosFinais;
	private ConjuntoTransicaoD funcaoPrograma;
	private Estado estadoInicial;
	
	/**
	 * Metodo construtor de um Automato finito deterministico
	 * 
	 * @param simbolos
	 *            ConjuntoSimbolo que representa o alfabeto do automato finito
	 *            deterministico
	 * @param estados
	 *            ConjuntoEstados que representa o conjunto de estados do
	 *            automato finito deterministico
	 * @param funcaoPrograma
	 *            ConjuntoTransicaoD que representa a funcao programa do
	 *            automato finito deterministico
	 * @param estadoInicial
	 *            Estado que representa o estado inicial do automato finito
	 *            deterministico
	 * @param estadosFinais
	 *            ConjuntoEstados que representa o conjunto de estados finais do
	 *            automato finito deterministico
	 */
	public AFD(ConjuntoSimbolo simbolos, ConjuntoEstados estados,
			ConjuntoTransicaoD funcaoPrograma, Estado estadoInicial,
			ConjuntoEstados estadosFinais) {
		this.simbolos = simbolos.clonar();
		this.estados = estados.clonar();
		this.funcaoPrograma = funcaoPrograma.clonar();
		this.estadoInicial = estadoInicial.clonar();
		this.estadosFinais = estadosFinais.clonar();
	}
	public AFD() {
		simbolos = new ConjuntoSimbolo();
		estados = new ConjuntoEstados();
		estadosFinais = new ConjuntoEstados();
		funcaoPrograma = new ConjuntoTransicaoD();
	}
	/**
	 * Obt�m o estado inicial do aut�mato finito determin�stico
	 * 
	 * @return estadoInicial - Estado que representa o estado inicial do
	 *         aut�mato finito determin�stico
	 */
	public Estado getEstadoInicial() {
		return this.estadoInicial.clonar();
	}
	/**
	 * Ajusta o estado inicial do aut�mato finito determin�stico para o valor
	 * passado como par�metro
	 * 
	 * @param estadoInicial
	 *            um Estado a ser definido como estado inicial do aut�mato
	 *            finito determin�stico
	 */
	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial.clonar();
	}
	/**
	 * Obt�m o conjunto de estados do aut�mato finito determin�stico
	 * 
	 * @return estados - ConjuntoEstados que representa o conjunto de estados do
	 *         aut�mato finito determin�stico
	 */
	public ConjuntoEstados getEstados() {
		return this.estados.clonar();
	}
	/**
	 * Ajusta o conjunto de estados do aut�mato finito determin�stico para o
	 * valor passado como par�metro
	 * 
	 * @param estados
	 *            um ConjuntoEstados a ser definido como o conjunto de estados
	 *            do aut�mato finito determin�stico
	 */
	public void setEstados(ConjuntoEstados estados) {
		this.estados = estados.clonar();
	}
	/**
	 * Obt�m o conjunto de estados finais do aut�mato finito determin�stico
	 * 
	 * @return estadosFinais - ConjuntoEstados que representa o conjunto de
	 *         estados finais do aut�mato finito determin�stico
	 */
	public ConjuntoEstados getEstadosFinais() {
		return this.estadosFinais.clonar();
	}
	/**
	 * Ajusta o conjunto de estados finais do aut�mato finito determin�stico
	 * para o valor passado como par�metro
	 * 
	 * @param estadosFinais
	 *            um ConjuntoEstados a ser definido como o conjunto de estados
	 *            finais do aut�mato finito determin�stico
	 */
	public void setEstadosFinais(ConjuntoEstados estadosFinais) {
		this.estadosFinais = estadosFinais.clonar();
	}
	/**
	 * Obt�m a fun��o programa do aut�mato finito determin�stico
	 * 
	 * @return funcaoPrograma - ConjuntoTransicaoD que representa a fun��o
	 *         programa do aut�mato finito determin�stico
	 */
	public ConjuntoTransicaoD getFuncaoPrograma() {
		return this.funcaoPrograma.clonar();
	}
	/**
	 * Ajusta a fun��o programa do aut�mato finito determin�stico para o valor
	 * passado como par�metro
	 * 
	 * @param funcaoPrograma
	 *            um ConjuntoTransicaoD a ser definido como a fun��o programa do
	 *            aut�mato finito determin�stico
	 */
	public void setFuncaoPrograma(ConjuntoTransicaoD funcaoPrograma) {
		this.funcaoPrograma = funcaoPrograma.clonar();
	}
	/**
	 * Obt�m o alfabeto do aut�mato finito determin�stico
	 * 
	 * @return simbolos - ConjuntoSimbolo que representa o alfabeto do aut�mato
	 *         finito determin�stico
	 */
	public ConjuntoSimbolo getSimbolos() {
		return this.simbolos.clonar();
	}
	/**
	 * Ajusta o alfabeto do aut�mato finito determin�stico para o valor passado
	 * como par�metro
	 * 
	 * @param simbolos
	 *            um ConjuntoSimbolo a ser definido como o alfabeto do aut�mato
	 *            finito determin�stico
	 */
	public void setSimbolos(ConjuntoSimbolo simbolos) {
		this.simbolos = simbolos.clonar();
	}
	/**
	 * Cria e retorna uma c�pia do objeto AFD
	 * 
	 * @return um clone desse AFD
	 */
	public AFD clonar() {
		return new AFD(simbolos, estados, funcaoPrograma, estadoInicial,
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
	 * Le as informaoces de um AFN em um arquivo XML passado como parametro
	 * 
	 * @param pathArquivo
	 *            define o arquivo de onde será lido as informacoes do automato
	 * @return retorna o automato lido
	 */

	/**
	 * Le as informaoces de um AFN em um arquivo XML passado como parametro
	 *
	 * @param xml
	 *            texto xml de onde será lido as informacoes do automato
	 * @return retorna o automato lido
	 */


	public void lerString(String xml) throws Exception {
		//String xmlPathname = pathArquivo;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));

		Document doc = db.parse(is);

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
		TransicaoD transD = new TransicaoD();
		NodeList children = elem.getElementsByTagName(tagName);
		if (children != null) {
			for (int i = 0; i < children.getLength(); i++) {
				Element child = (Element) children.item(i);
				if (child != null) {
					transD.setOrigem(new Estado(child.getAttribute("origem")));
					transD.setDestino(new Estado(child.getAttribute("destino")));
					char[] c = child.getAttribute("simbolo").toCharArray();
					transD.setSimbolo(new Simbolo(c[0]));
                                        //int a =  Integer.parseInt(child.getAttribute("acao"));                                       
					funcaoPrograma.inclui(transD);
				}
			}
		}
	}
	// Limpa a estrutura de dados do AFD
	private void limpa() {
		// limpa Alfabeto
		simbolos.limpar();
		// limpa conjunto de estados
		estados.limpar();
		// limpa Funcao Programa
		funcaoPrograma.limpar();
		// Limpa estados finais
		estadosFinais.limpar();
	}
	 
	/**
	*Fun��o Programa
	* @return estado alcan�avel depois de processar o Simbolo s a partir de estados e 
	* @param e onde iniciar� o processamento
	* @param s a ser processado
	*/
	public Estado p (Estado e, Simbolo s){
		ConjuntoTransicaoD fp;
		TransicaoD t;
		fp = getFuncaoPrograma();
		for (Iterator iter = fp.getElementos().iterator(); iter.hasNext();) {
			t = (TransicaoD) iter.next();
			if (t.getOrigem().igual(e) && t.getSimbolo().igual(s))
				return t.getDestino();
		}
		
		return null;
	}
	/**
	*Fun��o Programa Estendida	
	* @return estado alcan�avel depois de processar a palavra p a partir de um estados e 
	* @param e onde iniciar� o processamento
	* @param p a ser processada
	*/
	public Estado pe (Estado e, String p){
		Estado eAtual = e;
		Simbolo s;
		int i = 0;
		while (i < p.length()) {
			s = new Simbolo(p.charAt(i));
			eAtual = p(eAtual,s);
			if (eAtual == null) return null;
			i++;
		}
		return eAtual;
	}
	/**
	*Retorna se uma palavra � aceita ou n�o por determinado AFD
	* @return true caso a palavra � aceita; false caso contr�rio 
	* @param  p palavra a ser avaliada
	*/
	public boolean Aceita(String p) {
		return getEstadosFinais().pertence(pe(getEstadoInicial(),p));
	}
	/*
	 * Cria arquivo XML do AFD com nome de filename.xml
	 * 
	 * @param filename Nome do arquivo XML que será criado sem a extensão.
	 */
	public void toXML(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename + ".xml");
        PrintWriter saida = new PrintWriter(writer);

        saida.println("<AFD>");
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
        for (Iterator iter = this.getFuncaoPrograma().getElementos().iterator(); iter.hasNext();) {
            TransicaoD element = (TransicaoD) iter.next();
            saida.println("\t\t<elemento origem= \""
                    + element.getOrigem().toString() + "\" destino= \""
                    + element.getDestino().toString() + "\" simbolo= \""
                    + element.getSimbolo().toString() + "\"/>");
        }
        saida.println("\t</funcaoPrograma>");
        saida.println();
        
        saida.println("\t<estadoInicial valor= \"" + this.getEstadoInicial().toString() + "\"/>");
        saida.println();

        saida.println("</AFD>");

        saida.close();
        writer.close();
    }


	public String toDotLanguageString(){
		String s = "digraph G { bgcolor=transparent; node[shape=circle]; ";

		s+="start -> "+estadoInicial.toString()+"; start [shape=point, style=invis];";
		for(Object e : estadosFinais.getElementos()){
			s+=e.toString() +"[shape=doublecircle];";
		}
		/*for(Object e : estados.getElementos()){
			s+=e.toString() +" ;";
		}	*/

		for(Object o : this.getFuncaoPrograma().getElementos()){
			TransicaoD t = (TransicaoD)o;
			s+=t.getOrigem() + "->"+t.getDestino()+"[label=\""+ t.getSimbolo()+"\"];";
		}

		s+="}";

		return s;
	}
}
