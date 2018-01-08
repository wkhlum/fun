/**
 * Created by helum on 2018-01-03.
 */
public class DisjointSet {
    public int n;
    public DisjointSet parent;
    public int degree;

    public DisjointSet(int n) {
        degree = 1;
        this.n = n;
        parent = null;
    }

    public String toString() {
        return "n=" + n + ", degree=" + degree + ", parent? " + (parent == null);
    }

    public static DisjointSet union(DisjointSet a, DisjointSet b) {
        DisjointSet result;
        DisjointSet child;
        DisjointSet a1 = a.findset();
        DisjointSet b1 = b.findset();
        if (a1.degree > b1.degree) {
            result = a1;
            child = b1;
        } else {
            result = b1;
            child = a1;
        }
        child.parent = result;
        if (result.degree == child.degree) {
            // Add degree plus all parents
            DisjointSet cur = result;
            while (cur != null) {
                cur.degree++;
                cur = cur.parent;
            }
        }
        return result;
    }

    public DisjointSet findset() {
        DisjointSet cur = this;
        while (cur.parent != null) {
            cur = cur.parent;
        }
        return cur;
    }
}
