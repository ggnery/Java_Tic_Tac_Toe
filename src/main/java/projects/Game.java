package projects;

import java.util.Scanner;

public class Game {
    public static Scanner scanner= new Scanner(System.in);

    public static void DiplayJogo(char[][] grid){
        System.out.println("---------");
        for(int i = 0; i<3; i++){
            System.out.printf("| %c %c %c |\n", grid[i][0], grid[i][1], grid[i][2]);
        }
        System.out.println("---------");
    }

    public static char[][] criaJogo(){
        char[][] grid = new char[3][3];


        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                grid[i][j] = '_';

            }
        }

        return  grid;
    }
    public static boolean completo(char[][] grid){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(grid[i][j] == '_'){
                    return false;
                }
            }
        }
        return true;
    }

    public static String verificaJogo(char[][] grid){
        if(!balanceado(grid)){
            return "Impossible";
        }

        String vencedorColuna = verificaColuna(grid);
        String vencedorLinha = verificaLinha(grid);
        String vencedorDiagPrinc = verificaDiagonalPrincipal(grid);
        String vencedorDiagSec = verificaDiagonalSecundaria(grid);


        if(vencedorColuna.equals("Impossible") || vencedorLinha.equals("Impossible")){
            return "Impossible";
        }

        if(vencedorColuna.equals("None") && vencedorLinha.equals("None") && vencedorDiagPrinc.equals("None") && vencedorDiagSec.equals("None")){
            if(completo(grid)){
                return "Draw";
            }else{
                return "Game not finished";
            }

        }

        if(vencedorColuna.equals("X") || vencedorLinha.equals("X") || vencedorDiagPrinc.equals("X") || vencedorDiagSec.equals("X")){
            return "X";
        }else{
            return "O";
        }


    }

    public static boolean balanceado(char[][] grid){
        int numX = 0;
        int numO = 0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(grid[i][j] == 'X')
                    numX++;
                else if(grid[i][j] == 'O')
                    numO++;

            }
        }

        if(Math.abs(numX - numO) > 1)
            return false;
        else
            return true;


    }

    public static String verificaColuna(char[][] grid){
        int vitoriasX = 0;
        int vitoriasO = 0;

        for(int i = 0; i<3; i++){
            int numX = 0;
            int numO = 0;

            for(int j = 0; j<3; j++){
                if(grid[j][i] == 'X')
                    numX++;
                else if(grid[j][i] == 'O')
                    numO++;

            }

            if(numX == 3)
                vitoriasX++;
            else if(numO == 3)
                vitoriasO++;

        }
        //Verifica se houve draw ou not finished
        if(vitoriasX == 0 && vitoriasO == 0){
            return "None";
        }else{
            //Verifica se houve 2 vencedores
            if(vitoriasX != 0 && vitoriasO != 0)
                return "Impossible";
            else{
                if(vitoriasX == 1){
                    return "X";
                }else{
                    return "O";
                }
            }

        }

    }

    public static String verificaLinha(char[][] grid){
        int vitoriasX = 0;
        int vitoriasO = 0;

        for(int i = 0; i<3; i++){
            int numX = 0;
            int numO = 0;

            for(int j = 0; j<3; j++){
                if(grid[i][j] == 'X')
                    numX++;
                else if(grid[i][j] == 'O')
                    numO++;

            }

            if(numX == 3)
                vitoriasX++;
            else if(numO == 3)
                vitoriasO++;

        }
        //Verifica se houve draw ou not finished
        if(vitoriasX == 0 && vitoriasO == 0){
            return "None";
        }else{
            //Verifica se houve 2 vencedores
            if(vitoriasX != 0 && vitoriasO != 0)
                return "Impossible";
            else{
                if(vitoriasX == 1){
                    return "X";
                }else{
                    return "O";
                }
            }

        }

    }

    public static String verificaDiagonalPrincipal(char[][] grid){
        int numX = 0;
        int numO = 0;

        for(int i=0; i<3; i++){
            if(grid[i][i] == 'X')
                numX++;
            else if(grid[i][i] == 'O')
                numO++;
        }

        if(numX == 3)
            return "X";
        else if(numO ==3)
            return "O";
        else
            return "None";


    }

    public static String verificaDiagonalSecundaria(char[][] grid){
        int numX = 0;
        int numO = 0;
        for(int i=0; i<3; i++){
            if(grid[i][(3-1)-i] == 'X')
                numX++;
            else if (grid[i][(3-1)-i] == 'O')
                numO++;
        }

        if(numX == 3)
            return "X";
        else if(numO ==3)
            return "O";
        else
            return "None";


    }

    public static void leMovimento(char[][] grid, int rodada){
        String s1;
        String s2;
        boolean repete = false;
        int i, j;

        do {
            s1 = scanner.next();
            s2 = scanner.next();

            try {
                i = Integer.parseInt(s1) - 1;
                j = Integer.parseInt(s2) - 1;

                if (grid[i][j] == '_'){
                    if(rodada%2 == 1)
                        grid[i][j] = 'X';
                    else
                        grid[i][j] = 'O';

                    repete = false;
                }else{
                    System.out.println("This cell is occupied! Choose another one!");
                    repete = true;
                }
            }catch(NumberFormatException e){
                System.out.println("You should enter numbers!");
                repete = true;
            }catch (ArrayIndexOutOfBoundsException ob){
                System.out.println("Coordinates should be from 1 to 3!");
                repete = true;
            }

        }while (repete);

    }
}
