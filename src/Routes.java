/**
 * Created by Marc on 14/3/2017.
 */
public class Routes {

    Airports airportOrigin;
    Airports airportDestination;
    int counter;

    public Routes(Airports airp1, Airports airp2){

        airportOrigin = airp1;
        airportDestination = airp2;
        counter = 1;
    }

    public void setAirportOrigin(Airports airp){

        airportOrigin = airp;

    }
    public void setAirportDestination(Airports airp){

        airportDestination = airp;

    }

    public Airports getAirportOrigin(){
        return airportOrigin;
    }
    public Airports getAirportDestination(){
        return airportDestination;
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



