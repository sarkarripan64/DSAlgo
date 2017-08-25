package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class Add2NumLLRep {
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        //ll1.push(1);
        ll1.push(8);
        ll1.push(6);
        ll1.push(5);

        ll2.push(2);
        ll2.push(4);
        ll2.push(8);
        ll2.push(9);

        add(ll1.head, ll2.head);
    }

    static void add(LinkedNode l1, LinkedNode l2) {
        LinkedNode res = null;
        LinkedNode temp = null;
        LinkedNode resHead = null;
        int c = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = c + l1.data + l2.data;
            c = sum / 10;
            sum = sum % 10;
            //System.out.println("sum = "+sum+ " car "+c);
            temp = new LinkedNode(sum);
            //LinkedUtil.printLinkedList(temp);
            if (res == null) {
                res = temp;
                resHead = res;
            } else {
                res.next = temp;
                res = res.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null) {
            sum = l1.data + c;
            c = sum / 10;
            sum = sum % 10;
            temp = new LinkedNode(sum);
            if (res == null) {
                res = temp;
            } else {
                res.next = temp;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.data + c;
            c = sum / 10;
            sum = sum % 10;

            temp = new LinkedNode(sum);
            if (res == null) {
                res = temp;
            } else {
                res.next = temp;
            }
            l2 = l2.next;
        }
        if (c > 0) {
            res.next = new LinkedNode(c);
        }

        LinkedUtil.printLinkedList(resHead);
    }
}
