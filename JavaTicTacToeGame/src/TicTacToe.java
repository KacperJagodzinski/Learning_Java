import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void printGameboard(char[][] array){

        for (char[] row : array) {
            for (char c: row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void placePeace(char[][] gameboard,int position,String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol ='X';
            playerPositions.add(position);
        }else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(position);
        }
        switch(position){
            case 1:
                gameboard[0][0] = symbol;
                break;
            case 2:
                gameboard[0][2] = symbol;
                break;
            case 3:
                gameboard[0][4] = symbol;
                break;
            case 4:
                gameboard[2][0] = symbol;
                break;
            case 5:
                gameboard[2][2] = symbol;
                break;
            case 6:
                gameboard[2][4] = symbol;
                break;
            case 7:
                gameboard[4][0] = symbol;
                break;
            case 8:
                gameboard[4][2] = symbol;
                break;
            case 9:
                gameboard[4][4] = symbol;
                break;
            default:
                System.out.println("Wrong number");
                break;

        }
    }

    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List middleCol = Arrays.asList(2,5,8);
        List bottomCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(middleCol);
        winning.add(bottomCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l : winning){
            if(playerPositions.containsAll(l))
                return "Congrats, You won!";
            else if(cpuPositions.containsAll(l))
                return "Game Over! CPU wins";
            else if(playerPositions.size() + cpuPositions.size() == 9){
                return "TIE";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        //initiating gameboard
        char[][] gameboard = {{' ', '|', ' ','|',' '},
                {'-', '+', '-','+','-'},
                {' ', '|', ' ','|',' '},
                {'-', '+', '-','+','-'},
                {' ', '|', ' ','|',' '}};

        //printing the gameboard
        printGameboard(gameboard);
        while(true){
            Scanner scan = new Scanner(System.in);
            //Entering placement position
            System.out.println("Enter your placement (1-9)");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
                System.out.println("Position taken");
                playerPos = scan.nextInt();
            }
            //placing our choice
            placePeace(gameboard,playerPos,"player");
            String result = checkWinner();
            if (result.length()>0){
                printGameboard(gameboard);
                System.out.println(result);
                break;
            }
            //cpu planting its choice
            Random rand = new Random();
            int cpuPos = rand.nextInt(9)+1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9)+1;
            }
            placePeace(gameboard,cpuPos,"cpu");
            printGameboard(gameboard);

            result = checkWinner();
            if (result.length()>0){
                System.out.println(result);
                break;
            }

        }


    }
}
