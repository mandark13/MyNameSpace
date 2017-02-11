package ai;

import java.util.*;

/**
 * Created by Shalini Hemachandran on 2/10/2017.
 */
public class AStar
{

    private static Map<String, Node> nameWiseNode = new HashMap<>();

    public static final FofNComparator FOF_N_COMPARATOR = new FofNComparator();

    public static class FofNComparator implements Comparator<Float>
    {

        @Override
        public int compare(Float o1, Float o2)
        {
            return o1.compareTo(o2);
        }
    }

    public static class Node
    {
        String place;
        int straightLineDistanceToBucharest;
        Map<String, Integer> distanceFromNeighbors = new HashMap<>();
        float fofnValue = Integer.MAX_VALUE;
        boolean expanded;
        Node parent;

        int distanceFromSource = 0;

        public Node(String place, int straightLineDistanceToBucharest)
        {
            this.place = place;
            this.straightLineDistanceToBucharest = straightLineDistanceToBucharest;
        }


        public void addNeighbor(String place, int costOfPath)
        {
            distanceFromNeighbors.put(place, costOfPath);
        }

        public void computeFOfNValueAndUpdateParent(Node sourcePlace, boolean useWeights, float weight)
        {
            this.distanceFromSource = sourcePlace.distanceFromSource + (sourcePlace.equalsName(place) ? 0 : distanceFromNeighbors.get(sourcePlace.place));
            float newValue;
            if (useWeights)
                newValue = ((1-weight) * distanceFromSource) + (weight * straightLineDistanceToBucharest);
            else
                newValue = straightLineDistanceToBucharest + distanceFromSource;

            this.fofnValue = newValue;


        }


        public boolean equalsName(String destination)
        {
            return place.equals(destination);
        }

        public void setExpanded(Float integer, Node node)
        {
            this.expanded = true;
            this.fofnValue = integer;
            this.parent = node;
        }

        public List<Node> getAllNeighbors()
        {
            List<Node> nodes = new ArrayList<>();
            for (String neighbor : distanceFromNeighbors.keySet())
            {
                nodes.add(nameWiseNode.get(neighbor));
            }

            return nodes;
        }


        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return place.equals(node.place);
        }

        @Override
        public int hashCode()
        {
            return place.hashCode();
        }

        @Override
        public String toString()
        {
            return place;
        }
    }

    public static void init()
    {
        Node a = new Node("Arad", 366);
        Node b = new Node("Bucharest", 0);
        Node c = new Node("Craiova", 160);
        Node d = new Node("Dobreta", 242);
        Node e = new Node("Eforie", 161);
        Node f = new Node("Fagaras", 176);
        Node g = new Node("Giurgiu", 77);
        Node h = new Node("Hirsova", 151);
        Node i = new Node("Iasi", 226);
        Node l = new Node("Lugoj", 244);
        Node m = new Node("Mehadia", 241);
        Node n = new Node("Neamt", 234);
        Node o = new Node("Oradea", 380);
        Node p = new Node("Pitesti", 100);
        Node r = new Node("Rimnicu Vilcea", 193);
        Node s = new Node("Sibiu", 253);
        Node t = new Node("Timisoara", 329);
        Node u = new Node("Urziceni", 80);
        Node v = new Node("Vaslui", 199);
        Node z = new Node("Zerind", 374);

        List<Node> nodes = new ArrayList<>();

        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);
        nodes.add(h);
        nodes.add(i);
        nodes.add(l);
        nodes.add(m);
        nodes.add(n);
        nodes.add(o);
        nodes.add(p);
        nodes.add(r);
        nodes.add(s);
        nodes.add(t);
        nodes.add(u);
        nodes.add(v);
        nodes.add(z);




        for (Node node : nodes)
        {
            nameWiseNode.put(node.place, node);
        }


        addNeighbor(a, z, 75);
        addNeighbor(a, s, 140);
        addNeighbor(a, t, 118);
        addNeighbor(z, o, 71);
        addNeighbor(s, o, 151);
        addNeighbor(s, f, 99);
        addNeighbor(s, r, 80);
        addNeighbor(t, l, 111);
        addNeighbor(f, b, 211);
        addNeighbor(r, p, 97);
        addNeighbor(r, c, 146);
        addNeighbor(l, m, 70);
        addNeighbor(b, u, 85);
        addNeighbor(b, g, 90);
        addNeighbor(b, p, 101);
        addNeighbor(p, c, 138);
        addNeighbor(c, d, 120);
        addNeighbor(m, d, 75);
        addNeighbor(u, v, 142);
        addNeighbor(u, h, 98);
        addNeighbor(v, i, 92);
        addNeighbor(h, e, 86);
        addNeighbor(i, n, 87);

    }

    private static void addNeighbor(Node a, Node z, int i)
    {
        a.addNeighbor(z.place, i);
        z.addNeighbor(a.place, i);
    }


    public static void computeAStar(String source, String destination, boolean useWeight, float weight)
    {
        Node sourceNode = nameWiseNode.get(source);
        sourceNode.computeFOfNValueAndUpdateParent(sourceNode, useWeight, weight);
        sourceNode.setExpanded(sourceNode.fofnValue, null);

        System.out.println(sourceNode.fofnValue);

        computeAStar(destination, sourceNode, new HashMap<>(), new HashMap<>(), useWeight, weight);

        sourceNode.parent = null;
        List<Node> path = new ArrayList<>();
        populatePathToDestination(nameWiseNode.get(destination), path);
        Collections.reverse(path);

        System.out.println("Path :: " + path);
        List<Node> expandedNodes = getExpandedNodes();
        System.out.println("Expanded Nodes are :: " + expandedNodes);




    }

    private static void populatePathToDestination(Node node, List<Node> path)
    {
        path.add(node);

        if (node.parent == null)
            return;

        populatePathToDestination(node.parent, path);
    }

    private static List<Node> getExpandedNodes()
    {
        List<Node> expandedNodes = new ArrayList<>();

        for (Node node : nameWiseNode.values())
        {
            if (node.expanded)
                expandedNodes.add(node);
        }
        return expandedNodes;
    }


    public static void computeAStar(String destination, Node source, Map<Float,List<Node>> unexpandedNodes, Map<Float,Node> fofnToParent, boolean useWt, float weight)
    {
        if (source.equalsName(destination))
            return;

        List<Node> nodes = source.getAllNeighbors();

        for (Node node : nodes)
        {
            node.computeFOfNValueAndUpdateParent(source, useWt, weight);
            System.out.println(node + "  " + node.fofnValue);
            updateMap(unexpandedNodes, node, fofnToParent, source);
        }


        List<Float> integers = new ArrayList<>(unexpandedNodes.keySet());
        Collections.sort(integers, FOF_N_COMPARATOR);
        Node sourceToBeExpanded = unexpandedNodes.get(integers.get(0)).get(0);



        sourceToBeExpanded.setExpanded(integers.get(0), fofnToParent.get(integers.get(0)));
        System.out.println("Node " + sourceToBeExpanded.place + "   " + sourceToBeExpanded.fofnValue + "  " +sourceToBeExpanded.distanceFromSource

        + "   " + sourceToBeExpanded.straightLineDistanceToBucharest);

        removeFromMap(unexpandedNodes, sourceToBeExpanded.fofnValue, sourceToBeExpanded, fofnToParent);
        computeAStar(destination, sourceToBeExpanded, unexpandedNodes, fofnToParent, useWt, weight);
    }

    private static void updateMap(Map<Float, List<Node>> unexpandedNodes, Node node, Map<Float, Node> fofnToParent, Node par)
    {
        List<Node> nodes = unexpandedNodes.get(node.fofnValue);
        if (nodes == null)
        {
            nodes = new ArrayList<>();
            unexpandedNodes.put(node.fofnValue, nodes);
        }

        nodes.add(node);

        fofnToParent.put(node.fofnValue, par);

    }

    private static void removeFromMap(Map<Float, List<Node>> unexpandedNodes, float key, Node node, Map<Float, Node> fofnToParent)
    {

        fofnToParent.remove(key);
        unexpandedNodes.remove(key);

    }


    public static void main(String[] args)
    {
        init();
        String start = args[0];
        String end = args[1];
        boolean useWeights = Boolean.valueOf(args[2]);
        float weight = Float.parseFloat(args[3]);
        computeAStar(start,end, useWeights, weight);


    }
}
