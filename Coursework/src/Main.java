import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner s = new Scanner(System.in);
        String input;
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();

        try{// load previous file if available
            manager.loadFile();
        }catch (FileNotFoundException e){
            System.out.println("No file found");

        }

        do{
            System.out.println("---------------------------------------------");
            System.out.println("This is the menu system");
            System.out.println("Enter 1 to add doctor: ");
            System.out.println("Enter 2 to delete doctor: ");
            System.out.println("Enter 3 to print doctor list: ");
            System.out.println("Enter 4 to save the file:");
            System.out.println("Enter G to open GUI");
            System.out.println("Enter Q to end program");
            System.out.println(" ");

            input = s.next().toUpperCase();
            switch (input) {
                case ("1"):
                    manager.addDoctor();
                    break;
                case ("2"):
                    manager.deleteDoctor();
                    break;
                case ("3"):
                    manager.printDoctor();
                    break;
                case ("4"):
                    manager.saveFile();
                    break;
                case ("G"):
                    manager.loadGUI();

                    break;
                case("Q"):
                    System.out.println("Program Ending.....:(((");
                    break;
            }
        }while(!input.equals("Q"));

    }
}






//