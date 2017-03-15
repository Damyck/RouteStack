/**
 * Created by Marc on 9/3/2017.
 */
public class Airports {

    String airportName;
    int counter;

    public Airports(String name){
        airportName = name;
        counter = 1;
    }

    public String getairportName(){
        return airportName;
    }

    public void setairportName(String name){

        airportName = name;

    }

    public int getCounter(){
        return counter;
    }

    public void setCounter(int counter){

        this.counter = counter;

    }

    public void addCounter(){
        this.counter = this.counter+1;
    }
}
