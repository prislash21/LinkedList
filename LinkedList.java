import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    /**
     * This is the main method and execute when project run
     *
     * @param args
     * @author Priota Roy
     * @version 1.0
     * @since 2020-03-24
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        /** Creating linkedList object there*/
        LinkedList linkedList = new LinkedList();
        /** HashMap that contain every node of this linkedList*/
        HashMap<Integer, LinkedList.Node> nodeHashMap = new HashMap();


        System.out.print("Add the head : ");
        int headValue = scanner.nextInt();
        if (headValue > 0) {
            /**Adding new head for the linkedList*/
            linkedList.head = new LinkedList.Node(headValue);
            nodeHashMap.put(headValue, linkedList.head);
            for (; ; ) {
                System.out.print("Add new node : ");
                int nodeValue = scanner.nextInt();
                if (nodeValue > 0) {
                    /**Adding new node*/
                    LinkedList.Node node = new LinkedList.Node(nodeValue);
                    System.out.print("Enter headValue : ");
                    int headNodeInt = scanner.nextInt();
                    try {
                        /**Checking that node contains the targeted node*/
                        LinkedList.Node headNode = nodeHashMap.get(headNodeInt);
                        /** If targeted node not found then throw exception*/
                        if (Objects.nonNull(headNode)) {
                            if (headNode.next == null) {
                                headNode.next = node;
                                nodeHashMap.put(nodeValue, node);
                            } else
                                throw new Exception("Already next value exists");
                        } else
                            throw new Exception("No targeted node found");

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                } else
                    break;
            }
        }
    }
}


class LinkedList {
    /**
     * Head of the linedList
     */
    Node head;

    /**
     * Every node has it own value and contain the next node
     * This inner class is made static so that main() can access it
     */
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
