package lfa.trabalho_lfa.afds;

/**
 * Classe que representa um estado de um aut�mato
 * @author F�bio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */

public class Estado {
	
	private String nome = "";
	
	/**
	 * M�todo construtor
	 */
	public Estado() {
		
	}
	
	/**
	 * M�todo construtor
	 * @param nome String que representa o nome do Estado
	 */
	public Estado(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Obt�m o nome do Estado
	 * @return nome - String que representa o nome do Estado
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Ajusta o nome do Estado para o valor passado como par�metro
	 * @param nome uma String a ser definida como nome do Estado
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Cria e retorna uma c�pia do objeto Estado
	 * @return um clone desse Estado
	 */
	public Estado clonar() {		
		Estado e = new Estado();
		e.setNome(this.getNome());		
		return e;		
	}
        
        public boolean igual(Estado estado){
            if (this.getNome().equals(estado.getNome()))
                return true;
            else return false;
        }   
        
	public String toString(){
		String s = new String();		
		s += this.getNome();
		return s;
	}        
	        
}
