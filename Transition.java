public class Transition {
    
    private String read;
    private int from;
    private int to;
    
    
    public Transition() {
        this.read = null;
        this.from = -1;
        this.to = -1;
    }

    public Transition(String read, int to, int from){
        this.read = read;
        this.from = from;
        this.to = to;
    }

    //Get and Puts

    public String getRead() {
        return this.read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public int getFrom() {
        return this.from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return this.to;
    }

    public void setTo(int to) {
        this.to = to;
    }


}
