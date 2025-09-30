package AlberoVP;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Autore:
 * Nome: Xiong
 * Cognome: Chen
 * Matricola: 7144793
 */
public class AlberoVP<T>{
    private NodoVP<T> radice;
    private ArrayList<T> nodi;
    private ArrayList<T> padri;

    
    //* -- COSTRUTTORE --*//
    public AlberoVP() {
        nodi = new ArrayList<>();
        padri = new ArrayList<>();
    }
    
    //* -- METODI --*//
    // Inserisce la radice nell'albero se non è già presente.
    public void inserisciRadice(T info){
        if(radice!=null) {
            return;
        }else {
            radice = new NodoVP<T>(null,info);
            nodi.add(0,radice.getInfo());
            padri.add(null);
        }
    }
    
    // Inserisce una nuova radice nell'albero, spostando  l'albero esistente come figlio della nuova radice.
    public void inserisciNuovaRadice(NodoVP<T> nuovaRadice) {
        if(radice == null) {
            inserisciRadice(nuovaRadice.getInfo());
        }else {
            nodi.add(0,nuovaRadice.getInfo());
            padri.add(1,nuovaRadice.getInfo());
            nuovaRadice.setPadre(null);
            nuovaRadice.setFiglio(radice);
            radice.setPadre(nuovaRadice);
            radice = nuovaRadice;
        }
    }
    // restituire il array di Nodi
    public ArrayList<T> getNodi() {
        return nodi;
    }
    // restituire il array di padri
    public ArrayList<T> getPadri(){
        return padri;
    }

    // restituire la radice di un albero
    public NodoVP<T> getRadice() {
        return radice;
    }

    // restituire il numero di nodi dell albero
    public int getNumNodi() {
        return nodi.size();
    }

    // aggiungere e restituire un nodo con informazione data, come figlio di un nodo gia presente
    public NodoVP<T> inserisciNodo(NodoVP<T> padre, T infoNodo) {
        NodoVP<T> v = new NodoVP<T>(padre,infoNodo);
        padre.setFiglio(v);

        nodi.add(infoNodo);
        padri.add(padre.getInfo());
        return v;
    }

    //restituire l altezza dell albero
    public int altezza() {
        return calcolaAltezza(radice);

    }

    // Calcola ricorsivamente l'altezza del nodo passato (numero massimo di livelli fino a una foglia)
    public int calcolaAltezza(NodoVP<T> nodo) {
        if (nodo == null) return 0;
        if (nodo.getFigli().isEmpty()) return 1;

        int maxAltezzaFigli = 0;
        for (NodoVP<T> figlio : nodo.getFigli()) {
            maxAltezzaFigli = Math.max(maxAltezzaFigli, calcolaAltezza(figlio));
        }
        return maxAltezzaFigli + 1;
    }



    //restituire il numero di foglie dell'albero
    public int getNumFoglie(NodoVP<T> r) {
        int foglie = 0;
        //albero vuoto
        if(r==null) {
            return 0;
        }else {
            //solo radice
            if(r.getFigli().size()== 0) {
                return 1;
            }else {
                //scorro figli e figli dei figli.
                for(int i = 0; i<r.getFigli().size(); i++) {
                    foglie = foglie + getNumFoglie(r.getFigli().get(i));
                }
            }
        }
        return foglie;
    }

    //restituire la lista dei nodi dell albero visitato in profondita'
    public LinkedList<NodoVP<T>> visitaProfondita() {
        LinkedList<NodoVP<T>> profondita = new LinkedList<>();
        dfs(radice, profondita);
        return profondita;
    }

    private void dfs(NodoVP<T> nodo, LinkedList<NodoVP<T>> profondita) {
        if (nodo == null) return;
        profondita.add(nodo);
        for (NodoVP<T> figlio : nodo.getFigli()) {
            dfs(figlio, profondita);
        }
    }
    
    /**
     * Aggiorna l'informazione del nodo passato come parametro e,
     * dopo aver modificato il nodo, aggiorna anche le informazioni
     * corrispondenti memorizzate negli ArrayList 'nodi' e 'padri'.
     */

    public void setInfo(NodoVP<T> nodo,T informazione) {
        T oldInfo = nodo.getInfo();
        nodo.setInfo(informazione);
        for (int i = 0; i < nodi.size(); i++) {
            if (nodi.get(i).equals(oldInfo)) {
                nodi.set(i, informazione);
            }
        }
        for (int i = 1; i < padri.size(); i++) {
            if (padri.get(i).equals(oldInfo)) {
                padri.set(i, informazione);
            }
        }
        
        
    }

    //restituire la lista dei nodi dell albero visitato in ampiezza
    public LinkedList<NodoVP<T>> visitaAmpiezza() {
        LinkedList<NodoVP<T>> ampiezza = new LinkedList<>();
        if (radice == null) return ampiezza;

        Queue<NodoVP<T>> coda = new LinkedList<>();
        coda.add(radice);

        while (!coda.isEmpty()) {
            NodoVP<T> x = coda.poll();  // 从队头取出
            ampiezza.add(x);

            for (NodoVP<T> figlio : x.getFigli()) {
                coda.add(figlio);       // 队尾加入子节点
            }
        }
        return ampiezza;
    }

    //restituire una stringa che rappresenti l albero
    public String stampaAlbero() {
        String radice = null;
        for (int i = 0; i < padri.size(); i++) {
            if (padri.get(i) == null) {
                radice = (String) nodi.get(i);
                break;
            }
        }
        if (radice == null) return "Albero vuoto";

        return radice + stampaNodo(radice);
    }

    private String stampaNodo(String nodo) {
        String result = "[";
        boolean primo = true;

        for (int i = 0; i < padri.size(); i++) {
            if (nodo.equals(padri.get(i))) {
                if (!primo) result += ", ";
                primo = false;
                result += nodi.get(i) + stampaNodo((String)nodi.get(i));
            }
        }

        result += "]";
        return result;
    }
}