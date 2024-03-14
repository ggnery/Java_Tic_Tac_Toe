package projects;

public class Main {
    public static void main(String[] args) {
        char[][] grid = Game.criaJogo();
        Game.DiplayJogo(grid);

        for(int rodada = 1; rodada<=9; rodada++){
            Game.leMovimento(grid, rodada);
            Game.DiplayJogo(grid);
            String stadoJogo = Game.verificaJogo(grid);

            if(stadoJogo.equals("X")){
                System.out.println("X wins");
                break;
            }else if(stadoJogo.equals("O")){
                System.out.println("O wins");
                break;
            }else if(stadoJogo.equals("Draw")){
                System.out.println("Draw");
                break;
            }else if(stadoJogo.equals("Impossible")){
                System.out.println("Impossible");
                break;
            }
        }
    }
}