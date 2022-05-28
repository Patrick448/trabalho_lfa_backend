package lfa.trabalho_lfa.afds;

/**
 * Classe que representa um conjunto de transi��es determin�sticas de um aut�mato
 * @author F�bio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class ConjuntoTransicaoD {

	private Set elementos = new LinkedHashSet();


	/**
	 * Verifica se um conjunto de transi��es determin�sticas est� ou n�o vazio
	 * 
	 * @return true se o conjunto de transi��es determin�sticas estiver vazio ou
	 *         false caso contr�rio
	 * 
	 */
	public boolean vazio() {

		if (elementos.isEmpty()) {
			return true;
		}
		return false;

	}

	/**
	 * Limpa o conjunto de transi��oD
	 * 
	 */
	public void limpar() {
		elementos.clear();
	}

	/**
	 * Inclui um elemento no final do conjunto de transi��es determin�sticas
	 * 
	 * @param elemento
	 *            TransicaoD a ser inserido no conjunto de transi��es
	 *            determin�sticas
	 */
	public void inclui(TransicaoD elemento) {
		elementos.add(elemento.clonar());
	}

	/**
	 * Verfica se uma TransicaoD pertence a um dado conjunto de transi��es
	 * determin�sticas
	 * 
	 * @param elemento
	 *            TransicaoD a ser verificado
	 * @return true se o TransicaoD pertence ao conjunto de transi��es
	 *         determin�sticas ou false caso contr�rio
	 */
	public boolean pertence(TransicaoD elemento) {

		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			TransicaoD transicaoD = (TransicaoD) iter.next();
			if (transicaoD.igual(elemento)) {
				return true;
			}
		}

		return false;

	}

	/**
	 * Realiza a uni�o entre dois conjuntos de transi��es determin�sticas
	 * 
	 * @param ce-um
	 *            ConjuntoTransicaoD a ser unido a outro
	 * @return novoConjunto - ConjuntoTransicaoD resultante da uni�o
	 */
	public ConjuntoTransicaoD uniao(ConjuntoTransicaoD ce) {

		ConjuntoTransicaoD novoConjunto = new ConjuntoTransicaoD();
		novoConjunto = this.clonar();

		for (Iterator iter = ce.getElementos().iterator(); iter.hasNext();) {
			TransicaoD transicaoD = (TransicaoD) iter.next();

			if (!novoConjunto.pertence(transicaoD)) {
				novoConjunto.inclui(((transicaoD).clonar()));
			}

		}

		return novoConjunto;
	}

	/**
	 * Realiza a interse��o entre dois conjuntos de transi��es determin�sticas
	 * 
	 * @param ce
	 *            um ConjuntoTransicaoD a sofrer interse��o com outro
	 *            ConjuntoTransicaoD
	 * @return novoConjunto - ConjuntoTransicaoD resultante da interse��o
	 */
	public ConjuntoTransicaoD intersecao(ConjuntoTransicaoD ce) {

		ConjuntoTransicaoD novoConjunto = new ConjuntoTransicaoD();

		for (Iterator iter = ce.getElementos().iterator(); iter.hasNext();) {
			TransicaoD transicaoD = (TransicaoD) iter.next();

			if (pertence(transicaoD)) {
				novoConjunto.inclui(((transicaoD).clonar()));
			}

		}

		return novoConjunto;
	}

	/**
	 * Cria e retorna uma c�pia do objeto ConjuntoTransicaoD
	 * 
	 * @return um clone desse ConjuntoTransicaoD
	 */
	public ConjuntoTransicaoD clonar() {

		ConjuntoTransicaoD novoConjunto = new ConjuntoTransicaoD();

		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			TransicaoD transicaoD = (TransicaoD) iter.next();
			novoConjunto.inclui(((transicaoD).clonar()));
		}

		return novoConjunto;
	}

	/**
	 * Verifica se um conjunto de Transi��oD � igual a outro.
	 */
	public boolean igual(ConjuntoTransicaoD ct) {

		boolean flag = true;
		ConjuntoTransicaoD aux = ct.clonar();

		for (Iterator iter = aux.getElementos().iterator(); iter.hasNext();) {
			TransicaoD transicaoD = (TransicaoD) iter.next();
			if (!this.pertence(transicaoD)) {
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
			TransicaoD transicaoD = (TransicaoD) iter.next();

			if (!ct.pertence(transicaoD)) {
				flag = false;
			}

			if (flag == false) {
				break;
			}

		}

		return flag;

	}

	/**
	 * Esse m�todo tem como fun��o pegar todos os nomes dos elementos do
	 * conjunto e colocar em uma string.
	 * 
	 */
	public String toString() {

		String s = new String();
		ConjuntoTransicaoD tmp = this.clonar();
		int size = tmp.getElementos().size() - 1;
		s += "{";

		for (Iterator iter = tmp.getElementos().iterator(); iter.hasNext();) {
			TransicaoD transicaoD = (TransicaoD) iter.next();
			s += transicaoD.toString();

			if (size != 0) {
				s += ",";
			}

			size--;
		}

		s += "}";

		return s;

	}

	/**
	 * Retorna os elementos do conjunto de transi��oD
	 */
	public Set getElementos() {
		return elementos;
	}

	/**
	 * Retorna o iterator do conjunto de transi��oD
	 */
	public Iterator iterator() {
		return elementos.iterator();
	}
	
	/**
	 * Remove um elemento do conjunto	  
	 */
	public void removerElemento(TransicaoD t){
		elementos.remove(t);
	}
}
