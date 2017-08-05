package com.example.nuwanrathnayaka.mobileclient;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Nuwan rathnayaka on 8/5/2017.
 */

public class DataAccess {

    private DatabaseReference mDatabase;
    Product product;
    String table;
    private String key;

    public DataAccess(Product prod){
        this.product=prod;
        this.mDatabase= FirebaseDatabase.getInstance().getReference();
        this.setKey();
        if(product.getCategory().matches("men")){
            table="men";
        }
        if(product.getCategory().matches("women")){
            table="women";
        }
        if(product.getCategory().matches("kids")){
            table="kids";
        }
        if(product.getCategory().matches("accessories")){
            table="accessories";
        }
        if(product.getCategory().matches("life_style")){
            table="life_style";
        }
    }

    public void setKey(){
        try {
            this.key = mDatabase.push().getKey();
        }catch (Exception e){
            //toast error

        }
    }

    public void setData(){
        mDatabase.child(table).child(key).child("title").setValue(product.getTitle());
        mDatabase.child(table).child(key).child("category").setValue(product.getCategory());
        mDatabase.child(table).child(key).child("description").setValue(product.getDescription());
        mDatabase.child(table).child(key).child("price").setValue(product.getPrice());
        mDatabase.child(table).child(key).child("icon").setValue(product.getUrl());
    }
}
