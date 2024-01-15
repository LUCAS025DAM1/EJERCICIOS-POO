// Ejercicio 1: Clase Lámpara
class Lampara {
  
    String tipo;
    int potencia;
    String color;


    public Lampara() {
        tipo = "LED";
        potencia = 60;
        color = "Blanco";
    }
}
// Main para probar las clases
public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        Lampara VOX = new Lampara();
        System.out.println("Lámpara - Tipo: " + VOX.tipo + ", Potencia: " + VOX.potencia + ", Color: " + VOX.color);


// Ejercicio 2: Clase Libro
class Libro {
    
    String titulo;
    String autor;
    int numPaginas;

    
    public Libro() {
        titulo = "Sin nombre";
        autor = "Desconocido";
        numPaginas = 100;
    }
}
// Main para probar las clases

// Ejercicio 2
        Libro Milucha = new Libro();
        System.out.println("Libro - Título: " + Milucha.titulo + ", Autor: " + Milucha.autor);


// Ejercicio 3: Clase Bicicleta
class Bicicleta {
    
    int numRuedas;
    String tipo;
    int tamaño;

   
    public Bicicleta() {
        numRuedas = 2;
        tipo = "Montaña";
        tamaño = 26;
    }
}
// Main para probar las clases

 // Ejercicio 3
        Bicicleta elespi = new Bicicleta();
        System.out.println("Bicicleta - Tipo: " + elespi.tipo + ", Tamaño: " + elespi.tamaño);


// Ejercicio 4: Clase Reloj

class Reloj {
  
    String marca;
    boolean digital;
    double precio;

   
    public Reloj() {
        marca = "Casio";
        digital = true;
        precio = 50.0;
    }
}
// Main para probar las clases

 // Ejercicio 4
        Reloj casio = new Reloj();
        System.out.println("Reloj - Digital: " + casio.digital + ", Precio: " + casio.precio);


// Ejercicio 5: Clase Celular
class Celular {
    
    String modelo;
    int almacenamiento;
    int camaraMP;

   
    public Celular() {
        modelo = "Genérico";
        almacenamiento = 64;
        camaraMP = 12;
    }
}

// Main para probar las clases
 // Ejercicio 5
        Celular nokia = new Celular();
        System.out.println("Celular - Modelo: " + nokia.modelo + ", Almacenamiento: " + nokia.almacenamiento);
    }
}



