/**
 * @author fabio
 * @author diogo
 * @author marina
 *
 */
public enum Messages {
	SCS("Solicitacao executada com sucesso!"), INVALID_ACCOUNT("Conta ja cadastrada!"), INVALID_CREDIT_ACCOUNT("Numero de conta para credito não cadastrado!"), NO_BALANCE("Saldo insulficiente!"), INVALID_PAYMENT("Pagamento ja realizado!");
	
	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	private Messages(String valor) {
		this.valor = valor;
	}
}
