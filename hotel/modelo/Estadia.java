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

    public Estadia(int andar, int numero, Hospede hospede, LocalDate dataInicio) {
        this.andar = andar;
        this.numero = numero;
        this.hospede = hospede;
        this.dataInicio = dataInicio;
        this.consumos = new ArrayList<>();
    }

    public Estadia(int andar, int numero, Hospede hospede) {
        this.andar = andar;
        this.numero = numero;
        this.hospede = hospede;
        this.dataInicio = LocalDate.now();
        this.consumos = new ArrayList<>();
    }

    public int getAndar() {
        return this.andar;
    }

    public int getNumero() {
        return this.numero;
    }

    public Hospede getHospede() {
        return this.hospede;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public List<Consumo> getConsumos() {
        return this.consumos;
    }

    public boolean estaAtiva() {
        throw new UnsupportedOperationException("Implementar estaAtiva");
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