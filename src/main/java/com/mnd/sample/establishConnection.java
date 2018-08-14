package com.mnd.sample;

import io.proximax.xpx.facade.connection.LocalHttpPeerConnection;
import io.proximax.xpx.facade.connection.RemotePeerConnection;
import io.proximax.xpx.factory.ConnectionFactory;

public class establishConnection {

   /* public static final LocalHttpPeerConnection localPeerConnection =  new LocalHttpPeerConnection(
            ConnectionFactory.createNemNodeConnection("testnet","http", "104.128.226.60", 7890),
            ConnectionFactory.createIPFSNodeConnection("/ip4/127.0.0.1/tcp/5001")
    );*/

    public static RemotePeerConnection remotePeerConnection = new RemotePeerConnection("https://testnet1.gateway.proximax.io");
}
