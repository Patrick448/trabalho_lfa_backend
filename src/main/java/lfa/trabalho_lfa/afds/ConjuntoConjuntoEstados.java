package lfa.trabalho_lfa.afds;

/**
 * Classe que representa um conjunto de conjunto de estados de um aut�mato
 * @author Daniel Vasconcellos Barral Ferreira, Ela�se Rocha Cipriani, Alan Manso
 */

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConjuntoConjuntoEstados {

	private Set elementos = new LinkedHashSet();

	/**
	 * Verifica se um conjunto de estados est� ou n�o vazio	 
	 * @return true se o conjunto de estados estiver vazio ou false caso
	 *         contr�rio	 
	 */
	public boolean vazio() {
		if (elementos.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Limpa o Conjunto de conjunto de estado 	 
	 */	
	public void limpar() {
		elementos.clear();
	}

	/**
	 * Inclui um elemento no final do conjunto de estados	  
	 * @param elemento
	 *            Estado a ser inserido no conjunto de estados
	 */
	public void inclui(ConjuntoEstados elemento) {
		elementos.add(elemento.clonar());
	}

	/**
	 * Verfica se um Estado pertence a um dado conjunto de estados	 
	 * @param elemento
	 *            Estado a ser verificado
	 * @return true se o Estado pertence ao conjunto de estados ou false caso
	 *         contr�rio
	 */
	public boolean pertence(ConjuntoEstados elemento) {

		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			ConjuntoEstados conjuntoEstados = (ConjuntoEstados) iter.next();
			if (conjuntoEstados.igual(elemento)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza a uni�o entre dois conjuntos de estados	 
	 * @param ce
	 *            um ConjuntoEstados a ser unido a outro
	 * @return novoConjunto - ConjuntoEstados resultante da uni�o
	 */
	public ConjuntoConjuntoEstados uniao(ConjuntoConjuntoEstados cce) {
		ConjuntoConjuntoEstados novoConjunto = new ConjuntoConjuntoEstados();
		novoConjunto = this.clonar();
		for (Iterator iter = cce.getElementos().iterator(); iter.hasNext();) {
			ConjuntoEstados conjuntoEstados = (ConjuntoEstados) iter.next();

			if (!novoConjunto.pertence(conjuntoEstados)) {
				novoConjunto.inclui(((conjuntoEstados).clonar()));
			}
		}
		return novoConjunto;
	}

	/**
	 * Realiza a interse��o entre dois conjuntos de estados	 
	 * @param ce
	 *            um ConjuntoEstados a sofrer interse��o com outro
	 *            ConjuntoEstados
	 * @return novoConjunto - ConjuntoEstados resultante da interse��o
	 */
	public ConjuntoConjuntoEstados intersecao(ConjuntoConjuntoEstados cce) {
		ConjuntoConjuntoEstados novoConjunto = new ConjuntoConjuntoEstados();
		for (Iterator iter = cce.getElementos().iterator(); iter.hasNext();) {
			ConjuntoEstados conjuntoEstados = (ConjuntoEstados) iter.next();

			if (pertence(conjuntoEstados)) {
				novoConjunto.inclui(((conjuntoEstados).clonar()));
			}
		}
		return novoConjunto;
	}

	/**
	 * Cria e retorna uma c�pia do objeto ConjuntoEstados	 
	 * @return um clone desse ConjuntoEstados
	 */
	public ConjuntoConjuntoEstados clonar() {
		ConjuntoConjuntoEstados novoConjunto = new ConjuntoConjuntoEstados();
		for (Iterator iter = elementos.iterator(); iter.hasNext();) {
			ConjuntoEstados conjuntoEstados = (ConjuntoEstados) iter.next();
			novoConjunto.inclui(((conjuntoEstados).clonar()));
		}				
		return novoConjunto;
	}

	/**
	 * Verifica se um conjunto � igual a outro
	 */
	public boolean igual(ConjuntoConjuntoEstados cce) {

		boolean flag = true;
		ConjuntoConjuntoEstados aux = cce.clonar();

		for (Iterator iter = aux.getElementos().iterator(); iter.hasNext();) {
			ConjuntoEstados conjuntoEstados = (ConjuntoEstados) iter.next();
			if (!this.pertence(conjuntoEstados)) {
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
			ConjuntoEstados conjuntoEstados = (ConjuntoEstados) iter.next();

			if (!cce.pertence(conjuntoEstados)) {
				flag = false;
			}

			if (flag == false) {
				break;
			}
		}
		return flag;
	}

	/**
	 * Retorna os elementos do conjunto de 
	 * conjunto de estados	 
	 */
	public Set getElementos() {
		return elementos; 
	}
	
	/**
	 * Retorna o iterator do do conjunto de 
	 * conjunto de estados	
	 */
	public Iterator iterator(){
		return elementos.iterator();
	}
	
	/**
	 * Remove um elemento do conjunto	 
	 */
	public void removerElemento(ConjuntoEstados ce){
		elementos.remove(ce);
	}
	
	/**
	 * Retorna um Conjunto de Estados contendo a uni�o de todos os
	 * conjuntos de estado Pertencente a este Conjunto de Conjunto de estados
	 */
	public ConjuntoEstados uniaoInterna(){
		Set conjunto = getElementos();
		ConjuntoEstados novo = new ConjuntoEstados();		
		for (Iterator iter = conjunto.iterator(); iter.hasNext();) {
			novo.uniao((ConjuntoEstados) iter.next());			
		}	
		return novo.clonar();		
	}

        public String toString(){
            Iterator iter;
            String resp = "{";
            for (iter = elementos.iterator(); iter.hasNext();){
                resp += iter.next().toString();
                if (iter.hasNext())
                    resp+=",";
            }
            return resp+="}";
        }
}
