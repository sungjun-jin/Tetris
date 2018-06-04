package com.example.jinsungjun.tetris;



public class Block {

    int index;
    int x, y;
    int rotation;
    //회전 수
    int rotationLimit;
    int block[][][];
    int paintIndex;

    //임의의 7가지 색깔 사용
    //int colors[] = {Color.RED, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.parseColor("FF00FF")};


    public Block(int block[][][], int index) {
        this.block = block;
        this.index = index;
        this.x = 3; //Stage의 정 가운데에 처음 블럭 생성
        this.y = 0;
        this.rotation = 0;
        this.rotationLimit = block.length;
        this.paintIndex = index;
    }

    public void rotate() {
        //rotation의 증가 : 블럭의 회전
        rotation = rotation + 1;
        if (rotation >= rotationLimit) {

            //rotation의 회전가능한 갯수를 초과하면
            rotation = 0;
        }
    }

    public int[][] currentBlock(){
        return block[rotation];
    }

    public void down() {
        y = y + 1;
    }

    public void left() {
        x = x - 1;
    }

    public void right() {
        x = x + 1;
    }
}
