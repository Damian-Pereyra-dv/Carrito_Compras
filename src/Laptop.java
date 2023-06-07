class Laptop extends ProductoElectronico {
    private String procesador;
    private int memoriaRAM;

    public Laptop(String nombre, double precioBase, String marca, String procesador, int memoriaRAM) {
        super(nombre, precioBase, marca);
        this.procesador = procesador;
        this.memoriaRAM = memoriaRAM;
    }

    public String getProcesador() {
        return procesador;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.2; // 20% de impuestos
    }
}
