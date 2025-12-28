package Design_Patterns.Architectural;

import java.util.ArrayList;
import java.util.List;

public class P2P {

    
    // ===== PEER (узел сети) =====
    static class Peer {
        private String name;
        private List<Peer> peers = new ArrayList<>();

        public Peer(String name) {
            this.name = name;
        }

        public void connect(Peer peer) {
            peers.add(peer);
        }

        public void sendMessage(String message) {
            for (Peer peer : peers) {
                peer.receiveMessage(name, message);
            }
        }

        public void receiveMessage(String from, String message) {
            System.out.println(name + " received from " + from + ": " + message);
        }
    }

    public static void main(String[] args) {
        Peer peerA = new Peer("Peer-A");
        Peer peerB = new Peer("Peer-B");
        Peer peerC = new Peer("Peer-C");

        peerA.connect(peerB);
        peerA.connect(peerC);

        peerB.connect(peerA);
        peerB.connect(peerC);

        peerC.connect(peerA);
        peerC.connect(peerB);

        peerA.sendMessage("Hello from A");
        peerB.sendMessage("Hello from B");
        peerC.sendMessage("Hello from C");
    }
}
