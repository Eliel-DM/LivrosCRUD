package org.aluguelcarros.model.entity;

import java.util.Date;

public class Pagamento {
        private Long id;
        private Date dataPagamento;
        private float valorPago;
        private String formaPagamento;;
        private Locacao contrato;
}
