package src;
import java.util.Arrays;

public class Universidad {
    private ListaEnlazada miembros;

    public Universidad() {
        this.miembros = new ListaEnlazada();
    }

    public void agregarMiembro(MiembroUniversidad miembro) {
        miembros.agregar(miembro);
    }

    public ListaEnlazada getMiembros() {
        return miembros;
    }

    public void listarTodos() {
        System.out.println("Lista de todos los miembros:");
        Nodo actual = miembros.primero;
        while (actual != null) {
            MiembroUniversidad miembro = (MiembroUniversidad) actual.dato;
            System.out.println(miembro.obtenerInformacionCompleta());
            actual = actual.siguiente;
        }
    }

    public void mostrarRoles() {
        System.out.println("Roles en la universidad:");
        Nodo actual = miembros.primero;
        while (actual != null) {
            MiembroUniversidad miembro = (MiembroUniversidad) actual.dato;
            System.out.println("- " + miembro.obtenerRol());
            actual = actual.siguiente;
        }
    }

    public ListaEnlazada buscarPorRol(String rol) {
        ListaEnlazada resultado = new ListaEnlazada();
        Nodo actual = miembros.primero;
        while (actual != null) {
            MiembroUniversidad miembro = (MiembroUniversidad) actual.dato;
            if (miembro.obtenerRol().equalsIgnoreCase(rol)) {
                resultado.agregar(miembro);
            }
            actual = actual.siguiente;
        }
        return resultado;
    }

    // Adaptado: En lugar de ordenar, mantener una lista ordenada al agregar (sugerencia).
    // Para simplicidad, agregar estudiantes ordenadamente por apellido.
    // Pero para compatibilidad, adaptar el método existente convirtiendo a array, ordenando y reconvirtiendo.
    public ListaEnlazada ordenarEstudiantesPorApellido() {
        ListaEnlazada estudiantes = new ListaEnlazada();
        Nodo actual = miembros.primero;
        while (actual != null) {
            if (actual.dato instanceof Estudiante) {
                estudiantes.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        // Convertir a array para ordenar
        Object[] arr = estudiantes.convertirAArray();
        Estudiante[] estArr = new Estudiante[arr.length];
        for (int i = 0; i < arr.length; i++) {
            estArr[i] = (Estudiante) arr[i];
        }
        // Selection sort
        int n = estArr.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (estArr[j].getApellido().compareTo(estArr[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                Estudiante temp = estArr[i];
                estArr[i] = estArr[indiceMinimo];
                estArr[indiceMinimo] = temp;
            }
        }
        // Reconvertir a ListaEnlazada
        return convertirArrayALista(estArr);
    }

    public Estudiante buscarEstudiantePorApellido(String apellido) {
        ListaEnlazada ordenados = ordenarEstudiantesPorApellido();
        Object[] arr = ordenados.convertirAArray();
        Estudiante[] estArr = new Estudiante[arr.length];
        for (int i = 0; i < arr.length; i++) {
            estArr[i] = (Estudiante) arr[i];
        }
        int index = busquedaBinariaEstudiantes(estArr, apellido);
        return index != -1 ? estArr[index] : null;
    }

    public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
        // Ya ordenado, así que búsqueda binaria
        int low = 0;
        int high = estudiantes.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = estudiantes[mid].getApellido().compareTo(apellido);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Método auxiliar para convertir array a ListaEnlazada
    public static ListaEnlazada convertirArrayALista(Object[] array) {
        ListaEnlazada nuevaLista = new ListaEnlazada();
        for (int i = 0; i < array.length; i++) {
            nuevaLista.agregar(array[i]);
        }
        return nuevaLista;
    }
}