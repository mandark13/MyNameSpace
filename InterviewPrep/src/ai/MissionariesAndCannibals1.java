package ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shalini Hemachandran on 1/28/2017.
 */
public class MissionariesAndCannibals1
{

    static Map<Integer, Node> idToNode = new HashMap<>();
    static Map<Integer,List<Node>> outGoing = new HashMap<>();

    public static class Node
    {
        int id;
        boolean visited;
        int parentId;

        public Node(int id)
        {
            this.id = id;
        }

        @Override
        public String toString()
        {
            return String.valueOf(id);
        }

        public void reset()
        {
            this.visited = false;
        }
    }

    public static void main(String[] args)
    {

        System.out.println("HIIIII ");
        List<List<Node>> allValidPaths = getAllValidPaths();

        

    System.out.println("Total Number of valid Nodes :: " + idToNode.size()) ;
        for (List<Node> allValidPath : allValidPaths)
        {
            System.out.println("*************");
            System.out.println(format(allValidPath));
            System.out.println("*************");
        }




        System.out.println("Search Space Total :: " + allValidPaths.size());

        System.out.println(invalidNode(79));

        System.out.println(transitionValid(idToNode.get(79),idToNode.get(72)));


    }

    public static void resetValues()
    {
        for (Node node : idToNode.values())
        {
            node.reset();
        }

    }


    public static String format(List<Node> nodes)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < nodes.size(); i++)
        {
            stringBuilder.append(formatNodeString(nodes.get(i)));

            if (i == nodes.size() - 1)
                break;

            stringBuilder.append("  -->  ");

        }

        return stringBuilder.toString();
    }

    private static String formatNodeString(Node node)
    {
        String s = convertToBinary(node.id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(1));
        stringBuilder.append(s.charAt(2));
        stringBuilder.append(s.charAt(3));
        stringBuilder.append("-");
        stringBuilder.append(s.charAt(4));
        stringBuilder.append(s.charAt(5));
        stringBuilder.append(s.charAt(6));
        stringBuilder.append("-");
        stringBuilder.append(s.charAt(7));

        return stringBuilder.toString();
    }

    public static List<List<Node>> getAllValidPaths()
    {
        for (int i = 0; i < 256; i++)
        {
            if (invalidNode(i))
                continue;
            Node node = new Node(i);
            idToNode.put(i, node);
        }


        System.out.println(idToNode.get(97));

        for (Node startNode : idToNode.values())
        {
            for (Node endNode : idToNode.values())
            {
                if (transitionValid(startNode, endNode))
                {

                    System.out.println("Start  :: " + formatNodeString(startNode) );

                    System.out.println("End  :: " + formatNodeString(endNode) );

                    List<Node> nodes = outGoing.get(startNode.id);
                    if (nodes == null)
                    {
                        nodes = new ArrayList<>();
                        outGoing.put(startNode.id, nodes);
                    }
                    nodes.add(endNode);
                }

            }

        }


        buildParentChildAssociation(idToNode.get(1));
        resetValues();







        resetValues();
        List<List<Node>> allValidPathsFromSrcToDestination = getPathsFrom(idToNode.get(0), idToNode.get(127));

        return allValidPathsFromSrcToDestination;

    }



    private static void buildParentChildAssociation(Node node)
    {

        node.visited = true;
        List<Node> nodes = outGoing.get(node.id);
        if (nodes == null)
            return;
        for (Node node1 : nodes)
        {
            if (node1.visited)
                continue;

            node1.parentId = node.id;
            buildParentChildAssociation(node1);
        }

    }

    private static List<List<Node>> getPathsFrom(Node startNode, Node endNode)
    {

        List<List<Node>> nodes = new ArrayList<>();
        ArrayList<Node> nodes1 = new ArrayList<>();
        nodes1.add(startNode);
        getPaths(startNode, endNode, nodes, nodes1);
        return nodes;
    }

    private static void getPaths(Node startNode, Node endNode, List<List<Node>> nodes, ArrayList<Node> tmp)
    {

            if (startNode == endNode)
            {
                nodes.add(new ArrayList<>(tmp));
                return;
            }


        startNode.visited = true;
        List<Node> allOutGoingEdges = outGoing.get(startNode.id);


        for (Node allOutGoingEdge : allOutGoingEdges)
        {
            if (!allOutGoingEdge.visited)
            {
                tmp.add(allOutGoingEdge);
                getPaths(allOutGoingEdge, endNode, nodes, tmp);
                tmp.remove(allOutGoingEdge);
            }
        }
        startNode.visited = false;

    }

    private static boolean transitionValid(Node startNode, Node endNode)
    {


        int startBoat = startNode.id & 1;

        int endBoat = endNode.id & 1;




        if (startBoat == endBoat)
        {
            return false;
        }
        int start = startNode.id & 126;
        int end = endNode.id & 126;


        int diff = start ^ end;

        int numberOf1s = findNumberOf1s(diff, 8);
        if ( numberOf1s > 2 || numberOf1s <= 0)
        {

            return false;

        }


        for (int i = 0; i < 8; i++)
        {
            start = start >> 1;
            end = end >> 1;


            if ((start & 1) == (end & 1))
                continue;

            if ((end & 1) != endBoat)
            {

                return false;
            }
        }


        return true;

    }

    public static String convertToBinary(int decimal)
    {
        StringBuilder stringBuilder = new StringBuilder();
        String bin = convertToBinary0(decimal);

        if (bin.length() != 8)
        {
            for (int i = 0; i < 8 - bin.length(); i++)
            {
                stringBuilder.append("0");
            }
        }

        stringBuilder.append(bin);

        return stringBuilder.toString();
    }

    private static  String convertToBinary0(int decimal)
    {
        if (decimal == 0)
            return "";
        return convertToBinary0(decimal/2) + (char)((decimal % 2) + '0');
    }

    private static boolean invalidNode(int i)
    {

        if ((i & 128) == 128)
            return true;

        int missionaries = i & 14;
        int cannibals = i & 112;
        int noOfMissionariesOnRightSide = findNumberOf1s(missionaries, 8);
        int noOfCannibalsOnRightSide = findNumberOf1s(cannibals, 8);

        int noOfMissionariesOnLeftSide = 3 - noOfMissionariesOnRightSide;
        int noOfCannibalsOnLeftSide = 3 - noOfCannibalsOnRightSide;

        if (noOfMissionariesOnRightSide == 0 || noOfMissionariesOnLeftSide == 0)
            return false;

        return (noOfCannibalsOnRightSide > noOfMissionariesOnRightSide) || (noOfCannibalsOnLeftSide > noOfMissionariesOnLeftSide);

    }

    private static int findNumberOf1s(int number, int noOfDigits)
    {
        int noOf1s = 0;
        for (int i = 0; i < 8; i++)
        {
            if ( (number & 1) == 1)
                noOf1s++;
            number = number >> 1;
        }
        return noOf1s;
    }

}
