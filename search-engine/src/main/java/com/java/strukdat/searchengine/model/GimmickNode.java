package com.java.strukdat.searchengine.model;

public class GimmickNode extends Node {
    private String gimmickFXMLPath;

    public GimmickNode(String key, String value, String gimmickFXMLPath) {
        super(key, value);
        this.gimmickFXMLPath = gimmickFXMLPath;
    }

    public String getGimmickFXMLPath() {
        return gimmickFXMLPath;
    }

}
