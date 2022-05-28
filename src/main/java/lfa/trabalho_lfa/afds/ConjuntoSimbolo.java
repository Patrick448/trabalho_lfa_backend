package lfa.trabalho_lfa.afds;

/**
 * Classe que representa o alfabeto de um aut�mato
 * @author F�bio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConjuntoSimbolo {

	private Set elementos = new LinkedHashSet();

	/**
	 * Verifica se um conjunto de s�mbolos est� ou n�o vazio
	 * 
	 * @return true se um conjunto de s�mbolos estiver vazio ou false caso
	 *         contr�rio
	 * 
	 */
	public boolean vazio() {

		if (elementos.size() == 0) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * Limpa o conjunto de simbolos
	 *
	 */
	public void limpar(){
		elementos.clear();
	}	

	/**
	 * Inclui um elemento no final do conjunto de s�mbolos
	 * 
	 * @param elemento
	 *            Simbolo a ser inserido no conjunto de s�mbolos
	 */
	public void inclui(Simbolo elem) {
		elementos.add(elem);
	}

	/**
	 * Verfica se um Simbolo pertence a um dado conjunto de s�mbolos
	 * 
	 * @param elemento
	 *            Simbolo a ser verificado
	 * @return true se o Simbolo pertence ao conjunto de s�mbolos ou false caso
	 *         contr�rio
	 */
	public boolean pertence(Simbolo elemento) {

		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			Simbolo simbolo = (Simbolo) iter.next();
			if (simbolo.igual(elemento)) {
				return true;
			}
		}

		return false;


	}

	/**
	 * Realiza a uni�o entre dois conjuntos de simbolos
	 * 
	 * @param ce
	 *            um ConjuntoSimbolo a ser unido a outro
	 * @return novoConjunto - ConjuntoSimbolo resultante da uni�o
	 */
	public ConjuntoSimbolo uniao(ConjuntoSimbolo ce) {
		
		ConjuntoSimbolo novoConjunto = this.clonar();
		
		for (Iterator iter = ce.getElementos().iterator(); iter.hasNext();) {
			Simbolo simbolo = (Simbolo) iter.next();

			if (!novoConjunto.pertence(simbolo)) {
				novoConjunto.inclui(((simbolo).clonar()));
			}

		}
		
		return novoConjunto;

	}

	/**
	 * Realiza a interse��o entre dois conjuntos de simbolos
	 * 
	 * @param ce
	 *            um ConjuntoSimbolo a sofrer interse��o com outro
	 *            ConjuntoSimbolo
	 * @return novoConjunto - ConjuntoSimbolo resultante da interse��o
	 */
	public ConjuntoSimbolo intersecao(ConjuntoSimbolo ce) {
		
		ConjuntoSimbolo novoConjunto = new ConjuntoSimbolo();

		for (Iterator iter = ce.getElementos().iterator(); iter.hasNext();) {
			Simbolo simbolo = (Simbolo) iter.next();

			if (pertence(simbolo)) {
				novoConjunto.inclui(((simbolo).clonar()));
			}

		}
		
		
		return novoConjunto;
	}

	/**
	 * Cria e retorna uma c�pia do objeto ConjuntoSimbolo
	 * 
	 * @return um clone desse Conjuntosimbolo
	 */
	public ConjuntoSimbolo clonar() {
		
		ConjuntoSimbolo novoConjunto = new ConjuntoSimbolo();
		
		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			Simbolo simbolo = (Simbolo) iter.next();
			novoConjunto.inclui(((simbolo).clonar()));
		}
	
		
		return novoConjunto;
	}

	/**
	 * Verifica se dois conjuntos s�o iguais
	 * 
	 */
	public boolean igual(ConjuntoSimbolo cs) {
		
		boolean flag = true;
		ConjuntoSimbolo aux = cs.clonar();

		for (Iterator iter = aux.getElementos().iterator(); iter.hasNext();) {
			Simbolo si = (Simbolo) iter.next();
			if (!this.pertence(si)) {
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
			Simbolo si = (Simbolo) iter.next();

			if (!cs.pertence(si)) {
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
		ConjuntoSimbolo tmp = this.clonar();
		int size = tmp.getElementos().size() - 1;
		s += "{";		
		
		for (Iterator iter = tmp.getElementos().iterator(); iter.hasNext();) {
			Simbolo si = (Simbolo) iter.next();			
			s+= si.toString();
			
			if(size != 0){
				s+=",";	
			}
					
			size--;
		}
		
		s += "}";
		
		return s;
		
	
	}

	/**
	 * Retorna os elementos do
	 * conjunto de simbolo
	 * 
	 */
	public Set getElementos() {
		return elementos; 
	}
	
	/**
	 * 
	 * Retorna o iterator do conjunto de simbolo
	 */
	public Iterator iterator(){
		return elementos.iterator();
	}
	
	/**
	 * Remove um elemento do conjunto
	 * 
	 */
	public void removerElemento(Simbolo s){
		elementos.remove(s);
	}
	

}
