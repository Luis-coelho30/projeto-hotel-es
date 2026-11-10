package hotel.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estadia {
    private final int andar;
    private final int numero;
    private final Hospede hospede;
    private final LocalDate dataInicio;
    private LocalDate dataFim;
    private final List<Consumo> consumos;

    /**
     * Cria uma nova Estadia com data de início informada.
     *
     * @param andar Andar do apartamento
     * @param numero Número do apartamento
     * @param hospede Hóspede associado à estadia
     * @param dataInicio Início do período de estadia
     * @throws IllegalArgumentException se hospede ou dataInicio forem nulos
     *
     * @pre Hóspede e data de início não nulos; coordenadas já validadas pelo Hotel
     * @post Estadia criada ativa (dataFim nula) e sem consumos
     */
    public Estadia(int andar, int numero, Hospede hospede, LocalDate dataInicio) {
        if (hospede == null || dataInicio == null) {
            throw new IllegalArgumentException("Hospede nao pode ser nulo");
        }
        this.andar = andar;
        this.numero = numero;
        this.hospede = hospede;
        this.dataInicio = dataInicio;
        this.consumos = new ArrayList<>();
    }

    /**
     * Cria uma nova Estadia com a data atual do sistema como início.
     *
     * @param andar Andar do apartamento
     * @param numero Número do apartamento
     * @param hospede Hóspede associado à estadia
     * @throws IllegalArgumentException se hospede for nulo
     *
     * @pre Hóspede não nulo; coordenadas já validadas pelo Hotel
     * @post Estadia criada ativa, com dataInicio igual à data atual, sem consumos
     */
    public Estadia(int andar, int numero, Hospede hospede) {
        if (hospede == null) {
            throw new IllegalArgumentException("Hospede nao pode ser nulo");
        }
        this.andar = andar;
        this.numero = numero;
        this.hospede = hospede;
        this.dataInicio = LocalDate.now();
        this.consumos = new ArrayList<>();
    }

    /**
     * Retorna o andar do apartamento da estadia.
     *
     * @return Andar do apartamento
     *
     * @pre Estadia criada
     * @post Estado da estadia inalterado
     */
    public int getAndar() {
        return this.andar;
    }

    /**
     * Retorna o número do apartamento da estadia.
     *
     * @return Número do apartamento no andar
     *
     * @pre Estadia criada
     * @post Estado da estadia inalterado
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Retorna o hóspede associado à estadia.
     *
     * @return Hóspede da estadia (nunca nulo)
     *
     * @pre Estadia criada
     * @post Estado da estadia inalterado
     */
    public Hospede getHospede() {
        return this.hospede;
    }

    /**
     * Retorna a data de início da estadia.
     *
     * @return Data de início (nunca nula)
     *
     * @pre Estadia criada
     * @post Estado da estadia inalterado
     */
    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    /**
     * Retorna a data de encerramento da estadia.
     *
     * @return Data de fim, ou null se a estadia ainda estiver ativa
     *
     * @pre Estadia criada
     * @post Estado da estadia inalterado
     */
    public LocalDate getDataFim() {
        return this.dataFim;
    }

    /**
     * Retorna os consumos registrados na estadia, em visão somente leitura.
     *
     * @return Lista não modificável de consumos (vazia se não houver)
     *
     * @pre Estadia criada
     * @post Estado da estadia inalterado
     */
    public List<Consumo> getConsumos() {
        return Collections.unmodifiableList(this.consumos);
    }

    /**
     * Indica se a estadia ainda está ativa (não encerrada).
     *
     * @return true se dataFim for nula, false caso contrário
     *
     * @pre Estadia criada
     * @post Estado da estadia inalterado
     */
    public boolean estaAtiva() {
        return this.dataFim == null;
    }

    /**
     * Encerra a estadia usando a data atual do sistema como data de fim.
     *
     * @throws IllegalStateException se a estadia já estiver encerrada
     *
     * @pre Estadia ativa
     * @post dataFim igual à data atual; estaAtiva() retorna false
     */
    public void encerrar() {
        encerrar(LocalDate.now());
    }

    /**
     * Encerra a estadia na data informada.
     *
     * @param dataFim Data de encerramento
     * @throws IllegalArgumentException se dataFim for nula ou anterior à data de início
     * @throws IllegalStateException se a estadia já estiver encerrada
     *
     * @pre Estadia ativa
     * @post dataFim igual ao valor informado; estaAtiva() retorna false
     */
    public void encerrar(LocalDate dataFim) {
        if (dataFim == null) {
            throw new IllegalArgumentException("Data de fim nao pode ser nulo");
        }
        if (!estaAtiva()) {
            throw new IllegalStateException("Estadia ja encerrada");
        }
        if (dataFim.isBefore(this.dataInicio)) {
            throw new IllegalArgumentException("Data de fim anterior a data de inicio");
        }
        this.dataFim = dataFim;
    }

    public void registrarConsumo(Consumo consumo) {
        throw new UnsupportedOperationException("Implementar registrarConsumo");
    }

    public int getDias() {
        throw new UnsupportedOperationException("Implementar getDias");
    }

    public float getTotalConsumos() {
        throw new UnsupportedOperationException("Implementar getTotalConsumos");
    }
}