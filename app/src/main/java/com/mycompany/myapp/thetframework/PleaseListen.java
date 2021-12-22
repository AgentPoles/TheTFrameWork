package com.mycompany.myapp.thetframework;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Paul on 2/13/2018.
 */
public class PleaseListen {
   DatabaseReference reference;
    int o;
    Context contrext;
    String aid;
     public PleaseListen(){

     }
    public PleaseListen(DatabaseReference databaseReference, int a, Context context, String id){
        this.reference = databaseReference;
        this.o = a;
        this.contrext = context;
        this.aid = id;
        if (0 ==1){
            crumby(databaseReference);
        }
    }
       public void crumby(DatabaseReference db){
           db.orderByKey().addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {

               }

               @Override
               public void onCancelled(DatabaseError databaseError) {

               }
           });
       }

}
