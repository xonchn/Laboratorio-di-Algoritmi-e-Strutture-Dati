package AlberoVP;

public class run {

    public static void main(String[] args) {
// Crea un nuovo albero vuoto
        AlberoVP<String> albero = new AlberoVP<String>();

//• inserire la radice in un albero vuoto e restituirla;
        albero.inserisciRadice("Claudia");
        System.out.println("Radice: " + albero.getRadice());
        System.out.println("\n");
//• aggiungere e restituire un nodo con informazione data come figlio di un nodo gi`a presente (che sar`a passato come parametro al metodo, insieme all’informazione);
// Aggiunge figli alla nuova radice "Roberta"
        NodoVP<String> marco = albero.inserisciNodo(albero.getRadice(), "Marco");
        NodoVP<String> luca = albero.inserisciNodo(albero.getRadice(), "Luca");
        NodoVP<String> giulia = albero.inserisciNodo(albero.getRadice(), "Giulia");
// Figli di Giulia
        NodoVP<String> andrea = albero.inserisciNodo(giulia, "Andrea");
        NodoVP<String> gianna = albero.inserisciNodo(giulia, "Gianna");
// Figli di Marco
        NodoVP<String> silvia = albero.inserisciNodo(marco, "Silvia");
        NodoVP<String> ugo = albero.inserisciNodo(marco, "Ugo");
// Figlio di Andrea
        NodoVP<String> carlo = albero.inserisciNodo(andrea, "Carlo");
//• restituire una stringa che rappresenti l’albero: riferendosi alla Figura 1 la stinga deve avere il seguente formato:
        System.out.println("Stampa struttura albero: " + albero.stampaAlbero());
        System.out.println("\n");
//• inserire una nuova radice in un albero non vuoto in modo che la vecchiaradice diventi figlia di quella nuova, che deve essere restituita;
        NodoVP<String> verdi = new NodoVP<>(null, "Verdi");
        albero.inserisciNuovaRadice(verdi);
        System.out.println("Aggiornamento nuova radice: " + albero.getRadice().getInfo());
        System.out.println("\n");
//• restituire la lista dei figli di un nodo;
        System.out.println("Lista dei figli di un nodo Giulia: " + giulia.getFigli());
        System.out.println("\n");
//• restituire il padre di un nodo;
        System.out.println("Padre di un nodo Giulia: " + giulia.getPadre());
        System.out.println("\n");
//• restituire il numero di nodi dell’albero;
        System.out.println("Numero nodi: " + albero.getNumNodi());
        System.out.println("\n");
//• resitutire il livello di un nodo;
        System.out.println("Livello di un nodo Giulia: " + giulia.livello());
        System.out.println("\n");
//• restituire il numero di figli di un nodo dell’albero;
        System.out.println("Numero di figli di un nodo Giulia dell’albero: " + giulia.getFigli().size());
        System.out.println("\n");
//• restituire il contenuto di un nodo dell’albero;
        System.out.println("Il contenuto di un nodo dell’albero: " + giulia.getInfo());
        System.out.println("\n");
//• restituire l’altezza dell’albero;
        System.out.println("Altezza albero: " + albero.altezza());
        System.out.println("\n");
//• resitutire il numero delle foglie dell’albero
        System.out.println("Numero foglie: " + albero.getNumFoglie(albero.getRadice()));
        System.out.println("\n");
//• cambiare il contenuto di un nodo dell’albero;
        albero.setInfo(verdi,"Rossi");
        System.out.println("cambiare il contenuto di un nodo dell’albero,cambia Verdi a Rossi :" + verdi.getInfo());
        System.out.println("\n");
//• restituire la lista dei nodi dell’albero visitato in profondit`a
        System.out.println("Visita in profondità: " + albero.visitaProfondita());
        System.out.println("\n");
//• restituire la lista dei nodi dell’albero visitato in ampiezza;     
        System.out.println("Visita in ampiezza: " + albero.visitaAmpiezza());
        System.out.println("\n");
//• restituire una stringa che rappresenti l’albero: riferendosi alla Figura 1 la stinga deve avere il seguente formato:
        System.out.println("Stampa struttura albero: " + albero.stampaAlbero());
        System.out.println("\n");
//• restituire la lista dei tutti nodi
        System.out.println("Stampa Array di nodi e padri: " );
        System.out.println(albero.getNodi());
//• restituire la lista dei tutti padri
        System.out.println(albero.getPadri());
    }


}


