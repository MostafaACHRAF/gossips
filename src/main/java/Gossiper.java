public class Gossiper {
    private String gossipToTell;
    private String label;
    private String name;
    private Gossiper nextGessiper;

    Gossiper(String label, String name) {
        this.label = label;
        this.name = name;
    }

    Gossiper(String name) {
        this.label = "Mr";
        this.name = name;
    }

    public String gossip() {
        return gossipToTell;
    }

    public void receiveGossip(String receivedGossip) {
        gossipToTell = receivedGossip;
    }

    public void shouldTellThis(String someThing) {
        gossipToTell = someThing;
    }



    @Override
    public boolean equals(Object obj) {
        return ((Gossiper) obj).name.equals(this.name);
    }

    @Override
    public String toString() {
        return label + " " + name;
    }
}
