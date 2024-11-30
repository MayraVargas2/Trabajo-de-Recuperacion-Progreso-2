
public class ListaCircularDoble {

    private class Nodo {
        int dato;
        Nodo siguiente;
        Nodo anterior;

        public Nodo(int Dato) {
            dato = Dato;
        }
    }

    private Nodo inicio;
    private Nodo fin;

    public ListaCircularDoble() {
        inicio = null;
        fin = null;
    }

    // Método de inserción
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = fin = nuevo;
            inicio.siguiente = inicio.anterior = inicio;
        } else {
            nuevo.siguiente = inicio;
            nuevo.anterior = fin;
            fin.siguiente = nuevo;
            inicio.anterior = nuevo;
            fin = nuevo;
        }
    }

    // Método de eliminación
    public boolean eliminar(int dato) {
        if (inicio == null) return false;

        Nodo actual = inicio;
        do {
            if (actual.dato == dato) {
                if (actual == inicio && actual == fin) { // Solo un elemento
                    inicio = fin = null;
                } else if (actual == inicio) {
                    inicio = inicio.siguiente;
                    inicio.anterior = fin;
                    fin.siguiente = inicio;
                } else if (actual == fin) {
                    fin = fin.anterior;
                    fin.siguiente = inicio;
                    inicio.anterior = fin;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                return true;
            }
            actual = actual.siguiente;
        } while (actual != inicio);
        return false;
    }

    // Método de búsqueda
    public Nodo buscar(int dato) {
        if (inicio == null) return null;

        Nodo actual = inicio;
        do {
            if (actual.dato == dato) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != inicio);
        return null;
    }

    // Algoritmo de ordenamiento (ascendente)
    public void ordenarAscendente() {
        if (inicio == null) return;

        Nodo actual = inicio;
        do {
            Nodo siguiente = actual.siguiente;
            while (siguiente != inicio) {
                if (actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                }
                siguiente = siguiente.siguiente;
            }
            actual = actual.siguiente;
        } while (actual != inicio);
    }

    // Algoritmo de ordenamiento (descendente)
    public void ordenarDescendente() {
        if (inicio == null) return;

        Nodo actual = inicio;
        do {
            Nodo siguiente = actual.siguiente;
            while (siguiente != inicio) {
                if (actual.dato < siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                }
                siguiente = siguiente.siguiente;
            }
            actual = actual.siguiente;
        } while (actual != inicio);
    }

    // Mostrar lista
    public String mostrar() {
        if (inicio == null) return "Lista vacía.";

        StringBuilder resultado = new StringBuilder();
        Nodo actual = inicio;
        do {
            resultado.append(actual.dato).append(" ");
            actual = actual.siguiente;
        } while (actual != inicio);
        return resultado.toString();
    }
}

