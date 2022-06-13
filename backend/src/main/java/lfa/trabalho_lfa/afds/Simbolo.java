package lfa.trabalho_lfa.afds;

/**
 * Classe que representa um s�mbolo do alfabeto de um aut�mato
 * @author F�bio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */

public class Simbolo {
    
	final static public Simbolo VAZIA = new Simbolo('E');    
	
	private char simbolo;
	
	/**
	 * M�todo construtor
	 */
	public Simbolo() {
		
	}
	
	/**
	 * M�todo construtor
	 * @param simbolo char que representa o simbolo do alfabeto
	 */
	public Simbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	
	/**
	 * Obt�m o s�mbolo do alfabeto
	 * @return simbolo - char que representa um s�mbolo do alfabeto
	 */
	public char getSimbolo() {
		return this.simbolo;
	}

	/**
	 * Ajusta o s�mbolo do alfabeto para o valor passado como par�metro
	 * @param simbolo char a ser definida como s�mbolo do alfabeto
	 */
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	
	/**
	 * Cria e retorna uma c�pia do objeto Simbolo
	 * @return um clone desse Simbolo
	 */
	public Simbolo clonar() {		
		Simbolo s = new Simbolo();		
		s.setSimbolo(this.getSimbolo());		
		return s;		
	}
        
        public boolean igual(Simbolo simbolo){
            if (this.getSimbolo() == simbolo.getSimbolo())
                return true;
            else return false;
        }
        
	public String toString()
	{
		String s = new String();		
		s += this.getSimbolo();
		return s;
	}                
}
