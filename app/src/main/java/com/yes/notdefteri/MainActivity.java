package com.yes.notdefteri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.yes.notdefteri.model.Not;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    FrameLayout sheet;
    LinearLayout ekle,cikis,todo;
    BottomSheetBehavior bottomSheetBehavior;
    View view,view2;
    String uid;
    FirebaseFirestore fStore;
    DocumentReference docref;
    RecyclerView noteLists;
    FirestoreRecyclerAdapter<Not,NotViewHolder> noteAdapter;
    private static final int REQUEST_CODE_SPEECH_INPUT_BASLIK = 0;
    private static final int REQUEST_CODE_SPEECH_INPUT_ICERIK = 1;
    private static final int REQUEST_CODE_SPEECH_INPUT_BASLIK_2 = 2;
    private static final int REQUEST_CODE_SPEECH_INPUT_ICERIK_3 = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sheet=findViewById(R.id.sheet);
        ekle=findViewById(R.id.ekle);
        todo=findViewById(R.id.toDo);
        cikis=findViewById(R.id.cikis);
        bottomSheetBehavior = BottomSheetBehavior.from(sheet);
        bottomSheetBehavior.setPeekHeight(200);
        noteLists=findViewById(R.id.notelist);
        fStore=FirebaseFirestore.getInstance();
        uid= FirebaseAuth.getInstance().getCurrentUser().getUid();





        Query query = fStore.collection("Notlar").document(uid).collection("Notlarım").orderBy("tarih", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Not> tümNotlar = new FirestoreRecyclerOptions.Builder<Not>()
                .setQuery(query,Not.class)
                .build();

        noteAdapter=new FirestoreRecyclerAdapter<Not, NotViewHolder>(tümNotlar) {
            @Override
            protected void onBindViewHolder(@NonNull NotViewHolder notViewHolder,  int i, @NonNull Not not) {
                String docId = noteAdapter.getSnapshots().getSnapshot(i).getId();
                notViewHolder.title.setText(not.getBaslik());
                notViewHolder.content.setText(not.getIcerik());




                notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.white));
                notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.white));

                if(not.getRenk().equals("r1")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r1));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r1));
                }
                else if(not.getRenk().equals("r2")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r2));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r2));

                }
                else if(not.getRenk().equals("r3")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r3));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r3));

                }
                else if(not.getRenk().equals("r4")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r4));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r4));

                }
                else if(not.getRenk().equals("r5")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r5));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r5));

                }
                else if(not.getRenk().equals("r6")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r6));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r6));

                }
                else if(not.getRenk().equals("r7")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r7));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r7));

                }
                else if(not.getRenk().equals("r8")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r8));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r8));

                }
                else if(not.getRenk().equals("r9")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r9));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r9));

                }
                else if(not.getRenk().equals("r10")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r10));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r10));

                }
                else if(not.getRenk().equals("r11")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r11));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r11));
                }
                else if(not.getRenk().equals("r12")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r12));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r12));
                }
                else if(not.getRenk().equals("r13")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r13));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r13));
                }
                else if(not.getRenk().equals("r14")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r14));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r14));
                }
                else if(not.getRenk().equals("r15")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r15));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r15));
                }
                else if(not.getRenk().equals("r16")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r16));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r16));
                }
                else if(not.getRenk().equals("r17")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r17));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r17));
                }
                else if(not.getRenk().equals("r18")){
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.r18));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.r18));
                }
                else{
                    notViewHolder.cardView.setCardBackgroundColor(getResources().getColor(R.color.gray));
                    notViewHolder.mCardView.setCardBackgroundColor(getResources().getColor(R.color.gray));
                }



                if(not.getFav().equals("false"))
                    notViewHolder.star.setImageResource(R.drawable.star_outline);
                else {
                    notViewHolder.star.setImageResource(R.drawable.star_fill);
                }

                notViewHolder.star.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Map<String,Object> note = new HashMap<>();
                            if(not.getFav().equals("false")){

                                note.put("fav","true");
                            }
                            else{
                                note.put("fav","false");
                            }
                            docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                            docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });

                notViewHolder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(
                                MainActivity.this,R.style.BottomSheetTheme
                        );
                        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(
                                R.layout.not_click_layout,
                                findViewById(R.id.bottomSheet)
                        );

                        bottomSheetDialog.setContentView(bottomSheetView);
                        bottomSheetDialog.show();

                        bottomSheetView.findViewById(R.id.goruntule).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(
                                        MainActivity.this,R.style.BottomSheetTheme
                                );
                                View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(
                                        R.layout.notgoruntule,
                                        findViewById(R.id.bottomSheet)
                                );

                                TextView baslik=bottomSheetView.findViewById(R.id.baslik);
                                TextView icerik=bottomSheetView.findViewById(R.id.icerik);

                                baslik.setText(not.getBaslik());
                                icerik.setText(not.getIcerik());
                                bottomSheetDialog.setContentView(bottomSheetView);
                                bottomSheetDialog.show();

                            }
                        });

                        bottomSheetView.findViewById(R.id.renkSec);
                        bottomSheetView.setOnClickListener(v1 -> {
                            Dialog dialog = new Dialog(MainActivity.this, android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
                            dialog.setContentView(R.layout.spinner);
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

                            dialog.show();

                            dialog.findViewById(R.id.r1).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r1");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r2).setOnClickListener(v11 -> {
                                DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                Map<String, Object> note = new HashMap<>();
                                note.put("renk", "r2");


                                docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialog.dismiss();

                                    }
                                }).addOnFailureListener(e -> Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());

                            });
                            dialog.findViewById(R.id.r3).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r3");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r4).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r4");


                                    docref.update(note).addOnSuccessListener(aVoid -> {
                                        dialog.dismiss();

                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r5).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r5");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r6).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r6");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r7).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r7");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r8).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r8");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r9).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r9");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r10).setOnClickListener(v113 -> {
                                DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                Map<String, Object> note = new HashMap<>();
                                note.put("renk", "r10");


                                docref.update(note).addOnSuccessListener(aVoid -> {
                                    dialog.dismiss();

                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            });
                            dialog.findViewById(R.id.r11).setOnClickListener(v114 -> {
                                DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                Map<String, Object> note = new HashMap<>();
                                note.put("renk", "r11");


                                docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialog.dismiss();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            });
                            dialog.findViewById(R.id.r12).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r12");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r13).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r13");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r14).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r14");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r15).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r15");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r16).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r16");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            dialog.findViewById(R.id.r17).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v1) {
                                    DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("renk", "r17");


                                    docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            dialog.dismiss();

                                        }
                                    }).addOnFailureListener(e -> Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());

                                }
                            });
                            dialog.findViewById(R.id.r18).setOnClickListener(v112 -> {
                                DocumentReference docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                Map<String, Object> note = new HashMap<>();
                                note.put("renk", "r18");


                                docref.update(note).addOnSuccessListener(aVoid -> {
                                    dialog.dismiss();

                                }).addOnFailureListener(e -> Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());
                            });
                        });

                        bottomSheetView.findViewById(R.id.duzenle).setOnClickListener(v12 -> {
                            BottomSheetDialog bottomSheetDialog1 =new BottomSheetDialog(
                                    MainActivity.this,R.style.BottomSheetTheme
                            );
                            view2 = LayoutInflater.from(getApplicationContext()).inflate(
                                    R.layout.notguncelle,
                                    findViewById(R.id.bottomSheet)
                            );
                            EditText baslik= view2.findViewById(R.id.baslik);
                            EditText icerik= view2.findViewById(R.id.icerik);
                            baslik.setText(not.getBaslik());
                            icerik.setText(not.getIcerik());
                            bottomSheetDialog1.setContentView(view2);
                            bottomSheetDialog1.show();

                            view2.findViewById(R.id.mic1).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    Intent intent
                                            = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                                            Locale.getDefault());
                                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Başlığı söyleyin");

                                    try {
                                        startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT_BASLIK_2);
                                    }
                                    catch (Exception e) {
                                        Toast
                                                .makeText(MainActivity.this, " " + e.getMessage(),
                                                        Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                }
                            });

                            view2.findViewById(R.id.mic2).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    Intent intent
                                            = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                                            Locale.getDefault());
                                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "İçeriği söyleyin");

                                    try {
                                        startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT_ICERIK_3);
                                    }
                                    catch (Exception e) {
                                        Toast
                                                .makeText(MainActivity.this, " " + e.getMessage(),
                                                        Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                }
                            });

                            view2.findViewById(R.id.kaydet).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v12) {

                                    String nBaslik = baslik.getText().toString();
                                    String nIcerik = icerik.getText().toString();

                                    if (nBaslik.isEmpty() || nIcerik.isEmpty()) {
                                        Toast.makeText(MainActivity.this, "Boş bırakmayın", Toast.LENGTH_SHORT).show();
                                    } else {

                                        docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                        Map<String, Object> note = new HashMap<>();
                                        note.put("baslik", nBaslik);
                                        note.put("icerik", nIcerik);


                                        docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                bottomSheetDialog1.dismiss();


                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                }
                            });

                        });

                        bottomSheetView.findViewById(R.id.sil).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document(docId);
                                docref.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        bottomSheetDialog.dismiss();


                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                    }
                });
            }
            @NonNull
            @Override
            public NotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.not_item,parent,false);
                return new NotViewHolder(view);
            }
        };

        noteLists.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        noteLists.setAdapter(noteAdapter);

        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ToDoActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(
                        MainActivity.this,R.style.BottomSheetTheme
                );
                 view= LayoutInflater.from(getApplicationContext()).inflate(
                        R.layout.notolustur,
                        findViewById(R.id.bottomSheet)
                );

                view.findViewById(R.id.mic1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent
                                = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                                Locale.getDefault());
                        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Başlığı söyleyin");

                        try {
                            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT_BASLIK);
                        }
                        catch (Exception e) {
                            Toast
                                    .makeText(MainActivity.this, " " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });

                view.findViewById(R.id.mic2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent
                                = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                                Locale.getDefault());
                        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "İçeriği söyleyin");

                        try {
                            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT_ICERIK);
                        }
                        catch (Exception e) {
                            Toast
                                    .makeText(MainActivity.this, " " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
            
          

                view.findViewById(R.id.kaydet).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText baslik = view.findViewById(R.id.baslik);
                        EditText icerik = view.findViewById(R.id.icerik);
                        String nBaslik = baslik.getText().toString();
                        String nIcerik = icerik.getText().toString();

                        if (nBaslik.isEmpty() || nIcerik.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Boş bırakmayın.", Toast.LENGTH_SHORT).show();
                        } else {

                            docref = fStore.collection("Notlar").document(uid).collection("Notlarım").document();
                            Map<String, Object> note = new HashMap<>();
                            note.put("baslik", nBaslik);
                            note.put("icerik", nIcerik);
                            note.put("tarih", Calendar.getInstance().getTime());
                            note.put("renk", "ffffff");
                            note.put("fav", "false");


                            docref.set(note).addOnSuccessListener(aVoid -> {
                                bottomSheetDialog.dismiss();


                            }).addOnFailureListener(e -> Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());
                        }
                    }
                });
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
            }
        });
    }


    public class NotViewHolder extends RecyclerView.ViewHolder{
        TextView title,content;
        View view;
        ImageView star;
        CardView mCardView,cardView;
        public NotViewHolder(@NonNull View itemView) {
            super(itemView);
            star = itemView.findViewById(R.id.star);
            title = itemView.findViewById(R.id.titles);
            content = itemView.findViewById(R.id.content);
            mCardView = itemView.findViewById(R.id.noteCard);
            cardView = itemView.findViewById(R.id.cardView);

            view = itemView;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        noteAdapter.startListening();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (noteAdapter != null) {
            noteAdapter.stopListening();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SPEECH_INPUT_BASLIK) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                EditText text=view.findViewById(R.id.baslik);
                text.setText(Objects.requireNonNull(result).get(0));
            }
        }

        if (requestCode == REQUEST_CODE_SPEECH_INPUT_ICERIK) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result1 = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                EditText text=view.findViewById(R.id.icerik);
                text.setText(Objects.requireNonNull(result1).get(0));
            }
        }

        if (requestCode == REQUEST_CODE_SPEECH_INPUT_BASLIK_2) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result1 = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                EditText text=view2.findViewById(R.id.baslik);
                text.setText(Objects.requireNonNull(result1).get(0));
            }
        }

        if (requestCode == REQUEST_CODE_SPEECH_INPUT_ICERIK_3) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result1 = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                EditText text=view2.findViewById(R.id.icerik);
                text.setText(Objects.requireNonNull(result1).get(0));
            }
        }
    }
}

