package org.entdes;

public class TaulerService {

    private String[][] caselles;
    private boolean esTornX = true;
    private boolean gameOver = false;

    private String guanyador = "";

    public TaulerService() {
        this.caselles = new String[][]{
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
        };
    } 

    public String tractarClicCasella(int fila, int columna) {

        if (!gameOver && caselles[fila][columna].isEmpty()) {

            iniciarCasella(caselles, fila, columna);
            cambiarTorn();
            guanyador = quiEsElGuanyadorVH(caselles);
            guanyador = quiEsElGuanyadorDiagonal(caselles);
            
            if (!guanyador.isEmpty()) gameOver = true;
            if (taulerPle() && !gameOver) gameOver = true;
        }
        return caselles[fila][columna];
    }


    /**
     * Canvia el torn del jugador de 'X' a 'O' i viceversa
     */
    private void cambiarTorn() {
        esTornX = !esTornX;
    }

    /**
     * Busca verticalment i horitzontalment per veure qui és el guanyador
     * 
     * @param caselles Matriu de Strings que vol ser el tauler del joc
     * @return
     */
    private String quiEsElGuanyadorVH(String[][] caselles) {
        for (int i = 0; i < 3; i++){ 
            if (caselles[i][0].equals(caselles[i][1])
            && caselles[i][1].equals(caselles[i][2])
            && !caselles[i][0].isEmpty()) {
                guanyador = caselles[i][0];
            }
            if (caselles[0][i].equals(caselles[1][i])
                && caselles[1][i].equals(caselles[2][i])    
                && !caselles[0][i].isEmpty()) {
                guanyador = caselles[0][i];
            }
        }
        return guanyador;
    }

    /**
     * Inicia la casella que té el torn
     * 
     * @param caselles Matriu de Strings que vol ser el tauler del joc
     * @param fila Enter que és la fila on es vol iniciar
     * @param columna Enter que és la columna on es vol iniciar
     */
    private void iniciarCasella(String[][] caselles, int fila, int columna) {
        if (esTornX) {
            caselles[fila][columna] = "X";
        } else {
            caselles[fila][columna] = "O";
        }
    }

    /**
     * Ens diu si el tauler està ple o no
     * 
     * @return false si el tauler no està ple, true en cas contrari
     */
    private boolean taulerPle() {
        boolean taulerPle = true;
        for (int fila1 = 0; fila1 < 3; fila1++) {
            for (int columna1 = 0; columna1 < 3; columna1++) {
                if (caselles[fila1][columna1].isEmpty()) {
                    taulerPle = false;
                    break;
                }
            }
        }
        return taulerPle;
    }

    /**
     * Mira diagonalment qui és el guanyador
     * 
     * @param caselles Matriu de Strings que vol ser el tauler del joc
     * @return el guanyador com a String sent 'X' o 'O'
     */
    private String quiEsElGuanyadorDiagonal(String[][] caselles) {
        if (caselles[2][0].equals(caselles[1][1])
                && caselles[1][1].equals(caselles[0][2])
                && !caselles[2][0].isEmpty()) {
            guanyador = caselles[2][0];
        }

        if (caselles[0][0].equals(caselles[1][1])
                && caselles[1][1].equals(caselles[2][2])
                && !caselles[0][0].isEmpty()) {
            guanyador = caselles[0][0];
        }
        return guanyador;
    }

    /**
     * Ens diu qui és el guanyador
     * 
     * @return String amb el guanyador 'X' o 'O'
     */
    public String getGuanyador() {
        return guanyador;
    }

    /**
     * Ens diu si el joc ha finalitzat
     * 
     * @return true si el joc ha finalitzat, false en cas contrari
     */
    public boolean isGameOver() {
        return gameOver;
    }

}
