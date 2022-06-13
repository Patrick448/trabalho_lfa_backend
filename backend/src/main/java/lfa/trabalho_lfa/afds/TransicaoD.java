package lfa.trabalho_lfa.afds;

/**
 * Classe que representa a fun��o programa de um aut�mato finito determin�stico
 * @author F�bio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */
public class TransicaoD {
	
	private Estado origem;
	private Estado destino;
	private Simbolo simbolo;

        
	/**
	 * Obt�m o destino da transi��o determin�stica
	 * @return destino - Estado que representa o destino da transi��o
	 */
	public Estado getDestino() {
		return destino.clonar();
	}
	
	/**
	 * Ajusta o destino da transi��o determin�stica para o valor passado como par�metro
	 * @param destino Estado a ser definido como destino da transi��o
	 */
	public void setDestino(Estado destino) {
		this.destino = destino.clonar();
	}
	
	/**
	 * Obt�m a origem da transi��o determin�stica
	 * @return origem - Estado que representa a origem da transi��o
	 */
	public Estado getOrigem() {
		return origem.clonar();
	}
	
	/**
	 * Ajusta a origem da transi��o determin�stica para o valor passado como par�metro
	 * @param origem Estado a ser definido como origem da transi��o
	 */
	public void setOrigem(Estado origem) {
		this.origem = origem.clonar();
	}
	
	/**
	 * Obt�m o s�mbolo do alfabeto
	 * @return simbolo - char que representa um s�mbolo do alfabeto
	 */
	public Simbolo getSimbolo() {
		return simbolo;
	}
	
	/**
	 * Ajusta o s�mbolo do alfabeto para o valor passado como par�metro
	 * @param simbolo char a ser definido como s�mbolo do alfabeto
	 */
	public void setSimbolo(Simbolo simbolo) {
		this.simbolo = simbolo.clonar();
	}
	
	/**
	 * Cria e retorna uma c�pia do objeto TransicaoD
	 * @return um clone dessa TransicaoD
	 */
	public TransicaoD clonar() {		
		TransicaoD td = new TransicaoD();		
		td.setOrigem(this.origem);
		td.setDestino(this.destino);
		td.setSimbolo(this.simbolo);
		return td;
	}
        
        public boolean igual(TransicaoD transicao){
            if ( this.destino.igual(transicao.getDestino()) &&
                this.origem.igual(transicao.getOrigem()) &&
                this.simbolo.igual(transicao.getSimbolo()))
                return true;
            else return false;
        }
        
        public String toString()
	{
		String s = new String();
		s += "(";                
                s +=  this.getOrigem().toString(); s += ",";
                s +=  this.getSimbolo().toString();s += ",";
                s +=  this.getDestino().toString();s += ",";
                s += ")";
		return s;
	}                
}
