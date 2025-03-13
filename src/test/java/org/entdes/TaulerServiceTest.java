package org.entdes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaulerServiceTest {

    private TaulerService taulerService;

    @BeforeEach
    void setUp() {
        taulerService = new TaulerService();
    }



    /**
     * Verifica que el jugador "X" guanya
     */
    @Test
    void testComprovarGuanyadorX() {
        taulerService.tractarClicCasella(0, 0);
        taulerService.tractarClicCasella(0, 1);
        taulerService.tractarClicCasella(0, 2);
        taulerService.tractarClicCasella(1, 1);
        taulerService.tractarClicCasella(1, 0);
        taulerService.tractarClicCasella(1, 2);
        taulerService.tractarClicCasella(2, 0);
        
        assertTrue(taulerService.isGameOver());
        assertEquals("O", taulerService.getGuanyador());
    }

    /**
     * Verifica que el jugador "O" guanya
     */
    @Test
    void testComprovarGuanyador0() {
        taulerService.tractarClicCasella(0, 1);          
        taulerService.tractarClicCasella(0,0);              
        taulerService.tractarClicCasella(1, 0);           
        taulerService.tractarClicCasella(1, 1); 
        taulerService.tractarClicCasella(1, 2);    
        taulerService.tractarClicCasella(0, 2);
        taulerService.tractarClicCasella(2, 1);
        taulerService.tractarClicCasella(2, 2);
        
        assertTrue(taulerService.isGameOver());
        assertEquals("O", taulerService.getGuanyador());
    }
   
    /**
     * Verifica que el jugador "X" guanya amb una línia horitzontal completa a la primera fila.
     */
    @Test
    void testComprovarGuanyadorHoritzontalX() {
        taulerService.tractarClicCasella(0, 0);  
        taulerService.tractarClicCasella(1, 0);  
        taulerService.tractarClicCasella(0, 1);  
        taulerService.tractarClicCasella(1, 1); 
        taulerService.tractarClicCasella(0, 2); 

        assertEquals("X", taulerService.getGuanyador());
    }
    
    /**
     * Verifica que el jugador "X" guanya amb una línia vertical completa a la primera columna.
     */
    @Test
    void testComprovarGuanyadorVerticalX() {
        taulerService.tractarClicCasella(0, 0);  
        taulerService.tractarClicCasella(0, 1);  
        taulerService.tractarClicCasella(1, 0);  
        taulerService.tractarClicCasella(1, 1); 
        taulerService.tractarClicCasella(2, 0); 

        assertEquals("X", taulerService.getGuanyador());
    }

    /**
     * Verifica que el jugador "O" guanya amb una línia horitzontal completa a la primera fila.
     */
    @Test
    void testComprovarGuanyadorHoritzontalO() {   
        taulerService.tractarClicCasella(1, 0);  
        taulerService.tractarClicCasella(0, 0);  
        taulerService.tractarClicCasella(1, 1);  
        taulerService.tractarClicCasella(0, 1); 
        taulerService.tractarClicCasella(2, 1); 
        taulerService.tractarClicCasella(0, 2); 

        assertEquals("O", taulerService.getGuanyador());
    }

    /**
     * Verifica que el jugador "O" guanya amb una línia vertical completa a la segona columna.
     */
    @Test
    void testComprovarGuanyadorVerticalO() {

        taulerService.tractarClicCasella(0, 1);  
        taulerService.tractarClicCasella(0, 0);  
        taulerService.tractarClicCasella(1, 1);  
        taulerService.tractarClicCasella(1, 0); 
        taulerService.tractarClicCasella(0, 2); 
        taulerService.tractarClicCasella(2, 0); 
        assertEquals("O", taulerService.getGuanyador());
    }

    /**
     * Verifica que, si el tauler es completa i no hi ha guanyador, el joc acabi en empat.
     */
    @Test
    void testTaulerPleIEmpat() {
        taulerService.tractarClicCasella(0, 0);  
        taulerService.tractarClicCasella(0, 1);  
        taulerService.tractarClicCasella(1, 1);  
        taulerService.tractarClicCasella(0, 2);  
        taulerService.tractarClicCasella(2, 0);  
        taulerService.tractarClicCasella(1, 0);  
        taulerService.tractarClicCasella(2, 1);  
        taulerService.tractarClicCasella(2, 2);  
        taulerService.tractarClicCasella(1, 2);  

        assertTrue(taulerService.isGameOver());
        assertEquals("", taulerService.getGuanyador()); 
    }

    /**
     * Verifica que el joc segueixi en curs després d'una jugada vàlida.
     */
    @Test
    void testJocEnCurs() {
        String resultat = taulerService.tractarClicCasella(0, 0); 

        assertEquals("X", resultat);
        assertFalse(taulerService.isGameOver());
    }

    /**
     * Verifica que no es pugui realitzar una jugada en una casella ocupada.
     */
    @Test
    void testCasellaOcupada() {
        taulerService.tractarClicCasella(0, 0);
        String resultat = taulerService.tractarClicCasella(0, 0);
       
        assertEquals("X", resultat);
    }
  
}
