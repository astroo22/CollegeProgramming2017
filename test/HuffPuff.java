import java.util.*;
import java.io.*;

public class HuffPuff {
    public static String fileName;
  public class HuffmanNode {

    public char character;
    public int freq;
    public HuffmanNode leftChild;
    public HuffmanNode rightChild;

    public HuffmanNode(char characrer, int freq, HuffmanNode leftChild, HuffmanNode rightChild) {
      this.character = character;
      this.freq = freq;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }
  }
  public class HuffComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode one, HuffmanNode two) {
      return one.freq - two.freq;
    }
  }

  public class BitObj {
    public int num;
  }
  public void encode(String fileText) throws FileNotFoundException, IOException {
    if(fileText == null || fileText.length() == 0) {
      throw new NullPointerException("Try adding something to your text file.");
    }
    this.fileName = fileName;
    Map<Character, Integer> frequency = createFreqMap(fileText);
    HuffmanNode head = createHuffTree(frequency);
    Map<Character, String> codeMap = createCodeMap(frequency.keySet(), head);
    String encoded = encodeString(codeMap, fileText);
    saveTree(head);
    saveMessage(encoded);
  }

  //Creates the map for frequency.
  private Map<Character, Integer> createFreqMap(String fileText) {
    Map<Character, Integer> toReturn = new HashMap<Character, Integer>();
    for(int i = 0; i < fileText.length(); i++) {
      char holder = fileText.charAt(i);
      if(toReturn.containsKey(holder)) {
        int currentFreq = toReturn.get(holder);
        toReturn.put(holder, currentFreq++);
      }
      else {
        toReturn.put(holder, 1);
      }
    }
    return toReturn;
  }
  //Creates a Huffman Tree
  private HuffmanNode createHuffTree(Map<Character, Integer> map) {
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(new HuffComparator());
    for(Map.Entry<Character, Integer> entry : map.entrySet()) {
      queue.add(new HuffmanNode(entry.getKey(), entry.getValue(), null, null));
    }
    while(queue.size() > 1) {
      HuffmanNode first = queue.poll();
      HuffmanNode second = queue.poll();
      queue.offer(new HuffmanNode('\0', first.freq + second.freq, first, second));
    }
    return queue.remove();
  }
  //Creates the Map for codeMap
  private Map<Character, String> createCodeMap(Set<Character> freqSet, HuffmanNode head) {
    Map<Character, String> codeMap = new HashMap<Character, String>();
    startEncode(head, codeMap, "");
    return codeMap;
  } //These two methods go together.
  private void startEncode(HuffmanNode head, Map<Character, String> codeMap, String code) {
    if(head.leftChild == null && head.rightChild == null) {
      codeMap.put(head.character, code);
    }
    startEncode(head.leftChild, codeMap, code + '0');
    startEncode(head.rightChild, codeMap, code + '1');
  }

  private String encodeString(Map<Character, String> codeMap, String code) {
    String toReturn = "";
    for(int i = 0; i < code.length(); i++) {
      toReturn += (codeMap.get(code.charAt(i)));
    }
    return toReturn;
  }

  private void saveTree(HuffmanNode head) throws FileNotFoundException, IOException {
    BitSet bits = new BitSet();
      try (ObjectOutputStream treeOOS = new ObjectOutputStream(new FileOutputStream("tree.huff"))) {
        try(ObjectOutputStream charOOS = new ObjectOutputStream(new FileOutputStream("char.huff"))) {
        BitObj b = new BitObj();
        arrange(bits, b, charOOS, head);
        bits.set(b.num, true);
        treeOOS.writeObject(bits);
        }
      }
  }
  private void arrange(BitSet bits, BitObj b, ObjectOutputStream charOOS, HuffmanNode head) throws IOException {
    if(head.leftChild == null && head.rightChild == null) {
      bits.set(b.num++, false);
      charOOS.writeChar(head.character);
    }
    bits.set(b.num++, true);
    arrange(bits, b, charOOS, head.leftChild);
    bits.set(b.num++, true);
    arrange(bits, b, charOOS, head.rightChild);
  }

  private void saveMessage(String message) throws IOException {
    BitSet bits = new BitSet();
    try(ObjectOutputStream messageOOS = new ObjectOutputStream(new FileOutputStream("compressed.huff"))) {
    int i = 0;
    for(i = 0; i < message.length(); i++) {
      if(message.charAt(i) != '0') {
        bits.set(i, true);
      }
      else {
        bits.set(i, false);
      }
    }
    bits.set(i, true);
    messageOOS.writeObject(bits);
  }
}

/////////////////////////////////DECODE/////////////////////////////////////////

public String decode() throws FileNotFoundException, ClassNotFoundException, IOException {
  HuffmanNode head = decodeTree();
  return decodedMessage(head);
}

private HuffmanNode decodeTree() throws IOException, FileNotFoundException, ClassNotFoundException {
  try (ObjectInputStream treeOIS = new ObjectInputStream(new FileInputStream("tree.huff"))) {
    try(ObjectInputStream charOIS = new ObjectInputStream(new FileInputStream("char.huff"))) {
    BitSet bits = (BitSet)(treeOIS.readObject());
    return arrange(bits, charOIS, new BitObj());
    }
  }

}

private HuffmanNode arrange(BitSet bits, ObjectInputStream ois, BitObj b) throws IOException{
  HuffmanNode node = new HuffmanNode('\0', 0, null, null);
  if(bits.get(b.num)) {
    b.num++;
    node.character = ois.readChar();
    return node;
  }
  b.num++;
  node.leftChild = arrange(bits, ois, b);

  b.num++;
  node.rightChild = arrange(bits, ois, b);

  return node;
}

private String decodedMessage(HuffmanNode node) throws IOException, FileNotFoundException, ClassNotFoundException {
  try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(""))) {
    BitSet bits = (BitSet)(ois.readObject());
    String newMessage = "";
    for(int i = 0; i < (bits.length()-1);) {
      HuffmanNode holder = node;
      while(holder.leftChild != null) {
        if(bits.get(i)) {
          holder = holder.rightChild;
        }
        else {
          holder = holder.leftChild;
        }
        i++;
      }
      newMessage += holder.character;
    }
    return newMessage;
  }
}

}
