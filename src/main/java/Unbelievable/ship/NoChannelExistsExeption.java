package Unbelievable.ship;

public class NoChannelExistsExeption extends Exception{
    private final int num;
    public int getNum(){
        return num;
    }
    public NoChannelExistsExeption(int num){
        this.num = num;
    }
}
