import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        char user_input = '0';
        Scanner kbd = new Scanner(System.in);
        System.out.println("Welcome to the database command line, below is the main menu for selection of commands");
        System.out.println("Enter 0, 1, 2, 3, 4 for corresponding commands");
        System.out.println("Enter 'q' to quit command line.");
        Database db = new Database();
        do {
            String table_name = "";
            String[] record;
            String[] col_names;

            System.out.println("(0)EXIT");
            System.out.println("(1)CREATE NEW TABLE");
            System.out.println("(2)INSERT INTO TABLE");
            System.out.println("(3)SELECT RECORDS FROM TABLE");
            System.out.println("(4)WRITE TO FILE");

            user_input = kbd.nextLine().charAt(0);

            switch(user_input) {
                case '1':
                    System.out.print("Table Name(case sensitive): ");
                    table_name = kbd.nextLine();

                    if(db.tables.containsKey(table_name)) {
                        System.out.println("Table " + table_name + " already exists in database.");
                        continue;
                    }else {
                        Table t = new Table();
                        db.tables.put(table_name, t);
                        System.out.print("Enter table headers(separated by commas): ");
                        record = kbd.nextLine().split(", ");
                        Table curr_table = db.tables.get(table_name);
                        String primary_key = record[0];
                        curr_table.table.put(primary_key, Arrays.copyOfRange(record, 1, record.length-1));
                    }
                    break;
                case '2':
                    System.out.print("Table Name(case sensitive): ");
                    table_name = kbd.nextLine();

                    if(db.tables.containsKey(table_name)) {
                        System.out.print("INSERT ROW(separated by commas): ");
                        record = kbd.nextLine().split(", ");
                        Table curr_table = db.tables.get(table_name);
                        String primary_key = record[0];
                        curr_table.table.put(primary_key, Arrays.copyOfRange(record, 1, record.length-1));
                    }else {
                        System.out.println("Table " + table_name + " does not exist in the database.");
                    }
                    break;
                case '3':
                    System.out.print("Table Name(case sensitive): ");
                    table_name = kbd.nextLine();

                    if(db.tables.containsKey(table_name)) {
                        System.out.print("SELECT COLUMNS(separated by commas): ");
                        col_names = kbd.nextLine().split(", ");
                        Table curr_table = db.tables.get(table_name);
                        int[] idx = new int[col_names.length];
                        int k = 0;


                    }else {
                        System.out.println("Table " + table_name + " does not exist in the database");
                    }
                    break;
                case '4':
                    File file = new File("output_database.txt");
                    FileWriter fw = null;

                    try {
                        fw = new FileWriter(file);

                        for(Table t: db.tables.values()) {
                            FileWriter finalFw = fw;
                            t.table.entrySet().forEach((k) -> {
                                try {
                                    finalFw.write(String.valueOf((k.getValue())) + "\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                        fw.flush();
                    }catch(IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            fw.close();
                        }catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                    default:
                    System.out.println("Unknown command, please select an option.");
            }
        }while(user_input != '0');
    }
}
