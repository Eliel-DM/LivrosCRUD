package org.aluguelcarros.model.entity;

import java.util.Date;
import java.util.List;

public class Locacao {
    private Long id;
    private float valorTotal;
    private Date dataLocacao;
    private float valorCaucao;
    private Date dataDevolucao;
    private String status;
    private List<Veiculo> veiculoList;
    private List<Ocorrencia> ocorrenciaList;

}
