package src;
public class ListaEnlazada {
    public Nodo primero;  // Referencia al primer nodo de la lista

    // Constructor
    public ListaEnlazada() {
        this.primero = null;
    }

    // Método para agregar un elemento al final de la lista
    public void agregar(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para verificar si la lista contiene un objeto específico (usando equals)
    public boolean contiene(Object dato) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.dato != null && actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Método para convertir la lista enlazada a un array de Object
    // Usado en Universidad para ordenamiento y búsqueda binaria
    public Object[] convertirAArray() {
        // Primero, contar cuántos elementos hay en la lista
        int tamaño = 0;
        Nodo actual = primero;
        while (actual != null) {
            tamaño++;
            actual = actual.siguiente;
        }
        
        // Crear un array del tamaño apropiado
        Object[] array = new Object[tamaño];
        
        // Recorrer la lista y copiar cada elemento al array
        actual = primero;
        int indice = 0;
        while (actual != null) {
            array[indice] = actual.dato;
            actual = actual.siguiente;
            indice++;
        }
        
        return array;
    }

    // Método auxiliar para convertir un array de Object a ListaEnlazada
    // Usado en Universidad para reconvertir después de ordenar
    public static ListaEnlazada convertirArrayALista(Object[] array) {
        ListaEnlazada nuevaLista = new ListaEnlazada();
        for (int i = 0; i < array.length; i++) {
            nuevaLista.agregar(array[i]);
        }
        return nuevaLista;
    }

    // Método toString para facilitar la depuración (imprime los elementos)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo actual = primero;
        while (actual != null) {
            sb.append(actual.dato != null ? actual.dato.toString() : "null");
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
