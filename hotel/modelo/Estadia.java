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

    public void encerrar() {
        throw new UnsupportedOperationException("Implementar encerrar");
    }

    public void encerrar(LocalDate dataFim) {
        throw new UnsupportedOperationException("Implementar encerrar");
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