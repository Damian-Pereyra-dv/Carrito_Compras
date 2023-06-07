abstract class ProductoElectronico {

    protected String nombre;
    protected double precioBase;
    protected String marca;

    public ProductoElectronico(String nombre, double precioBase, String marca) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularPrecioFinal();

    public String mostrarInformacion() {
        return "Nombre: " + nombre + ", Precio base: $" + precioBase + ", Marca: " + marca;
    }
}