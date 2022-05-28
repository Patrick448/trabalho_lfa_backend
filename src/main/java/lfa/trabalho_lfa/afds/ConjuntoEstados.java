package lfa.trabalho_lfa.afds;

/**
 * Classe que representa um conjunto de estados de um aut�mato
 * @author F�bio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConjuntoEstados {

	private Set elementos = new LinkedHashSet();

	/**
	 * Verifica se um conjunto de estados est� ou n�o vazio
	 * 
	 * @return true se o conjunto de estados estiver vazio ou false caso
	 *         contr�rio
	 * 
	 */
	public boolean vazio() {

		if (elementos.isEmpty()) {
			return true;
		}

		return false;
	}

	/**
	 * Limpa o conjunto de estados
	 *
	 */
	public void limpar() {
		elementos.clear();
	}
	

	/**
	 * Inclui um elemento no final do conjunto de estados
	 * 
	 * @param elemento
	 *            Estado a ser inserido no conjunto de estados
	 */
	public void inclui(Estado elemento) {
		elementos.add(elemento.clonar());
	}

	
	/**
	 * Verfica se um Estado pertence a um dado conjunto de estados
	 * 
	 * @param elemento
	 *            Estado a ser verificado
	 * @return true se o Estado pertence ao conjunto de estados ou false caso
	 *         contr�rio
	 */
	public boolean pertence(Estado elemento) {
		if (elemento == null) return false;
		
		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			Estado estado = (Estado) iter.next();
			if (estado.igual(elemento)) {
				return true;
			}
		}

		return false;

	}
	
	
	/**
	 * Verfica se um Estado pertence a um dado conjunto de estados
	 * se j� pertence retorna o estado que j� esta contido no conjunto
	 * @param elemento
	 *            Estado a ser verificado
	 * @return Retorna o elemento pertencente ao Conjunto e igual ao parametro
	 */
	public Estado retornaIgual(Estado elemento) {
		if (elemento == null) return null;
		
		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			Estado estado = (Estado) iter.next();
			if (estado.igual(elemento)) {
				return estado;
			}
		}
		
		return null;

	}


	/**
	 * Realiza a uni�o entre dois conjuntos de estados
	 * 
	 * @param ce
	 *            um ConjuntoEstados a ser unido a outro
	 * @return novoConjunto - ConjuntoEstados resultante da uni�o
	 */
	public ConjuntoEstados uniao(ConjuntoEstados ce) {

		ConjuntoEstados novoConjunto = new ConjuntoEstados();

		novoConjunto = this.clonar();

		for (Iterator iter = ce.getElementos().iterator(); iter.hasNext();) {
			Estado estado = (Estado) iter.next();

			if (!novoConjunto.pertence(estado)) {
				novoConjunto.inclui(((estado).clonar()));
			}

		}

		return novoConjunto;
	}

	/**
	 * Realiza a interse��o entre dois conjuntos de estados
	 * 
	 * @param ce - um ConjuntoEstados a sofrer interse��o com outro
	 *            ConjuntoEstados
	 * @return novoConjunto - ConjuntoEstados resultante da interse��o
	 */
	public ConjuntoEstados intersecao(ConjuntoEstados ce) {

		ConjuntoEstados novoConjunto = new ConjuntoEstados();

		for (Iterator iter = ce.getElementos().iterator(); iter.hasNext();) {
			Estado estado = (Estado) iter.next();

			if (pertence(estado)) {
				novoConjunto.inclui(((estado).clonar()));
			}

		}

		return novoConjunto;
	}

	/**
	 * Cria e retorna uma c�pia do objeto ConjuntoEstados
	 * 
	 * @return um clone desse ConjuntoEstados
	 */
	public ConjuntoEstados clonar() {
		ConjuntoEstados novoConjunto = new ConjuntoEstados();

		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			Estado estado = (Estado) iter.next();
			novoConjunto.inclui(((estado).clonar()));
		}

		return novoConjunto;
	}

	/**
	 * Verifica se dois conjuntos s�o iguais
	 */
	public boolean igual(ConjuntoEstados ce) {
		
		boolean flag = true;
		ConjuntoEstados aux = ce.clonar();

		for (Iterator iter = aux.getElementos().iterator(); iter.hasNext();) {
			Estado e = (Estado) iter.next();
			if (!this.pertence(e)) {
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
			Estado e = (Estado) iter.next();

			if (!ce.pertence(e)) {
				flag = false;
			}

			if (flag == false) {
				break;
			}

		}

		return flag;
	
	}

	/**
	 *Esse m�todo tem como fun��o
	 *pegar todos os nomes dos elementos do conjunto
	 *e colocar em uma string.
	 *
	 */
	public String toString() {
		
		String s = new String();
		ConjuntoEstados tmp = this.clonar();
		int size = tmp.getElementos().size() - 1;
		s += "{";

		for (Iterator iter = tmp.getElementos().iterator(); iter.hasNext();) {
			Estado e = (Estado) iter.next();
			s += e.toString();
			if (size != 0) {
				s += ",";
			}
			size--;
		}

		s += "}";
		if (s==null) s = "{}";
		return s;

	}

	/**
	 * Retorna os elementos do conjunto de
	 * estados
	 * 
	 */
	public Set getElementos() {
		return elementos; 
	}
	
	/**
	 * Retorna o tamanho do Conjunto
	 * @return tamanho do conjunto
	 */
	public int size(){
		return elementos.size();
	}
	
	
	/**
	 * Retorna o iterator do conjunto de
	 * estados
	 * 
	 */
	public Iterator iterator(){
		return elementos.iterator();
	}
	
	/**
	 * Remove um elemento do conjunto
	 * 
	 */
	public void removerElemento(Estado e){
		elementos.remove(e);
	}
}
