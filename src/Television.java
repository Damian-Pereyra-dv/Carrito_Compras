class Television extends ProductoElectronico {
    private int tamanoPantalla;

    public Television(String nombre, double precioBase, String marca, int tamanoPantalla) {
        super(nombre, precioBase, marca);
        this.tamanoPantalla = tamanoPantalla;
    }

    public int getTamanoPantalla() {
        return tamanoPantalla;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.15; //
    }
    @Override
    public String mostrarInformacion() {

        return super.mostrarInformacion() +

                ", Tamaño: " + getTamanoPantalla() + " Pulgadas. ";
    }

}