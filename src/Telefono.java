class Telefono extends ProductoElectronico {
    private int capacidadAlmacenamiento;

    public Telefono(String nombre, double precioBase, String marca, int capacidadAlmacenamiento) {
        super(nombre, precioBase, marca);
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public int getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.1; // 10% de impuestos
    }
}