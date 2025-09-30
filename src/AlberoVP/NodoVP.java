package AlberoVP;

import java.util.LinkedList;

/**
 * Autore:
 * Nome: Xiong
 * Cognome: Chen
 * Matricola: 7144793
 */


public class NodoVP<T> {
    private T info;
    private NodoVP<T> padre;
    private LinkedList<NodoVP<T>> figli;

    //* -- COSTRUTTORE --*//
    NodoVP(NodoVP<T> padre, T info) {
        this.padre = padre;
        this.info = info;
        figli = new LinkedList<NodoVP<T>>();
    }

    //* -- METODI --*//

  
    /* -- ACCESSORI --*/
    
    //restituire la lista dei figli di un nodo
    public LinkedList<NodoVP<T>> getFigli(){
        return figli;
    }

    // restituire il padre di un nodo
    public NodoVP<T> getPadre() {
        return padre;
    }

    //resitutire il livello di un nodo
    public int livello() {
        int livello = 0;
        NodoVP<T> temp = this.getPadre();
        while(temp!= null) {
            livello ++;
            temp = temp.getPadre();
        }
        return livello;
    }

    //restituire la informazione di un nodo dell’albero;
    public T getInfo() {
        return info;
    }

    // restituire il numero di figli di un nodo dell’albero
    public int getNumFigli() {
        return figli.size();
    }

    // Aggiornare la informazione di un nodo dell’albero
    public void setInfo(T informazione) {
        info = informazione;
        
    }

    // Aggiornare padre di un nodo dell’albero
    public void setPadre(NodoVP<T> p) {
        padre = p;
    }

    // Aggiungere Figlio
    public void setFiglio (NodoVP<T> f) {
        figli.addLast(f);
    }

    //stampa
    public String toString() {
        return info.toString();
    }


}
