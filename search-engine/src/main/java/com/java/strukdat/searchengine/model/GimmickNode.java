package com.java.strukdat.searchengine.model;

public class GimmickNode extends Node {
    private Runnable gimmickAction;

    public GimmickNode(String key, String value, String imgPath, Runnable gimmickAction) {
        super(key, value, imgPath);
        this.gimmickAction = gimmickAction;
    }

    public Runnable getGimmickAction() {
        return gimmickAction;
    }

    public void executeGimmick() {
        if (gimmickAction != null) {
            gimmickAction.run();
        }
    }

}
