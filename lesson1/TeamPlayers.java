package lesson1;

public abstract class TeamPlayers {
    String name;
    int maxRunLength;
    int maxJumpLength;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public TeamPlayers(String name, int maxRunLength, int maxJumpLength) {

        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxJumpLength = maxJumpLength;
        this.onDistance = true;
    }

    public void run(int length){
        if (length <=maxRunLength){
            System.out.println("Участник по имени " + name + " успешно пробежал дистанцию");
        } else {
            System.out.println("Участник по имени " + name + " не смог пробежать дистанцию");
            onDistance = false;
        }
    }

    public void jump(int length){
        if (length <=maxJumpLength){
            System.out.println("Участник по имени "  + name  + " успешно прыгнул на нужную длину");
        } else {
            System.out.println("Участник по имени " + name + " не смог прыгнуть на нужную длину");
            onDistance = false;
        }
    }

    public void showResult(){
        System.out.println("Участник по имени " + name + ": " + onDistance);
    }

}



