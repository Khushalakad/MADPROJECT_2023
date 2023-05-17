package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player = 1; //for black
    int rcount = 0;
    int bcount = 0;
    int count = 0;
    int rf = 0;
    int flag = 0;
    int[][] winningState = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {9, 10, 11}, {12, 13, 14}, {15, 16, 17},
            {18, 19, 20}, {21, 22, 23},
            {0, 9, 21}, {3, 10, 18}, {6, 11, 15},
            {1, 4, 7}, {16, 19, 22}, {8, 12, 17},
            {5, 13, 20}, {2, 14, 23}};
    int[] gameState = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public void load(View view) {
        ImageView v = (ImageView) view;

        int tag = Integer.parseInt(v.getTag().toString());


        if (flag == 0) {
            if (player == 1 && count < 9) {
                v.setImageResource(R.drawable.black);
                gameState[tag] = player;
                Toast.makeText(this, "fun5", Toast.LENGTH_LONG).show();
                player = 0;
                for (int i = 0; i < winningState.length; i++) {
                    if (gameState[winningState[i][0]] == gameState[winningState[i][1]] &&
                            gameState[winningState[i][1]] == gameState[winningState[i][2]]
                            && gameState[winningState[i][0]] > -1 && (tag == winningState[i][0] || tag == winningState[i][1] || tag == winningState[i][2])) {
                        flag = 1;
                        Toast.makeText(this, "fun7", Toast.LENGTH_LONG).show();

                    }
                }


            } else if (player == 0 && count < 9) {
                v.setImageResource(R.drawable.red2);
                gameState[tag] = player;
                Toast.makeText(this, "fun6", Toast.LENGTH_LONG).show();
                player = 1;
                count++;

                for (int i = 0; i < winningState.length; i++) {
                    if (gameState[winningState[i][0]] == gameState[winningState[i][1]] &&
                            gameState[winningState[i][1]] == gameState[winningState[i][2]]
                            && gameState[winningState[i][0]] > -1 && (tag == winningState[i][0] || tag == winningState[i][1] || tag == winningState[i][2])) {
                        flag = 2;
                        Toast.makeText(this, "fun8", Toast.LENGTH_LONG).show();

                    }
                }
            }
            if (((player == 1 && count == 9) && rf == 0) && player == gameState[tag]) {
                v.setImageDrawable(null);
                Toast.makeText(this, "fun1", Toast.LENGTH_LONG).show();
                gameState[tag] = -1;
                rf = 1;
            }
            else if ((player == 1 && rf == 1) && count == 9) {
                v.setImageResource(R.drawable.black);
                gameState[tag] = player;
                player = 0;
                rf = 0;
                Toast.makeText(this, "fun2", Toast.LENGTH_LONG).show();
                for (int i = 0; i < winningState.length; i++) {
                    if ((gameState[winningState[i][0]] == gameState[winningState[i][1]]) &&
                            (gameState[winningState[i][1]] == gameState[winningState[i][2]])
                            && gameState[winningState[i][0]] > -1 && (tag == winningState[i][0] || tag == winningState[i][1] || tag == winningState[i][2])) {
                        flag = 1;
                        Toast.makeText(this, "fun9", Toast.LENGTH_LONG).show();

                    }
                }

            } else if (((player == 0 && count == 9) && rf == 0) && player == gameState[tag]) {
                v.setImageDrawable(null);
                rf = 1;
                Toast.makeText(this, "fun3", Toast.LENGTH_LONG).show();
                gameState[tag] = -1;
            } else if ((player == 0 && rf == 1) && count == 9) {
                v.setImageResource(R.drawable.red2);
                gameState[tag] = player;
                player = 1;
                rf = 0;
                Toast.makeText(this, "fun4", Toast.LENGTH_LONG).show();
                for (int i = 0; i < winningState.length; i++) {
                    if (gameState[winningState[i][0]] == gameState[winningState[i][1]] &&
                            gameState[winningState[i][1]] == gameState[winningState[i][2]]
                            && gameState[winningState[i][0]]>-1&&(tag==winningState[i][0]||tag==winningState[i][1] || tag == winningState[i][2])) {
                        flag = 2;
                        Toast.makeText(this, "fun10", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }
        else if (flag == 1 && gameState[tag] == 0) {
            v.setImageDrawable(null);
            Toast.makeText(this, "fun11", Toast.LENGTH_LONG).show();
            gameState[tag] = -1;
            flag = 0;
            bcount = bcount + 1;
        }
        else if (flag == 2 && gameState[tag] == 1) {
            v.setImageDrawable(null);
            Toast.makeText(this, "fun12", Toast.LENGTH_LONG).show();
            gameState[tag] = -1;
            flag = 0;
            rcount = rcount + 1;
        }

        if(bcount==7) {
            Toast.makeText(this, "player 1 wins", Toast.LENGTH_LONG).show();
            flag = 3;
        }
        if(rcount==7) {
            flag = 3;
            Toast.makeText(this, "player 2 wins", Toast.LENGTH_LONG).show();
        }

    }
    /* public void play_again(View view){
         GridLayout gridLayout=findViewById(R.id.gridLayout);
         int total_image=gridLayout.getChildCount();
         for(int i=0;i<total_image;i++){
             ImageView p=(ImageView)gridLayout.getChildAt(i);
             p.setImageDrawable(null);
         }
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
