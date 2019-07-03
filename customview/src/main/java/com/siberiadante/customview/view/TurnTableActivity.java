package com.siberiadante.customview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.siberiadante.customview.R;

import java.util.ArrayList;
import java.util.List;

public class TurnTableActivity extends AppCompatActivity {

    private TurnAwardView turnAwardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_table);
        turnAwardView = findViewById(R.id.turnAwardView);
        List<TurnItemModel> turnItemModels = new ArrayList<>();
        turnItemModels.add(new TurnItemModel("现金奖0", 10));
        turnItemModels.add(new TurnItemModel("现金奖1", 20));
        turnItemModels.add(new TurnItemModel("现金奖2", 30));
        turnItemModels.add(new TurnItemModel("现金奖3", 40));
        turnItemModels.add(new TurnItemModel("现金奖4", 50));
        turnItemModels.add(new TurnItemModel("现金奖5", 60));
        turnItemModels.add(new TurnItemModel("现金奖6", 70));
        turnItemModels.add(new TurnItemModel("现金奖7", 80));
        turnAwardView.updateTurnAwardView(turnItemModels);
        start();
    }

    private void start() {
        turnAwardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnAwardView.startRotate();
            }
        });
        turnAwardView.setListener(new TurnAwardView.TurnAwardListener() {
            @Override
            public void start() {

            }

            @Override
            public void end() {
            }
        });
    }
}
