import java.util.Stack;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Stack<Alibi> cards = new Stack<>();

        Alibi[] values = Alibi.values();
        for (Alibi character : values) {
            cards.add(character);
        }
        Collections.shuffle(cards);

        District dis1 = new District(Orientation.NORTH, Alibi.VIOLET, true, false);

        System.out.println(dis1.getOrientation());
    }

    public static void AlibiAction (Stack<Alibi> cards) {
        if (cards.size() > 0) {
            System.out.println("L'alibi obtenu est : " + cards.pop().getName());
        }
        else {
            System.out.println("Il n'y a plus de cartes Alibi ! Choisissez une autre action");
        }
    }
}