package lfa.trabalho_lfa.afds;

/*
 * Classe que representa um conjunto de transicoes nao-deterministicas de um automato
 * @author Fabio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jose Melquiades
 */

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConjuntoTransicaoN {

	private Set elementos = new LinkedHashSet();

	/**
	 * Verifica se um conjunto de transi��es n�o determin�sticas est� ou n�o
	 * vazio
	 * 
	 * @return true se o conjunto de transi��es n�o determin�sticas estiver
	 *         vazio ou false caso contr�rio
	 * 
	 */
	public boolean vazio() {

		if (elementos.isEmpty()) {
			return true;
		}
		return false;

	}

	/**
	 * Inclui um elemento no final do conjunto de transi��es n�o-determin�sticas
	 * 
	 * @param elemento
	 *            TransicaoN a ser inserido no conjunto de transi��es
	 *            n�o-determin�sticas
	 */
	public void inclui(TransicaoN elemento) {
		elementos.add(elemento.clonar());
	}

	/**
	 * Verfica se uma TransicaoN pertence a um dado conjunto de transi��es
	 * n�o-determin�sticas
	 * 
	 * @param elemento
	 *            TransicaoN a ser verificado
	 * @return true se o TransicaoN pertence ao conjunto de transi��es
	 *         n�o-determin�sticas ou false caso contr�rio
	 */
	public boolean pertence(TransicaoN elemento) {

		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			TransicaoN transicaoD = (TransicaoN) iter.next();
			if (transicaoD.igual(elemento)) {
				return true;
			}
		}

		return false;

	}

	/**
	 * Realiza a uni�o entre dois conjuntos de transi��es n�o-determin�sticas
	 * 
	 * @param ce
	 *            um ConjuntoTransicaoN a ser unido a outro
	 * @return novoConjunto - ConjuntoTransicaoN resultante da uni�o
	 */
	public ConjuntoTransicaoN uniao(ConjuntoTransicaoN ce) {

		ConjuntoTransicaoN novoConjunto = new ConjuntoTransicaoN();
		novoConjunto = this.clonar();

		for (Iterator iter = ce.getElementos().iterator(); iter.hasNext();) {
			TransicaoN transicaoN = (TransicaoN) iter.next();

			if (!novoConjunto.pertence(transicaoN)) {
				novoConjunto.inclui(((transicaoN).clonar()));
			}

		}

		return novoConjunto;
	}

	/**
	 * Realiza a interse��o entre dois conjuntos de transi��es
	 * n�o-determin�sticas
	 * 
	 * @param ce
	 *            um ConjuntoTransicaoN a sofrer interse��o com outro
	 *            ConjuntoTransicaoN
	 * @return novoConjunto - ConjuntoTransicaoN resultante da uni�o
	 */
	public ConjuntoTransicaoN intersecao(ConjuntoTransicaoN ce) {

		ConjuntoTransicaoN novoConjunto = new ConjuntoTransicaoN();

		for (Iterator iter = ce.getElementos().iterator(); iter.hasNext();) {
			TransicaoN transicaoN = (TransicaoN) iter.next();

			if (pertence(transicaoN)) {
				novoConjunto.inclui(((transicaoN).clonar()));
			}

		}

		return novoConjunto;
	}

	/**
	 * Cria e retorna uma c�pia do objeto ConjuntotransicaoN
	 * 
	 * @return um clone desse ConjuntoTransicaoN
	 */
	public ConjuntoTransicaoN clonar() {

		ConjuntoTransicaoN novoConjunto = new ConjuntoTransicaoN();

		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			TransicaoN transicaoN = (TransicaoN) iter.next();
			novoConjunto.inclui(((transicaoN).clonar()));
		}

		return novoConjunto;
	}

	public boolean igual(ConjuntoTransicaoN ct) {

		boolean flag = true;
		ConjuntoTransicaoN aux = ct.clonar();

		for (Iterator iter = aux.getElementos().iterator(); iter.hasNext();) {
			TransicaoN transicaoN = (TransicaoN) iter.next();
			if (!this.pertence(transicaoN)) {
				flag = false;
			}

			if (flag == false) {
				break;
			}
		}

		if (!flag) {
			return false;
		}

		aux = this.clonar();

		for (Iterator iter = aux.getElementos().iterator(); iter.hasNext();) {
			TransicaoN transicaoN = (TransicaoN) iter.next();

			if (!ct.pertence(transicaoN)) {
				flag = false;
			}

			if (flag == false) {
				break;
			}

		}

		return flag;

	}

	public String toString() {

		String s = new String();
		ConjuntoTransicaoN tmp = this.clonar();
		int size = tmp.getElementos().size() - 1;
		s += "{";

		for (Iterator iter = tmp.getElementos().iterator(); iter.hasNext();) {
			TransicaoN transicaoN = (TransicaoN) iter.next();
			s += transicaoN.toString();

			if (size != 0) {
				s += ",";
			}

			size--;
		}

		s += "}";

		return s;

	}

	/**
	 * Retorna os elementos do conjunto de transi��oN
	 */
	public Set getElementos() {
		return elementos;
	}
	
	/**
	 * Retorna o iterator do conjunto de transi��oN
	 */
	public Iterator iterator() {
		return elementos.iterator();
	}
	
	/**
	 * Remove um elemento do conjunto	  
	 */
	public void removerElemento(TransicaoN t){
		elementos.remove(t);
	}

}