package com.example.cs2340c_team41.viewmodels;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cs2340c_team41.model.Player;
import androidx.lifecycle.ViewModel;
public class PlayerViewModel extends ViewModel{
    Player player = Player.getInstance("Player 1", 100, 0, 0, 0, null);

}
