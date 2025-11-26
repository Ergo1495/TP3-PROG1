package src;

public class Cola {
        private Nodo primero;
        private Nodo ultimo;
    
        public void encolar(Object dato) {
            Nodo nuevo = new Nodo(dato);
            if (ultimo != null) {
                ultimo.siguiente = nuevo;
            }
            ultimo = nuevo;
            if (primero == null) {
                primero = nuevo;
            }
        }
    
        public Object desencolar() {
            if (primero == null) return null;
            Object dato = primero.dato;
            primero = primero.siguiente;
            if (primero == null) ultimo = null;
            return dato;
        }
    
        // Ver el primer elemento sin sacarlo
        public Object verPrimero() {
            return (primero != null) ? primero.dato : null;
        }
    }
    
