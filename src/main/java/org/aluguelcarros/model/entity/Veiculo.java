package org.aluguelcarros.model.entity;
import java.util.List;
import java.util.Date;

public class Veiculo {
    private Long id;
    private String placa;
    private String chassi;
    private Date anoFabricacao;
    private String cor;
    private Marca marca;
    private Modelo modelo;
    private String status;
    private List<Manutencao> manutencaoList;
}
