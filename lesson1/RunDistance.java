package lesson1;


public class RunDistance extends Competition{
    private int length;

    public RunDistance(int length) {
        this.length = length;
    }

    @Override
    public void doIt(TeamPlayers competitor) {

        competitor.run(length);
    }
}
