package lesson1;

public class JumpDistance extends Competition{
    private int length;

        public JumpDistance(int length) {
            this.length = length;
        }
        @Override
        public void doIt(TeamPlayers competitor) {
            competitor.jump(length);
        }
}

