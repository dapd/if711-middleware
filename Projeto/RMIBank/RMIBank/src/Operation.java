/**
 * @author fabio
 * @author diogo
 * @author marina
 *
 */
public enum Operation {
	ACCOUNT_CREATION("CRIACAO DE CONTA"), DELETE_ACCOUNT("ENCERRAMENTO DE CONTA"), BALANCE("VERIFICACAO DE SALDO"), PAYMENT("REALIZACAO DE PAGAMENTO"), TRANSFER("TRANSFERENCIA DE VALORES"), CARD_BILL_PAYMENT("PAGAMENTO DE FATURA"), LOGIN("LOGIN"), UNRECOGNIZED("DESCONHECIDA");

	private String valor;

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 */
	private Operation(String valor) {
		this.valor = valor;
	}

}
