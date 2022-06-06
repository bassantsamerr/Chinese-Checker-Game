import java.util.ArrayList;

public class marble {
    public int x;
    public int y;
    public int value;
    public int Score;
    public  ArrayList<Board> AvailableMoves = new ArrayList<Board>();
    public  ArrayList<marble> AvailableMarbles=new ArrayList<>();
    public marble(int x, int y,int value)
    {
        this.x = x;
        this.y = y;
        this.value = value;
        Score=0;
    }
    public marble(){}
    boolean isValid( ){
        if (this.x>0 && this.x<17){
            if(this.y >0 && this.y<25)
                return true;
        }
        return false;
    }
    public marble(marble copy)
    {
        this.x=copy.x;
        this.y=copy.y;
        this.value=copy.value;
    }

    public ArrayList<Board> getAvailableMoves(Board b) {
        marble newMarble = new marble();
        if (this.isValid()) {
            //case diagonal down right
            newMarble.x = this.x + 1;
            newMarble.y = this.y + 1;
            if(newMarble.isValid()){
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[this.x][this.y] = 0;
                    b1.board[newMarble.x][newMarble.y] = this.value; //player 1 is cpu , player 2 is human
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    AvailableMoves.add(b1);
                }
                else if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                    hopDownRight(newMarble.x, newMarble.y, this.value, b);
                }}
            //case  newMarble down left
            newMarble = new marble();
            newMarble.x = this.x + 1;
            newMarble.y = this.y - 1;
            if(newMarble.isValid()){

                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[this.x][this.y] = 0;
                    b1.board[newMarble.x][newMarble.y] = this.value; //player 1 is cpu , player 2 is human
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    AvailableMoves.add(b1);
                } else if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {

                    hopDownLeft(newMarble.x, newMarble.y, this.value, b);
                }
            }
            //case diagonal top right
            newMarble = new marble();
            newMarble.x = this.x - 1;
            newMarble.y = this.y + 1;
            if(newMarble.isValid()){
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[this.x][this.y] = 0;
                    b1.board[newMarble.x][newMarble.y] = this.value; //player 1 is cpu , plauer 2 is human
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    AvailableMoves.add(b1);
                } else if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                    hopTopRight(newMarble.x, newMarble.y, this.value, b);
                }}
            //case  diagonal top left
            newMarble = new marble();
            newMarble.x = this.x - 1;
            newMarble.y = this.y - 1;
            if(newMarble.isValid()){
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[this.x][this.y] = 0;
                    b1.board[newMarble.x][newMarble.y] = this.value; //player 1 is cpu , plauer 2 is human
                    AvailableMoves.add(b1);
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);

                } else if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                    hopTopLeft(newMarble.x, newMarble.y, this.value, b);

                }
            }
            //case left
            newMarble = new marble();
            newMarble.x = this.x;
            newMarble.y = this.y - 2;
            if(newMarble.isValid()){
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[this.x][this.y] = 0;
                    b1.board[newMarble.x][newMarble.y] = this.value; //player 1 is cpu , plauer 2 is human
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    AvailableMoves.add(b1);

                } else if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                    hopLeft(newMarble.x, newMarble.y, this.value, b);

                }
            }

            //case Right
            newMarble = new marble();
            newMarble.x = this.x;
            newMarble.y = this.y + 2;
            if(newMarble.isValid()){
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[this.x][this.y] = 0;
                    b1.board[newMarble.x][newMarble.y] = this.value; //player 1 is cpu , plauer 2 is human
                    AvailableMoves.add(b1);
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                }
                else if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                    hopRight(newMarble.x, newMarble.y, this.value, b);

                }
            }
        }
        return AvailableMoves;
    }


    void hopDownLeft(int x, int y, int value, Board b) {
        boolean m1=false , m2 =true;
        marble newMarble = new marble();
        newMarble.x = x + 1;
        newMarble.y = y - 1;
        while (m1!=m2) {
            if (newMarble.isValid()) {
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[x - 1][y + 1] = 0;
                    b1.board[newMarble.x][newMarble.y] = value; //player 1 is cpu , plauer 2 is human
                    AvailableMoves.add(b1);
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    if (newMarble.isValid()) {
                        newMarble.x++;
                        newMarble.y--;
                        if(!newMarble.isValid())
                            break;

                        if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                            m2 = true;
                        } else if (b.board[newMarble.x][newMarble.y] == 0) {
                            m2=false;                        }
                    }
                } else
                {
                   m2 = false;
                }
                newMarble.x++;
                newMarble.y--;

            }
            else break;
        }
    }

    void hopDownRight(int x, int y, int value, Board b) {
        boolean m1=false , m2 =true;
        marble newMarble = new marble();
        newMarble.x = x + 1;
        newMarble.y = y + 1;
        while (m1!=m2) {
            if (newMarble.isValid()) {
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[x - 1][y - 1] = 0;
                    b1.board[newMarble.x][newMarble.y] = value; //player 1 is cpu , plauer 2 is human
                    AvailableMoves.add(b1);
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    newMarble.x++;
                    newMarble.y++;
                    if(!newMarble.isValid())
                        break;
                    if (newMarble.isValid()) {
                        if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                            m2=true;
                        } else if (b.board[newMarble.x][newMarble.y] == 0) {
                            m2=false;
                        }
                    }
                }
                else{m2 = false;}
                newMarble.x++;
                newMarble.y++;
            }
            else break;
        }
    }

    void hopTopRight(int x, int y, int value, Board b) {
        boolean m1=false , m2 =true;
        marble newMarble = new marble();
        newMarble.x = x - 1;
        newMarble.y = y + 1;
        while (m1!=m2) {
            if (newMarble.isValid()) {
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[x + 1][y - 1] = 0;
                    b1.board[newMarble.x][newMarble.y] = value; //player 1 is cpu , player 2 is human
                    AvailableMoves.add(b1);
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    newMarble.x--;
                    newMarble.y++;
                    if(!newMarble.isValid())
                        break;
                    if (newMarble.isValid()) {
                        if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                            m2=true;
                        } else if (b.board[newMarble.x][newMarble.y] == 0) {
                            m2=false;                        }
                    }
                } else  {
                    m2=false;
                }
                newMarble.x--;
                newMarble.y++;
            } else break;
        }
    }

    void hopTopLeft(int x, int y, int value, Board b) {
        boolean m1=false , m2 =true;
        marble newMarble = new marble();
        newMarble.x = x - 1;
        newMarble.y = y - 1;
        while (m1 != m2) {
            if (newMarble.isValid()) {

                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[x + 1][y + 1] = 0;
                    b1.board[newMarble.x][newMarble.y] = value; //player 1 is cpu , plauer 2 is human
                    AvailableMoves.add(b1);
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    newMarble.x--;
                    newMarble.y--;
                    if(!newMarble.isValid())
                        break;
                    if (newMarble.isValid()) {
                        if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                            m2 = true; // if count reached 2 that means 2 fiiled nodes are wara b3d
                        } else if (b.board[newMarble.x][newMarble.y] == 0) {
                            m2 = false;
                        }
                    }
                } else if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                    m2 = false;
                }
                newMarble.x--;
                newMarble.y--;
            } else break;
        }
    }

    void hopRight(int x, int y, int value, Board b) {
        boolean m1=false , m2 =true;
        marble newMarble = new marble();
        newMarble.x = x ;
        newMarble.y = y + 2;
        while (m1 != m2) {
            if (newMarble.isValid()) {

                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[x][y - 2] = 0;
                    b1.board[newMarble.x][newMarble.y] = value; //player 1 is cpu , plauer 2 is human
                    AvailableMoves.add(b1);
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    newMarble.y+=2;
                    if(!newMarble.isValid())
                        break;
                    if (newMarble.isValid()) {
                        if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                            m2 = true; // if count reached 2 that means 2 fiiled nodes are wara b3d
                        } else if (b.board[newMarble.x][newMarble.y] == 0) {
                            m2 = false;
                        }
                    }
                } else if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                    m2 = false;
                }

                newMarble.y+=2;
            } else break;
        }
    }
    void hopLeft(int x, int y, int value, Board b) {
        boolean m1=false , m2 =true;
        marble newMarble = new marble();
        newMarble.x = x ;
        newMarble.y = y - 2;
        while (m1 != m2) {
            if (newMarble.isValid()) {
                if (b.board[newMarble.x][newMarble.y] == 0) {
                    Board b1 = new Board(b);
                    b1.board[x][y + 2] = 0;
                    b1.board[newMarble.x][newMarble.y] = value; //player 1 is cpu , plauer 2 is human
                    AvailableMoves.add(b1);
                    marble object = new marble(newMarble);
                    AvailableMarbles.add(object);
                    newMarble.y-=2;
                    if(!newMarble.isValid())
                        break;
                    if (newMarble.isValid()) {
                        if (b.board[newMarble.x][newMarble.y] == 1 || b.board[newMarble.x][newMarble.y] == 2) {
                            m2 = true; // if count reached 2 that means 2 fiiled nodes are wara b3d
                        } else if (b.board[newMarble.x][newMarble.y] == 0) {
                            m2 = false;
                        }
                    }
                } else if (b.board[newMarble.x][newMarble.y] == 1 ||b.board[newMarble.x][newMarble.y] == 2) {
                    m2 = false;
                }

                newMarble.y-=2;
            } else break;
        }
    }
}
