package lfa.trabalho_lfa.afds;

/**
 * Classe que representa a fun��o programa de um aut�mato finito n�o-determin�stico
 * @author F�bio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */
public class TransicaoN {
	
	private Estado origem;
	private ConjuntoEstados destino;
	private Simbolo simbolo;

        public TransicaoN(){
            destino = new ConjuntoEstados();
        }
		
	/**
	 * Obt�m o destino da transi��o n�o-determin�stica
	 * @return destino - ConjuntoEstados que representa o destino da transi��o
	 */
	public ConjuntoEstados getDestino() {               
                    return this.destino.clonar();                                    
	}
	
	/**
	 * Ajusta o destino da transi��o n�o-determin�stica para o valor passado como par�metro
	 * @param destino um ConjuntoEstados a ser definido como destino da transi��o
	 */
	public void setDestino(ConjuntoEstados destino) {
		this.destino = destino.clonar();
	}
	
	/**
	 * Obt�m a origem da transi��o n�o-determin�stica
	 * @return origem - Estado que representa a origem da transi��o
	 */
	public Estado getOrigem() {
                if (origem!=null)
                    return this.origem.clonar();
                else
                    return null;
	}
	
	/**
	 * Ajusta a origem da transi��o n�o-determin�stica para o valor passado como par�metro
	 * @param origem um Estado a ser definido como origem da transi��o
	 */
	public void setOrigem(Estado origem) {
		this.origem = origem.clonar();
	}
	
	/**
	 * Obt�m o s�mbolo do alfabeto
	 * @return simbolo - char que representa um s�mbolo do alfabeto
	 */
	public Simbolo getSimbolo() {
		return this.simbolo.clonar();
	}
	
	/**
	 * Ajusta o s�mbolo do alfabeto para o valor passado como par�metro
	 * @param simbolo um char a ser definida como s�mbolo do alfabeto
	 */
	public void setSimbolo(Simbolo simbolo) {
		this.simbolo = simbolo.clonar();
	}
	
	/**
	 * Cria e retorna uma c�pia do objeto TransicaoN
	 * @return um clone dessa TransicaoN
	 */
	public TransicaoN clonar() {		
		TransicaoN tn = new TransicaoN();
		tn.setOrigem(this.origem);
		tn.setDestino(this.destino);
		tn.setSimbolo(this.simbolo);		
		return tn;
	}

        public boolean igual(TransicaoN transicao){
            if (this.destino.igual(transicao.getDestino()) &&
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
                s +=  this.getDestino().toString();                
                s += ")";
		return s;
	}                        
}
