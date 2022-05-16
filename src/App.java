import java.io.*;
import java.time.*;
import java.util.ArrayList;

public class App {

    // Temporary Patient Arraylist
    public static ArrayList<Patient> templist = new ArrayList<Patient>();
    public static PatientID pUID = new PatientID('A', 'A', 'A', 0, false, ""); // Patient UID for current session

    public static void main(String[] args) throws Exception {

        clear();
        mainMenu();
        
    }

    /*/
     *  Basic Input Reader
     *  Returns inputted String if valid
    /*/
    public static String getInput()
    {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String output = null;

        try 
        {
            output = reader.readLine();
        } 
        catch (Exception IOException) 
        {
            output = null;
        }

        return output;
    }

    /*/
     *  Visual Loading System
     *  Creates ellipses per each 500 milisecond "tick" 
     *  Always ends with a new line
    /*/
    public static void loading( int ticks )
    {
        for ( int i = 0; i < ticks; i++ )
        {
            try {
                Thread.sleep(500);
            } catch (Exception e) 
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.print(".");
            
        }
        System.out.println("");
    }

    /*/
     * Clear Screen
    /*/
    public static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mainMenu()
    {
        
        System.out.println("Medical Laboratory Information System");
        System.out.println("[1] Manage Patient Records\n[2] Manage Services\n[3] Manage Laboratory Results\n");
        System.out.println("Select a Transaction:");

        switch ( getInput() )
        {
            case "1":
                clear();
                manageRecords();
            break;
            case "2":
                clear();
                // manageServices();
            break;
            case "3":
                clear();
                // manageLab();
            break;
            default:
                System.out.print("Invalid Input, please try again");
                loading(3);
                clear();
                mainMenu(); // Recursion here
        }
    }

    public static void manageRecords()
    {
        
        System.out.println("Manage Patient Records");
        System.out.println("[1] Add New Patient\n[2] Edit Patient Record\n[3] Delete Patient Record\n[4] Search Patient Record\n[X] Return to Main Menu\n");
        System.out.println("Select a Transaction:");

        switch ( getInput().toLowerCase() )
        {
            case "1":
                clear();
                addPatient();
            break;
            case "2":
                clear();
                // editPatient();
            break;
            case "3":
                clear();
                // deletePatient();
            break;
            case "4":
                clear();
                // searchPatient();
            break;
            case "x":
                clear();
                mainMenu();
            break;
            default:
                System.out.print("Invalid Input, please try again");
                loading(3);
                clear();
                manageRecords(); // Recursion here
        }
    }

    public static void addPatient()
    {

        System.out.println("First Name: ");
        String firstName = getInput();
        System.out.println("Last Name: ");
        String lastName = getInput();
        System.out.println("Middle Name: ");
        String middleName = getInput();
        System.out.println("Birthdate (YYYYMMDD): ");
        String birthDate = getInput();
        System.out.println("Gender: ");
        String gender = getInput();
        System.out.println("Address: ");
        String address = getInput();
        System.out.println("Phone No.: ");
        String phoneNo = getInput();
        System.out.println("National ID No.: ");
        String natID = getInput();

        System.out.println("Save Patient Record [Y/N] ?");

        switch ( getInput().toLowerCase() )
        {
            case "y":

                String patientOut = generateUID() + ";" + lastName + ";" + firstName + ";" + middleName + ";" + birthDate + ";" + gender + ";" + address + ";" + phoneNo + ";" + natID + "false; ;\n";

                fileOutput("Patients.txt", patientOut);

                System.out.print("Progress Saved");
                loading(3);
                clear();
                mainMenu();
            break;
            case "n":
            default:
                System.out.print("Progress not Saved");
                loading(3);
                clear();
                mainMenu();
            break;
        }

    }

    /*/
     * Output Writer
     * Input filename, file extension, and input
     * 
     * Note: this is really inefficient, opening and closing the file for each input. 
     * Best used for single additions rather than batch inputs.
    /*/
    public static void fileOutput( String filename, String input )
    {

        File f = new File( filename );

        try 
        {
            f.createNewFile();
            FileWriter fw = new FileWriter( f, true );

            BufferedWriter bw = new BufferedWriter( fw );

            bw.write( input );

            bw.close();

        } catch ( IOException e ) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        

    }

    /*/
     * Reads one line and returns a String of the said line
    /*/
    public static String fileInput( String filename )
    {

        String output = "";

        try 
        {
            BufferedReader scanner = new BufferedReader( new FileReader( new File(filename) ) );

            output = scanner.readLine();

            scanner.close();

        } catch ( IOException e ) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return output;
    }

    /*/
     * Basic Search Algorithm where output is an ArrayList of Patient Objects
    /*/
    public static ArrayList<Patient> fileSearch( String filename, String key )
    {

        ArrayList<Patient> output = new ArrayList<Patient>();

        try 
        {
            BufferedReader br = new BufferedReader( new FileReader( new File(filename) ) );

            for ( String line = br.readLine(); line != null; line = br.readLine() )
            {
                if ( line.contains( key ) )
                {
                   output.add( stringToData( line ) );
                }
            }

            br.close();

        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return output;

    }

    /*/
     * Probably won't need this...
    /*/
    public static void readAndStore( String filename, ArrayList<Patient> array )
    {

        try 
        {

            BufferedReader br = new BufferedReader( new FileReader( new File(filename) ) );

            for ( String line = br.readLine(); line != null; line = br.readLine() )
            {
                array.add( stringToData( line ) );
            }

            br.close();

        }
        catch ( IOException e )
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /*/
     * Generate ID
    /*/
    public static String generateUID()
    {
        LocalDate date = LocalDate.now();

        // TODO: get latest entry and adapt pUID to latest UID
        
        return "P" + String.format("%04d", date.getYear()) + String.format("%02d", date.getMonthValue()) + pUID.getID();
    }

    public static Patient stringToData( String input )
    {

        Patient output = new Patient();

        int type = 0,
            start = 0,
            end = 0;

        for( int i = 0; i < input.length(); i++ )
        {
            if ( input.charAt(i) == ';' || i == input.length() - 1 )
            {
                end = i;
                switch ( type )
                {
                    case 0:
                        output.setpUID(input.substring(start, end));
                    break;
                    case 1:
                        output.setFirstName(input.substring(start, end));
                    break;
                    case 2:
                        output.setLastName(input.substring(start, end));
                    break;
                    case 3:
                        output.setMiddleName(input.substring(start, end));
                    break;
                    case 4:
                        output.setBirthDate(input.substring(start, end));
                    break;
                    case 5:
                        output.setGender(input.substring(start, end));
                    break;
                    case 6:
                        output.setAddress(input.substring(start, end));
                    break;
                    case 7:
                        output.setPhoneNo(input.substring(start, end));
                    break;
                    case 8:
                        output.setNatID(input.substring(start, end));
                    break;
                    case 9:
                        output.setIsDeleted( Boolean.parseBoolean(input.substring(start, end)) );
                    break;
                    case 10:
                        output.setDelRes(input.substring(start, end));
                    break;
                }
                type++;
                start = i+1;
            }
        }

        // By default, entries without the delete marker are marked active
        if ( output.getIsDeleted() == null )
        output.setIsDeleted(false);
        // They will have no delete reason
        if ( output.getDelRes() == null )
        output.setDelRes("");

        return output;

    }

}


