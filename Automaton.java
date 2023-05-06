public class Automaton {
    
    private int id;
    private Transition[] transitionList; 
    private State[] stateList; 

    public Automaton(){
        this.id = -1;
        this.transitionList = null;
        this.stateList = null;
    }

    public Automaton(int id, Transition[] transitionList, State[] stateList){
        this.id = id;
        this.transitionList = transitionList;
        this.stateList = stateList;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transition[] getTransitionList() {
        return this.transitionList;
    }

    public void setTransitionList(Transition[] transitionList) {
        this.transitionList = transitionList;
    }

    public State[] getStateList() {
        return this.stateList;
    }

    public void setStateList(State[] stateList) {
        this.stateList = stateList;
    }


}
