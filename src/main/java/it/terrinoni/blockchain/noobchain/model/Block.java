package it.terrinoni.blockchain.noobchain.model;

/*
 * Created by Marco Terrinoni, on 07/06/2018 - 22:35.
 */

import it.terrinoni.blockchain.noobchain.utility.StringUtil;

public class Block {

  public String hash;
  public String previousHash;

  private String data;

  private long timestamp; // number of milliseconds since 1/1/1970
  private int nonce;

  public Block(String data, String previousHash) {
    this.previousHash = previousHash;
    this.data = data;
    this.timestamp = System.currentTimeMillis();
    this.hash = calculateHash();
  }

  public String calculateHash() {
    return StringUtil
        .applySha256(previousHash + data + Long.toString(timestamp) + Integer.toString(nonce));
  }

  public void mineBlock(int difficulty) {
    String target = new String(new char[difficulty])
        .replace('\0', '0'); //Create a string with difficulty * "0"
    while (!hash.substring(0, difficulty).equals(target)) {
      nonce++;
      hash = calculateHash();
    }
    System.out.println("Block Mined!!! : " + hash);
  }
}
