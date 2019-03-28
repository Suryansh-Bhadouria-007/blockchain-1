package com.adobe.corp.suryansh.helper.entity;

import com.adobe.corp.suryansh.helper.helper.SHA256Helper;

import java.util.Date;

public class Block {
    private int id;
    private int nonce;
    private long timestamp;
    private String hash;
    private String previousHash;
    private String transaction;

    public Block(int id, String previousHash, String transaction) {
        this.id = id;
        this.previousHash = previousHash;
        this.transaction = transaction;
        this.timestamp = new Date().getTime();
        generateHash();
    }

    private void generateHash() {
        String dataToHash = Integer.toString(id) + previousHash + Long.toString(timestamp) + Integer.toString(nonce) + transaction.toString();
        String hashValue = SHA256Helper.hash(dataToHash);
        this.hash = hashValue;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void incrementNonce() {
        this.nonce++;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.transaction + "-" + this.hash + "-" + this.previousHash;
    }
}
