public class State {

    private int id;
    private String name;
    private boolean finish; 

    public State(){
        this.id = -1;
        this.name = null;
        this.finish = false;
    }

    public State(int id, String name, boolean finish){
        this.id = id;
        this.name = name;
        this.finish = finish;
    }

    //Gets and Sets
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public boolean getFinish(){
        return finish;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setFinish(boolean finish){
        this.finish = finish;
    }
}
