public class State {

    private int id;
    private String name;

    public State(){
        this.id = -1;
        this.name = null;
    }

    public State(int id, String name){
        this.id = id;
        this.name = name;
    }

    //Gets and Sets
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

}
