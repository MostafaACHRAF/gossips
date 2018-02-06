public class GossipTransaction {
    private Gossiper from;
    private Gossiper to;

    public GossipTransaction(Gossiper gossiperSource) {
        this.from = gossiperSource;
    }

    public void to(Gossiper targetedGossiper) {
        this.to = targetedGossiper;
    }

    public void broadcast() {
        String gossipContent = from.gossip();
        to.receiveGossip(gossipContent);
        from.receiveGossip("");
    }

    @Override
    public String toString() {
        return "FROM : " + from + " TO : " + to;
    }
}
