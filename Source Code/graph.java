import java.util.Scanner;

public class graph {

    int vertex;
    LinkedList list[];

    public graph(int vertex){
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for(int i = 0;i < vertex; i++){
            list[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination){
        //add edge
        list[source].addFirst(destination);

        //add back edge (for undirected)
        list[destination].addFirst(source);
    }

    public void degree(int source){
        //degree undirected graph
        System.out.println("degree vertex "+source+" : "+list[source].size());

        //degree directed graph
            //inDegree
        int k, totalIn = 0, totalOut = 0;
        for(int i = 0; i < vertex; i++){
            for(int j = 0;j<list[i].size();j++){
                if(list[i].get(j)==source){
                    ++totalIn;
                }
            }
        }

            //outDegree
        for(k = 0;k<list[source].size();k++){
            list[source].get(k);
        }
        totalOut = k;
        System.out.println("Indegree dari vertex "+source+" : "+totalIn);
        System.out.println("Outdegree dari vertex "+source+" : "+totalOut);
        System.out.println("Degree vertex  "+source+" : "+(totalIn + totalOut));
    }

    //Nomor 3
    public void removeEdge(int source, int destination) throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (i == destination) {
                list[source].remove(source);

            }
        }
    }

    public void removeAllEdge(){
        for(int i = 0;i<vertex;i++){
            list[i].clear();
        }
        System.out.println("Graph berhasil dikosongkan");
    }

    //public void printGraph(){
        //for(int i =0;i<vertex;i++){
            //if(list[i].size()>0){
                //System.out.print("Vertex "+i+" terhubung dengan : ");
                //for(int j = 0; j < list[i].size();j++){
                    //System.out.print(list[i].get(j)+" ");
                //}
                //System.out.println("");
            //}
        //}
        //System.out.println(" ");
    //}

    //Nomor 4
    public void printGraph() throws Exception {
        String namKota = "";
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                if (i == 0) {
                    namKota = "Malang";
                } else if (i == 1) {
                    namKota = "Surabaya";
                } else if (i == 2) {
                    namKota = "Gresik";
                } else if (i == 3) {
                    namKota = "Pandaan";
                } else if (i == 4) {
                    namKota = "Bandung";
                } else {
                    namKota = "Jakarta";
                }
                System.out.print("Vertex " + namKota + " terhubung dengan: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println("");
            }
        }
    }

    //Nomor 2 
    public boolean graphType(int source, int destination) {
        list[source].addFirst(destination);
        return true;
    }

    public static void main(String[] args) {

        //Nomor 1 
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan vertex graph : ");
        int v = sc.nextInt();
        graph Graph = new graph(v);
        System.out.print("Masukkan banyak edge : ");
        int e = sc.nextInt();
        for (int i = 0; i < e; i++) {
            System.out.print("Masukkan Source : ");
            int source = sc.nextInt();
            System.out.print("Masukkan Destination : ");
            int des = sc.nextInt();

            Graph.addEdge(source, des);

        }
        Graph.printGraph();
        //Graph.addEdge(0, 1);
        //Graph.addEdge(0, 4);
        //Graph.addEdge(1, 2);
        //Graph.addEdge(1, 3);
        //Graph.addEdge(1, 4);
        //Graph.addEdge(2, 3);
        //Graph.addEdge(3, 4);
        //Graph.addEdge(3, 0);
        //Graph.removeEdge(1, 2);
        //Graph.printGraph();
        //Graph.degree(2);
    }
}