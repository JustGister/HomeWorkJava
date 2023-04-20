package future.code.dark.dungeon.domen;

import future.code.dark.dungeon.config.Configuration;
import future.code.dark.dungeon.service.GameMaster;

public class Player extends DynamicObject {
    private static final int stepSize = 1;
    private int coins;
    private int conditions;

    public int getConditions() {
        return conditions;
    }

    public void setConditions(int conditions) {
        this.conditions = conditions;
    }

    public Player(int xPosition, int yPosition) {
        super(xPosition, yPosition, Configuration.PLAYER_SPRITE);
        coins = 0;
        conditions = 0;
    }

    public void move(Direction direction) {
        int tmpXPosition = getXPosition();
        int tmpYPosition = getYPosition();

        switch (direction) {
            case UP -> tmpYPosition -= stepSize;
            case DOWN -> tmpYPosition += stepSize;
            case LEFT -> tmpXPosition -= stepSize;
            case RIGHT -> tmpXPosition += stepSize;
        }

        if (isAllowedSurface(tmpXPosition, tmpYPosition) && isAllowedExit(tmpXPosition, tmpYPosition)) {
            xPosition = tmpXPosition;
            yPosition = tmpYPosition;
        }
        if (isCoin(getXPosition(), getYPosition())) {
            coins++;
        }
    }

    private boolean isCoin(int x, int y) {
        for (Coin c : GameMaster.getInstance().getCoinObjects()) {
            if (c.getXPosition() == x && c.getYPosition() == y) {
                c.setCoinCol(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Player{[" + xPosition + ":" + yPosition + "]} score: " + coins + "/9";
    }

    @Override
    protected Boolean isAllowedExit(int x, int y) {
        if (GameMaster.getInstance().getMap().getMap()[y][x] == Configuration.EXIT_CHARACTER) {
            if (coins < 9) {
                return false;
            }
            conditions = 1;
        }
        return true;
    }
}
