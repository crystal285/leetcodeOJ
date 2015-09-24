public class binaryHeap {
  List<Integer> H = new ArrayList<Integer>();

  public binaryHeap() {
  }

  public void insert(int vertex,int[] band) {
    H.add(vertex);
    moveUp(H.size() - 1,band);
  }

  void moveUp(int pos,int[] band) {
    while (pos > 0) {
      int parent = (pos - 1) / 2;
      if (band[H.get(pos)] <= band[H.get(parent)] ) {
        break;
      }
      Collections.swap(H, pos, parent);
      pos = parent;
    }
  }

  public int maximum(int[] band) {
    int removedNode = H.get(0);
    int lastNode = H.remove(H.size() - 1);
    if (!H.isEmpty()) {
      H.set(0, lastNode);
      moveDown(0,band);
    }
    return removedNode;
  }

  void moveDown(int pos, int[] band) {
    while (pos < H.size() / 2) {
      int child = 2 * pos + 1;
      if (child < H.size() - 1 && band[H.get(child)] < band[(H.get(child + 1))] ) {
        ++child;
      }
      if (band[H.get(pos)] >= band[(H.get(child))]) {
        break;
      }
      Collections.swap(H, pos, child);
      pos = child;
    }
  }
}
