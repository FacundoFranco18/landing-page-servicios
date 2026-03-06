import java.util.Scanner;

public class GestorMateriales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- BASE DE DATOS DE PRECIOS (Simulada) ---
        double precioSiga20 = 5200.0;     // Precio por metro
        double precioCodo20 = 980.0;      // Precio unidad
        double precioTe20 = 1450.0;       // Precio unidad
        double precioLitroPintura = 8500.0; // Epoxi / Protector

        System.out.println("========================================");
        System.out.println("   GESTOR DE STOCK & MATERIALES v1.0    ");
        System.out.println("      Especialidad: Gasista 2da Cat.    ");
        System.out.println("========================================\n");

        // --- ENTRADA DE DATOS ---
        System.out.print("➤ Ingrese metros de cañería (Sigas 20mm): ");
        double metros = sc.nextDouble();

        System.out.print("➤ Cantidad de codos de 90°: ");
        int codos = sc.nextInt();

        System.out.print("➤ Cantidad de Tées: ");
        int tees = sc.nextInt();

        // --- LÓGICA DE CÁLCULO ---
        double totalMetros = metros * precioSiga20;
        double totalCodos = codos * precioCodo20;
        double totalTees = tees * precioTe20;
        
        // Cálculo automático de pintura (1 litro cada 10 metros aprox)
        double litrosNecesarios = Math.ceil(metros / 10); 
        double totalPintura = litrosNecesarios * precioLitroPintura;

        double subtotal = totalMetros + totalCodos + totalTees + totalPintura;
        double iva = subtotal * 0.21;
        double totalFinal = subtotal + iva;

        // --- SALIDA DE RESULTADOS (RESUMEN) ---
        System.out.println("\n----------------------------------------");
        System.out.println("        RESUMEN DEL PRESUPUESTO         ");
        System.out.println("----------------------------------------");
        System.out.printf("Cañería (%.2fm):      $%.2f\n", metros, totalMetros);
        System.out.printf("Accesorios (%d piezas): $%.2f\n", (codos + tees), (totalCodos + totalTees));
        System.out.printf("Protección (%.0fL):     $%.2f\n", litrosNecesarios, totalPintura);
        System.out.println("----------------------------------------");
        System.out.printf("SUBTOTAL:             $%.2f\n", subtotal);
        System.out.printf("IVA (21%%):            $%.2f\n", iva);
        System.out.printf("TOTAL OBRA:           $%.2f\n", totalFinal);
        System.out.println("----------------------------------------");

        System.out.print("\n¿Desea descontar estos materiales del stock físico? (S/N): ");
        String confirmar = sc.next();

        if (confirmar.equalsIgnoreCase("s")) {
            System.out.println("\n✅ Operación exitosa: Stock actualizado en el sistema.");
        } else {
            System.out.println("\n⚠️ Presupuesto finalizado sin afectar el stock.");
        }
        
        System.out.println("\nGracias por usar el Gestor de Facundo Franco.");
    }
}
