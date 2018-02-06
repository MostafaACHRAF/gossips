import java.util.ArrayList;
import java.util.List;

public class Gossips {

    private List<Gossiper> allGossipers;
    private List<GossipTransaction> allGossipsTransactions;
    private GossipTransaction gossipTransaction;
    private String gossip;
    private int actualGossipTransaction;


    public Gossips(String... gossipsInfo) {
        allGossipers = new ArrayList<Gossiper>();
        allGossipsTransactions = new ArrayList<GossipTransaction>();
        actualGossipTransaction = 0;
        for (String gossipInfo : gossipsInfo) {
            allGossipers.add(createNewGossiper(gossipInfo));
        }
    }

    public Gossips from(String gossiperName) {
        Gossiper gossiperSource = getGossipByName(gossiperName);
        gossipTransaction = new GossipTransaction(gossiperSource);
        return this;
    }

    public Gossips to(String gossiperName) {
        Gossiper gossiper = getGossipByName(gossiperName);
        if (gossipIsDefinded()) {
            gossiper.shouldTellThis(gossip);
        } else {
            gossipTransaction.to(gossiper);
            allGossipsTransactions.add(gossipTransaction);
        }
        return this;
    }

    public Gossips say(String someThing) {
        gossip = someThing;
        return this;
    }

    public String ask(String gossipName) {
        Gossiper gossiper = getGossipByName(gossipName);
        return gossiper.gossip();
    }

    public void spread() {
        allGossipsTransactions.get(actualGossipTransaction).broadcast();
        actualGossipTransaction++;
    }

    private Gossiper createNewGossiper(String gossipInfo) {
        String gossiperLabel = gossipInfo.split(" ")[0];
        String gossiperName = gossipInfo.split(" ")[1];
        return new Gossiper(gossiperLabel, gossiperName);
    }

    private Gossiper getGossipByName(String gossipName) {
        Gossiper gossiper = new Gossiper(gossipName);
        return allGossipers.get(allGossipers.indexOf(gossiper));
    }

    private boolean gossipIsDefinded() {
        return gossip != null;
    }
}
