package com.pkproject.headballclientserverheadball.server;

import java.io.Serializable;

public class ServerClientMessage implements Serializable{
    public static final int TURNONGAME = 0, TURNOFFGAME = 1, ERORR = -1;
    private int type;

    public ServerClientMessage(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
