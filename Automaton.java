import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Automaton {
    
    private int id;
    private ArrayList<Transition> transitionList; 
    private Map<Integer, State> stateList;
    private Map<Integer, State> finalStates;
    private ArrayList<String> alphabet; 

    public Automaton(){
        this.id = -1;
        this.transitionList = null;
        this.stateList = null;
        this.finalStates = new HashMap<Integer, State>();
        this.alphabet = new ArrayList<String>();
    }

    public Automaton(int id, ArrayList<Transition> transitionList, Map<Integer, State> stateList, Map<Integer, State> finalStates, ArrayList<String> alphabet){
        this.id = id;
        this.transitionList = transitionList;
        this.stateList = stateList;
        this.finalStates = finalStates;
        this.alphabet = alphabet;
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

    public Map<Integer, State> getStateList() {
        return this.stateList;
    }

    public void setStateList(Map<Integer, State> stateList) {
        this.stateList = stateList;
    }

    public Map<Integer, State> getFinalStates(){
        return this.finalStates;
    }

    public void setFinalStates(Map<Integer, State> finalStates) {
        this.finalStates = finalStates;
    }

    public ArrayList<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(ArrayList<String> alphabet) {
        this.alphabet = alphabet;
    }


}
