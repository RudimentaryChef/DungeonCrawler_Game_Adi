package com.example.cs2340c_team41.models;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.example.cs2340c_team41.BoundsStatus;
import com.example.cs2340c_team41.R;
import com.example.cs2340c_team41.viewmodels.PlayerViewModel;
import com.example.cs2340c_team41.views.EndScreenActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private Bitmap backgroundBitmap;
    private int tileNumber = 0;
    private Integer tileset;
    private GameButton endButton;
    private GameButton upButton;
    private int direction = 0;
    private GameButton downButton;
    private GameButton rightButton;
    private GameButton leftButton;
    private GameLoop gameLoop;
    private Context context;
    private PlayerViewModel playerViewModel;
    private String name;
    private int score;
    private Leaderboard leaderboard;
    public Game(Context context, String sprite, String name, int hp) {
        super(context);

        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.context = context;
        gameLoop = new GameLoop(this, surfaceHolder);
        this.name = name;

        this.leaderboard = Leaderboard.getInstance();

        this.playerViewModel =
                new PlayerViewModel(name, hp,
                        (float) getWidth(), (float) getHeight(),
                        100, sprite);

        playerViewModel.setSprite(sprite);
        int buttonWidth;
        int buttonHeight;
        int newWidth = 200;

        Bitmap endButton = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.fast_forward);
        buttonWidth = endButton.getWidth();
        buttonHeight = endButton.getHeight();
        this.endButton = new GameButton(Bitmap.createScaledBitmap(
                endButton, newWidth, buttonWidth * newWidth / buttonHeight, false));

        Bitmap upButton = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.up_arrow);
        buttonWidth = endButton.getWidth();
        buttonHeight = endButton.getHeight();
        this.upButton = new GameButton(Bitmap.createScaledBitmap(
                upButton, newWidth, buttonWidth * newWidth / buttonHeight, false));

        Bitmap rightButton = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.right_arrow);
        buttonWidth = rightButton.getWidth();
        buttonHeight = rightButton.getHeight();
        this.rightButton = new GameButton(Bitmap.createScaledBitmap(
                rightButton, newWidth, buttonWidth * newWidth / buttonHeight, false));

        Bitmap downButton = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.down_arrow);
        buttonWidth = downButton.getWidth();
        buttonHeight = downButton.getHeight();
        this.downButton = new GameButton(Bitmap.createScaledBitmap(
                downButton, newWidth, buttonWidth * newWidth / buttonHeight, false));

        Bitmap leftButton = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.left_arrow);
        buttonWidth = leftButton.getWidth();
        buttonHeight = leftButton.getHeight();
        this.leftButton = new GameButton(Bitmap.createScaledBitmap(
                leftButton, newWidth, buttonWidth * newWidth / buttonHeight, false));
        this.tileset = R.drawable.tile1;
        setFocusable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // detect when the endButton is clicked
            if (isButtonClicked(endButton, event)) {
                goToEndScreen();
            }
            // map keyword functionality
            if (isButtonClicked(upButton, event)) {
                direction = 1;
                return true;
            }
            if (isButtonClicked(downButton, event)) {
                direction = 2;
                return true;
            }
            if (isButtonClicked(leftButton, event)) {
                direction = 3;
                return true;
            }
            if (isButtonClicked(rightButton, event)) {
                direction = 4;
                return true;
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            direction = 0;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameLoop.startLoop();
        playerViewModel.positionPlayer((float) getWidth() / 2, (float) getHeight() / 2);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawBackground(canvas);
        drawScore(canvas);
        playerViewModel.draw(this.context, canvas);
        endButton.draw(canvas, 100, getHeight() - 100);
        drawKeyPad(canvas, getWidth() - 300, getHeight() - 300);
    }

    public void drawScore(Canvas canvas) {
        this.score = 100 - (int) gameLoop.getElapsedTime();
        String score = Integer.toString(this.score);
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setTypeface(ResourcesCompat.getFont(context, R.font.press_start_2p));
        paint.setTextSize(100);
        paint.setColor(color);
        paint.setTextAlign(Paint.Align.CENTER);
        int xPos = canvas.getWidth() / 2;
        canvas.drawText("Score", xPos, 200, paint);
        paint.setTextSize(70);
        canvas.drawText(score, xPos, 300, paint);
    }

    public void drawBackground(Canvas canvas) {
        Bitmap tile = BitmapFactory.decodeResource(getResources(), this.tileset);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(tile, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        canvas.drawRect(0, 0,  getWidth(), getHeight(), paint);
    }

    public void update() {
        this.score = calculateScore();
        // maintain a certain direction if the button remains pressed
        if (direction == 1) {
            playerViewModel.moveUp();
        } else if (direction == 2) {
            playerViewModel.moveDown();
        } else if (direction == 3) {
            playerViewModel.moveLeft();
        } else if (direction == 4) {
            playerViewModel.moveRight();
        }
        BoundsStatus bounds = playerViewModel.checkBounds(getWidth() - 100,
                getHeight() - 100);
        if (bounds == BoundsStatus.RIGHT_EDGE) {
            tileNumber = (tileNumber - 1) % 3;
            playerViewModel.enterLeft(getWidth() - 100);
        } else if (bounds == BoundsStatus.LEFT_EDGE) {
            if (tileNumber == 2) {
                goToEndScreen();
                return;
            }
            tileNumber = (tileNumber + 1) % 3;
            playerViewModel.enterRight();
        }
        if (tileNumber == 0) {
            this.tileset = R.drawable.tile1;
        } else if (tileNumber == 1) {
            this.tileset = R.drawable.tile2;
        } else {
            this.tileset = R.drawable.tile3;
        }
        if (this.score == 0) {
            goToEndScreen();
        }
    }

    public int calculateScore() {
        return 100 - (int) gameLoop.getElapsedTime();
    }

    public void goToEndScreen() {
        gameLoop.stopLoop();
        Intent intent = new Intent(this.getContext(), EndScreenActivity.class);
        Attempt newAttempt = new Attempt(this.name, this.score, getCurrentTime());
        leaderboard.addAttempt(newAttempt);
        context.startActivity(intent);
    }

    public String getCurrentTime() {
        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mma");

        // Get the current date and time
        Date currentDate = new Date();

        // Format the date and time in the desired format
        String formattedTime = dateFormat.format(currentDate);
        return formattedTime;
    }

    public boolean isButtonClicked(GameButton button, MotionEvent event) {
        int buttonWidth = button.getWidth();
        int buttonHeight = button.getHeight();
        double topLeftX = button.getButtonX();
        double topLeftY = button.getButtonY();
        double bottomRightX = topLeftX + buttonWidth;
        double bottomRightY = topLeftY + buttonHeight;

        return (event.getX() > topLeftX && event.getX() < bottomRightX)
                && (event.getY() > topLeftY && event.getY() < bottomRightY);
    }

    public void drawKeyPad(Canvas canvas, float x, float y) {
        upButton.draw(canvas, x, y - 150);
        downButton.draw(canvas, x, y + 150);
        rightButton.draw(canvas, x - 150, y);
        leftButton.draw(canvas, x + 150, y);
    }

    public void drawUPS(Canvas canvas) {
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        Typeface customTypeface = ResourcesCompat.getFont(context, R.font.press_start_2p);
        paint.setTypeface(customTypeface);
        paint.setTextSize(100);
        paint.setColor(color);
        canvas.drawText("UPS: " + averageUPS, 100, 300, paint);
    }

    public void drawFPS(Canvas canvas) {
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setTypeface(ResourcesCompat.getFont(context, R.font.press_start_2p));
        paint.setTextSize(100);
        paint.setColor(color);
        canvas.drawText("FPS: " + averageFPS, 100, 500, paint);
    }

}
