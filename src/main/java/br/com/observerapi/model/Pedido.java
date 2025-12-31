package br.com.observerapi.model;


public class Pedido {

    private Long id;
    private String cliente;
    private StatusPedido status;

    public Pedido(Long id, String cliente, StatusPedido status) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getCliente() { return cliente; }
    public StatusPedido getStatus() { return status; }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
