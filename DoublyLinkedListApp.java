class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

}
class DoublyLinkList {
    public Node<Integer> getNewNode(Integer i) {
        Node<Integer> a = new Node<Integer>();
        a.data = i;
        a.next = null;
        a.previous = null;

        return a;
    }

    public Node<Integer> insert(Integer i, Node<Integer> node) {
        if (node == null) {
            return getNewNode(i);
        }

        Node<Integer> head = node;

        while (node.next != null) {
            node = node.next;
        }

        Node<Integer> a = getNewNode(i);
        a.previous = node;
        node.next = a;

        return head;
    }

    public Node<Integer> insertAtStart(Node<Integer> head, Integer data) {
        if (head == null) {
            return getNewNode(data);
        }
        Node<Integer> t = getNewNode(data);
        head.previous = t;
        t.next = head;

        return t;
    }

    //A node can be inserted at last and at any given position
    public Node<Integer> insertAtGivenPosition(Node<Integer> head, Integer data, int position) {
        if (head == null) {
            if (position == 1) {
                return getNewNode(data);
            } else {
                return null;
            }
        }

        if (position == 1) {
            Node<Integer> t = getNewNode(data);
            head.previous = t;
            t.next = head;
            return t;
        }

        Node<Integer> node = head;

        while (node != null && position > 2) {
            node = node.next;
            position--;
        }

        if (node == null) {
            System.out.println("Position is not valid");
            return head;
        }

        Node<Integer> t = getNewNode(data);
        t.next = node.next;
        t.previous = node;
        if (node.next != null) {
            node.next.previous = t;
        }
        node.next = t;

        return head;
    }

    public Node<Integer> deleteFirstNode(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.next != null) {
            head.next.previous = null;
        }

        return head.next;
    }

    //A node can be deleted at last and at any given position
    public Node<Integer> deleteNodeAtGivenPosition(Node<Integer> head, int position) {
        if (head == null) {
            return null;
        }

        if (position == 1) {
            if (head.next != null) {
                head.next.previous = null;
            }
            return head.next;
        }

        Node<Integer> node = head;

        while (node != null && position > 1) {
            node = node.next;
            position--;
        }
        if (node == null) {
            System.out.println("Element does not exist in list");
            return head;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }
        node.previous.next = node.next;

        return head;
    }
}

public class DoublyLinkedListApp {

    public static void main(String[] args) {
        DoublyLinkList a = new DoublyLinkList();
        Node<Integer> head = null;

        head = a.insert(12, head);
        head = a.insert(99, head);
        head = a.insert(37, head);
        head = a.insert(5, head);
        head = a.insert(25, head);

        head = a.insertAtStart(head, 20);
        head = a.insertAtStart(head, 10);

        head = a.insertAtGivenPosition(head, 29, 8);

        head = a.deleteFirstNode(head);

        head = a.deleteNodeAtGivenPosition(head, 2);
    }
}