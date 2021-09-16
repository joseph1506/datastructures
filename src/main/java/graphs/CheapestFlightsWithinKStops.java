package graphs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int cities= 5;
        int source=0;
        int destination=4;
        int maxStops=3;
        int[][] flights= new int [6][3];
        flights[0]=new int[]{0,1,100};
        flights[1]=new int[]{0,3,300};
        flights[2]=new int[]{1,3,100};
        flights[3]=new int[]{2,4,10};
        flights[4]=new int[]{3,2,10};
        flights[5]=new int[]{4,1,100};

        System.out.println(cheapestPrice(cities,flights,maxStops,source,destination));

    }

    private static int cheapestPrice(int cities, int[][] flights, int maxStops, int source, int destination) {
        if(flights==null || flights.length==0) return -1;

        if(maxStops<=0) return -1;

        if(cities<=0) return -1;

        FlightData flightData= new FlightData(cities);


        for(int i=0;i<flights.length;i++){
            flightData.addFlight(flights[i][0],flights[i][1],flights[i][2]);
        }

        int stops=0;
        int totalPrice=0;
        Map<String,Integer> stopsAndMinimumPrice= new HashMap<>();
        stopsAndMinimumPrice.put("STOPS",0);
        stopsAndMinimumPrice.put("MINIMUM_PRICE",Integer.MAX_VALUE);

        boolean[] visited= new boolean[cities];

        traverse(flightData,source,destination,stops,maxStops,totalPrice,stopsAndMinimumPrice,visited);

        int minPrice= stopsAndMinimumPrice.get("MINIMUM_PRICE");

        if(minPrice!=Integer.MAX_VALUE){
            return minPrice;
        }
        return -1;
    }

    private static void traverse(FlightData flightData, int source, int destination, int stops,
                                int maxStops, int totalPrice, Map<String, Integer> stopsAndMinimumPrice, boolean[] visited) {
        int minPriceTillNow=stopsAndMinimumPrice.get("MINIMUM_PRICE");
        if(source==destination){
            if(stops<=maxStops){
                if(totalPrice<minPriceTillNow){
                    stopsAndMinimumPrice.put("STOPS",stops-1);
                    stopsAndMinimumPrice.put("MINIMUM_PRICE",totalPrice);
                }
            }
            return;
        }

        if(stops>maxStops) return;

        if(totalPrice>=minPriceTillNow) return;

        visited[source]=true;

        LinkedList<Flight> flightsFromSource= flightData.adj[source];

        for(Flight flight:flightsFromSource){
            if(!visited[flight.destination])
            traverse(flightData,flight.destination,destination,stops+1,maxStops,totalPrice+flight.price
            ,stopsAndMinimumPrice,visited);
        }

        visited[source]=false;
        return;
    }


}


@Setter
@Getter
class FlightData {
    int cities;
    LinkedList<Flight> adj[];

    public FlightData(int cities){
        this.cities = cities;
        adj = new LinkedList[this.cities];
        for(int i =0;i<this.cities;i++){
            adj[i] = new LinkedList<Flight>();
        }
    }

    public void addFlight(int src,int dest, int price){
        adj[src].add(new Flight(src,dest,price));
    }
}

@Getter
@Setter
@AllArgsConstructor
class Flight{
    int source;
    int destination;
    int price;
}