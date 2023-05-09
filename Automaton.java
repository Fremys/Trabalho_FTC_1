import java.util.ArrayList;

public class Automaton {
    
    private int id;
    private ArrayList<Transition> transitionList; 
    private ArrayList<State> stateList;
    private ArrayList<State> finalStates; 

    public Automaton(){
        this.id = -1;
        this.transitionList = null;
        this.stateList = null;
        this.finalStates = new ArrayList<>();
    }

    public Automaton(int id, ArrayList<Transition> transitionList, ArrayList<State> stateList, ArrayList<State> finalStates){
        this.id = id;
        this.transitionList = transitionList;
        this.stateList = stateList;
        this.finalStates = finalStates;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Transition> getTransitionList() {
        return this.transitionList;
    }

    public void setTransitionList(ArrayList<Transition> transitionList) {
        this.transitionList = transitionList;
    }

    public ArrayList<State> getStateList() {
        return this.stateList;
    }

    public void setStateList(ArrayList<State> stateList) {
        this.stateList = stateList;
    }

    public ArrayList<State> getFinalStates(){
        return this.finalStates;
    }

    public void setFinalStates(ArrayList<State> finalStates) {
        this.finalStates = finalStates;
    }


}
