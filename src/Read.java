/**
 * Created by Marc on 7/3/2017.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Read {

    public static void main(String[] args) throws IOException {

        String csvFile = "/Users/Marc/Desktop/TFG/reder.csv";
        String line = "";
        String cvsSplitBy = ";";
        List<Airports> airportOriginList = new ArrayList<>();
        List<Airports> airportDestinationList = new ArrayList<>();
        List<Routes> routeList = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        List<String> lines2 = new ArrayList<>();
        List<String> lines3 = new ArrayList<>();

        String path = "routes";
        String puth = path;
        File f = new File("/Users/Marc/Desktop/TFG/"+path+".txt");
        Boolean found = false;
        int cont = 0;
        while (found != true) {
            if (f.exists() && !f.isDirectory()) {
                cont = cont+1;
                path = puth+"("+cont+")";
                f = new File("/Users/Marc/Desktop/TFG/"+path+".txt");
            }
            else{
                found = true;
            }
        }
        Path filer = Paths.get("/Users/Marc/Desktop/TFG/"+path+".txt");


        String path2 = "Origins";
        String puth2 = path2;
        File f2 = new File("/Users/Marc/Desktop/TFG/"+path2+".txt");
        Boolean found2 = false;
        int cont2 = 0;
        while (found2 != true) {
            if (f2.exists() && !f2.isDirectory()) {
                cont2 = cont2+1;
                path2 = puth2+"("+cont2+")";
                f2 = new File("/Users/Marc/Desktop/TFG/"+path2+".txt");
            }
            else{
                found2 = true;
            }
        }
        Path filer2 = Paths.get("/Users/Marc/Desktop/TFG/"+path2+".txt");

        String path3 = "Destinations";
        String puth3 = path3;
        File f3 = new File("/Users/Marc/Desktop/TFG/"+path3+".txt");
        Boolean found3 = false;
        int cont3 = 0;
        while (found3 != true) {
            if (f3.exists() && !f3.isDirectory()) {
                cont3 = cont3+1;
                path3 = puth3+"("+cont3+")";
                f3 = new File("/Users/Marc/Desktop/TFG/"+path3+".txt");
            }
            else{
                found3 = true;
            }
        }
        Path filer3 = Paths.get("/Users/Marc/Desktop/TFG/"+path3+".txt");

        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] file = line.split(cvsSplitBy);
                Boolean find1 = false;
                for (Airports airport : airportOriginList) {
                    String airportName = airport.getairportName();
                    if (file[2].equals(airportName)){
                        find1 = true;
                        airport.addCounter();
                    }


                }

                if (find1 == false){

                    airportOriginList.add(new Airports(file[2]));
                }

                Boolean find2 = false;
                for (Airports airport : airportDestinationList) {
                    String airportName = airport.getairportName();
                    if (file[3].equals(airportName)){
                        find2 = true;
                        airport.addCounter();
                    }


                }

                if (find2 == false){

                    airportDestinationList.add(new Airports(file[3]));
                }

                Boolean find3 = false;
                for (Routes route : routeList) {
                    String airportName1 = route.getAirportOrigin().getairportName();
                    String airportName2 = route.getAirportDestination().getairportName();
                    if (file[2].equals(airportName1) && file[3].equals(airportName2)){
                        find3 = true;
                        route.addCounter();
                    }


                }

                if (find3 == false){

                    routeList.add(new Routes(new Airports(file[2]),new Airports(file[3])));
                }


                System.out.println("Route [origin= " + file[2] + " , destination=" + file[3] + "]");
                //lines.add("Route [origin= " + file[2] + " , destination=" + file[3] + "]");
                sum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(airportOriginList.get(1).getairportName()+" "+airportOriginList.get(1).getCounter());
        System.out.println(airportDestinationList.get(1).getairportName()+" "+airportDestinationList.get(1).getCounter());
        System.out.println(routeList.get(1).getAirportOrigin().getairportName()+" "+routeList.get(1).getAirportDestination().getairportName()+" "+routeList.get(1).getCounter());
        for (Routes route : routeList) {
            String airportName1 = route.getAirportOrigin().getairportName();
            String airportName2 = route.getAirportDestination().getairportName();
            int counter = route.getCounter();
            if (airportName1.equals("Origin")) {

            }
            else
            {
                lines.add(airportName1 + " " + airportName2 + " " + counter);
            }
        }

        for (Airports airport : airportOriginList) {
            String name = airport.getairportName();
            int counter = airport.getCounter();
            if (name.equals("Origin")) {

            }
            else
            {
                lines2.add(name + " "+ counter);
            }
        }

        for (Airports airport : airportDestinationList) {
            String name = airport.getairportName();
            int counter = airport.getCounter();
            if (name.equals("Destination")) {

            }
            else
            {
                lines3.add(name + " "+ counter);
            }
        }
        Files.write(filer, lines, Charset.forName("UTF-8"));
        Files.write(filer2, lines2, Charset.forName("UTF-8"));
        Files.write(filer3, lines3, Charset.forName("UTF-8"));
        System.out.println(sum);
    }
}
