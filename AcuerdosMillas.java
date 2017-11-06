import java.util.*;

public class AcuerdosMillas {

    // Nombre de las aerolineas
    private final String[] AEROLINEAS = {
            "Delta", "United", "Northwest", "Canjet", "Air Canada", "Aero Mexico", "Ocean Air", "AlohaAir",
            "Aria", "Lufthansa", "Quantas", "BMI", "Maxair", "Girjet", "British Airways", "Air Alaska",
            "Avolar", "EVA Air", "Southwest"
    };

    // Constante que mantiene el número de aerolineas
    private final int NUM_AEROLINEAS = AEROLINEAS.length;

    // Propiedad -grafo- que representa los acuerdos directos entre las aerolineas
    private boolean[][] grafoAcuerdos;

    // Propiedad para mapear pares "nombre aerolinea"/"valor entero"
    private Map<String, Integer> aerolineas;

    /**
     * Inicializa la propiedad grafoAcuerdos con los acuerdos de las aerolineas (tal y como aparecen en el enunciado de la práctica)
     * Además, inicializa la propiedad aerolineas que permitira mapear cada nombre de aerolinea con un valor entero, que será el que
     * identificará la posición de la aerolinea en el grafo grafoAcuerdos (la posicion hará referencia tanto a la fila como a la columna
     * de la matriz de adyacencia). ESTE MÉTODO NO DEBE MODIFICARSE
     */
    public AcuerdosMillas(){
        grafoAcuerdos = new boolean[NUM_AEROLINEAS][NUM_AEROLINEAS];
        for(int i=0; i<NUM_AEROLINEAS; i++)
            for(int j=0; j<NUM_AEROLINEAS; j++)
                grafoAcuerdos[i][j] = false;

        aerolineas = new HashMap<String, Integer>();
        for(int i=0; i<NUM_AEROLINEAS; i++)
            aerolineas.put(AEROLINEAS[i], i);

        grafoAcuerdos[aerolineas.get("Delta")][aerolineas.get("Air Canada")] = true;
        grafoAcuerdos[aerolineas.get("Delta")][aerolineas.get("Aero Mexico")] = true;
        grafoAcuerdos[aerolineas.get("Delta")][aerolineas.get("Ocean Air")] = true;

        grafoAcuerdos[aerolineas.get("United")][aerolineas.get("Aria")] = true;
        grafoAcuerdos[aerolineas.get("United")][aerolineas.get("Lufthansa")] = true;
        grafoAcuerdos[aerolineas.get("United")][aerolineas.get("Ocean Air")] = true;
        grafoAcuerdos[aerolineas.get("United")][aerolineas.get("Quantas")] = true;
        grafoAcuerdos[aerolineas.get("United")][aerolineas.get("British Airways")] = true;

        grafoAcuerdos[aerolineas.get("Northwest")][aerolineas.get("Air Alaska")] = true;
        grafoAcuerdos[aerolineas.get("Northwest")][aerolineas.get("BMI")] = true;
        grafoAcuerdos[aerolineas.get("Northwest")][aerolineas.get("Avolar")] = true;
        grafoAcuerdos[aerolineas.get("Northwest")][aerolineas.get("EVA Air")] = true;

        grafoAcuerdos[aerolineas.get("Canjet")][aerolineas.get("Girjet")] = true;

        grafoAcuerdos[aerolineas.get("Air Canada")][aerolineas.get("Aero Mexico")] = true;
        grafoAcuerdos[aerolineas.get("Air Canada")][aerolineas.get("Delta")] = true;
        grafoAcuerdos[aerolineas.get("Air Canada")][aerolineas.get("Air Alaska")] = true;

        grafoAcuerdos[aerolineas.get("Aero Mexico")][aerolineas.get("Delta")] = true;
        grafoAcuerdos[aerolineas.get("Aero Mexico")][aerolineas.get("Air Canada")] = true;
        grafoAcuerdos[aerolineas.get("Aero Mexico")][aerolineas.get("British Airways")] = true;

        grafoAcuerdos[aerolineas.get("Ocean Air")][aerolineas.get("Delta")] = true;
        grafoAcuerdos[aerolineas.get("Ocean Air")][aerolineas.get("United")] = true;
        grafoAcuerdos[aerolineas.get("Ocean Air")][aerolineas.get("Quantas")] = true;
        grafoAcuerdos[aerolineas.get("Ocean Air")][aerolineas.get("Avolar")] = true;

        grafoAcuerdos[aerolineas.get("AlohaAir")][aerolineas.get("Quantas")] = true;

        grafoAcuerdos[aerolineas.get("Aria")][aerolineas.get("United")] = true;
        grafoAcuerdos[aerolineas.get("Aria")][aerolineas.get("Lufthansa")] = true;

        grafoAcuerdos[aerolineas.get("Lufthansa")][aerolineas.get("United")] = true;
        grafoAcuerdos[aerolineas.get("Lufthansa")][aerolineas.get("Aria")] = true;
        grafoAcuerdos[aerolineas.get("Lufthansa")][aerolineas.get("EVA Air")] = true;

        grafoAcuerdos[aerolineas.get("Quantas")][aerolineas.get("United")] = true;
        grafoAcuerdos[aerolineas.get("Quantas")][aerolineas.get("Ocean Air")] = true;
        grafoAcuerdos[aerolineas.get("Quantas")][aerolineas.get("AlohaAir")] = true;

        grafoAcuerdos[aerolineas.get("BMI")][aerolineas.get("Northwest")] = true;
        grafoAcuerdos[aerolineas.get("BMI")][aerolineas.get("Avolar")] = true;

        grafoAcuerdos[aerolineas.get("Maxair")][aerolineas.get("Southwest")] = true;
        grafoAcuerdos[aerolineas.get("Maxair")][aerolineas.get("Girjet")] = true;

        grafoAcuerdos[aerolineas.get("Girjet")][aerolineas.get("Southwest")] = true;
        grafoAcuerdos[aerolineas.get("Girjet")][aerolineas.get("Canjet")] = true;
        grafoAcuerdos[aerolineas.get("Girjet")][aerolineas.get("Maxair")] = true;

        grafoAcuerdos[aerolineas.get("British Airways")][aerolineas.get("United")] = true;
        grafoAcuerdos[aerolineas.get("British Airways")][aerolineas.get("Aero Mexico")] = true;

        grafoAcuerdos[aerolineas.get("Air Alaska")][aerolineas.get("Northwest")] = true;
        grafoAcuerdos[aerolineas.get("Air Alaska")][aerolineas.get("Air Canada")] = true;

        grafoAcuerdos[aerolineas.get("Avolar")][aerolineas.get("Northwest")] = true;
        grafoAcuerdos[aerolineas.get("Avolar")][aerolineas.get("Ocean Air")] = true;
        grafoAcuerdos[aerolineas.get("Avolar")][aerolineas.get("BMI")] = true;

        grafoAcuerdos[aerolineas.get("EVA Air")][aerolineas.get("Northwest")] = true;
        grafoAcuerdos[aerolineas.get("EVA Air")][aerolineas.get("Lufthansa")] = true;

        grafoAcuerdos[aerolineas.get("Southwest")][aerolineas.get("Girjet")] = true;
        grafoAcuerdos[aerolineas.get("Southwest")][aerolineas.get("Maxair")] = true;
    }


    /**
     * Devuelve el numero de aerolineas. ESTE MÉTODO NO DEBE MODIFICARSE
     */
    public int numAerolineas(){
        return NUM_AEROLINEAS;
    }

    /**
     * Devuelve un vector que contiene el nombre de todas las aerolineas.
     * ESTE MÉTODO NO DEBE MODIFICARSE
     */
    public String[] getAerolineas(){
        return AEROLINEAS;
    }

    /**
     * Devuelve un String que contiene todos los acuerdos directos de cada aerolinea.
     * ESTE MÉTODO NO DEBE MODIFICARSE
     */
    public String getTodosLosAcuerdos(){
        StringBuffer linea = new StringBuffer();

        String[] aux;
        for(int i=0; i<NUM_AEROLINEAS; i++){
            linea.append(AEROLINEAS[i]+" -> ");
            aux = obtenerAcuerdos(AEROLINEAS[i]);
            for (int a=0; a<aux.length-1; a++)
                linea.append(aux[a]+", ");
            linea.append(aux[aux.length-1]);
            linea.append(System.lineSeparator());
        }
        return linea.toString();
    }

    /**
     * Dado el nombre de una aerolinea, devuelve un vector que contiene el nombre de las aerolineas con las
     * que tiene acuerdo directo.
     * ESTE MÉTODO NO DEBE MODIFICARSE
     */
    public String[] obtenerAcuerdos(String aerolinea){
        ArrayList<String> listadoAcuerdos = new ArrayList<>();
        if(aerolineaValida(aerolinea)) {
            for(int j=0; j<NUM_AEROLINEAS; j++)
                if(grafoAcuerdos[aerolineas.get(aerolinea)][j]){
                    listadoAcuerdos.add(AEROLINEAS[j]);
                }
        }
        return listadoAcuerdos.toArray(new String[0]);
    }

    /**
     * Dado una pila de números enteros asociados a determinadas aerolineas, devuelve un ArrayList que contiene el nombre de las mismas
     * El orden de las aerolineas en el ArrayList será el inverso a recorrer la pila de la cima a la base
     * ESTE MÉTODO NO DEBE MODIFICARSE
     */
    private ArrayList<String> listaSolucion(Stack<Integer> ids){
        ArrayList<String> solucion = new ArrayList<>();
        for (Integer i: ids) {
            solucion.add(AEROLINEAS[i]);
        }
        return solucion;
    }

    /**
     * Dada una cadena de caracteres devuelve si se corresponde con el nombre de alguna de las aerolineas
     * ESTE MÉTODO NO DEBE MODIFICARSE
     */
    private boolean aerolineaValida(String valor){
        return aerolineas.containsKey(valor);
    }


    /**
     * Dado el nombre de dos aerolineas, comprueba si existe un acuerdo entre ellas (directo y indirecto con un máximo de dos partner intermedios)
     * Devuelve un ArrayList que contiene los nombres de las aerolineas que son partners directos desde aerolinea1 hasta aerolinea2 (incluidas estas dos)
     * ESTE MÉTODO NO DEBE MODIFICARSE
     */
    public ArrayList<String> hayAcuerdo(String aerolinea1, String aerolinea2){
        if(aerolineaValida(aerolinea1) && aerolineaValida(aerolinea2)){
            int origen = aerolineas.get(aerolinea1);
            int destino = aerolineas.get(aerolinea2);
            return(listaSolucion(hayConexion(origen, destino)));
        }
        return new ArrayList<String>();
    }


    /** Este es el método que se debea desarrollar en la practica, junto con los métodos privados que consideren necesarios
     * LA CABECERA DE ESTE MÉTODO NO DEBE MODIFICARSE
     */
    private Stack<Integer> hayConexion(int origen, int destino){
        Stack<Integer> resultado = new Stack<Integer>();
        Booleano exito = new Booleano(false);
        boolean[] visitados = new boolean[grafoAcuerdos.length];
        for(int i = 0; i < grafoAcuerdos.length; i++){
            visitados[i] = false;
        }
        visitados[origen] = origen != destino;
        resultado.push(origen);
        hayConexionBack(origen, destino, visitados, resultado, exito, 0);
        if(!exito.getValor()) resultado.pop();
        return resultado;

    }
    /**
     * Dado el nodo orígen de la búsqueda, el nodo destino, un array de nodos visitados, una pila, un booleano que indica si hemos tenido éxito en la búsqueda o no,
     * y un número que indica el número de nodos que hay en la pila, este método obtiene mediante backtracking una pila que tiene como base el nodo inicial, en medio
     * un máximo de dos nodos intermedios, y en la cima el nodo destino (los identificadores de los nodos). En caso de no existir acuerdo entre los nodos, se devuelve una
     * pila vacía.
     */
    void hayConexionBack(int origen, int destino, boolean[] visitados, Stack<Integer> resultado, Booleano exito, int numNodos){
        int v = 0;
        do{
            if((!visitados[v])){
                if(numNodos < 4 && grafoAcuerdos[origen][v]){
                    visitados[v] = true;
                    numNodos++;
                    resultado.push(v);
                    if(v == destino && numNodos < 4 ) { //es solución
                        exito.setValor(true);
                    }
                    else{
                        hayConexionBack(v,destino,visitados,resultado,exito, numNodos);
                        if(!exito.getValor()){
                            visitados[v] = false;
                            numNodos--;
                            resultado.pop();
                        }
                    }
                }

            }
            v++;
        }while((!exito.getValor()) && v!=grafoAcuerdos.length);

    }


}
