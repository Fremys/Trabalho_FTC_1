//Imports para manipular XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Map;


public class Main{
    
    public static void main(String[] args) throws Exception{
        //Definir dados
        
        //ler automato
        Automaton automaton = lerXml();

        bloom(automaton.getStateList(), findAlphabet(automaton.getTransitionList()), automaton.getTransitionList(), findStateForId(0, automaton.getStateList()), automaton.getFinalStates());

        System.out.println("end");

    }

    public static ArrayList<State> getReachableStates(int id, ArrayList<Transition> transitions, ArrayList<State> states) {
        //Definir dados
        ArrayList<State> result = new ArrayList<State>();

        for(int i = 0; i < transitions.size(); i++) {
            if(transitions.get(i).getFrom() == id ){
                // states.a
            }
        }

        return result;

    }

    
    public static void bloom(ArrayList<State> states, ArrayList<String> alphabet, ArrayList<Transition> transitions, State init, ArrayList<State> finalStates){
        //Definir dados
        

        System.out.println("end");

    }
    
    public static State findStateForId(int id, ArrayList<State> states){
        //Definir dados
        State result = null;

        for(int i = 0; i < states.size(); i++){
            if(states.get(i).getId() == id){
                result = states.get(i);
                i = states.size();
            }
        }

        return result;
    }
    
    public static ArrayList<String> findAlphabet(ArrayList<Transition> transitions){
        //Definir dados
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < transitions.size(); i++){
            if( !result.contains(transitions.get(i).getRead()))
                result.add(transitions.get(i).getRead());
        }

        return result;
        
    }

    public static Automaton lerXml() throws Exception {
        //Definir dados
        Automaton response;

        //Ler arquivo
        File xmlFile = new File("exemple.jff");

        //Construir documento
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        NodeList nListState = doc.getElementsByTagName("state");
        NodeList nListTrans = doc.getElementsByTagName("transition");

        //Definir dados  
        ArrayList<Transition> transitionList = new ArrayList<>();
        ArrayList<State> stateList = new ArrayList<>();
        ArrayList<State> finalStates = new ArrayList<>();

        //Salvar as transições

        for(int i = 0; i < nListTrans.getLength(); i++){
            Node nNode = nListTrans.item(i);

            if(nNode.getNodeType() == Node.ELEMENT_NODE){

                Element eElement = (Element) nNode;

                //Pegar filhos do transition
                String from = eElement.getElementsByTagName("from").item(0).getTextContent();
                String to = eElement.getElementsByTagName("to").item(0).getTextContent();
                String read = eElement.getElementsByTagName("read").item(0).getTextContent();

    


                Transition transition = new Transition(read, Integer.parseInt(to), Integer.parseInt(from));
                transitionList.add(transition);
            }
        };

        //Salvar os estados

        for(int j = 0; j < nListState.getLength(); j++){
            Node nNode = nListState.item(j);

            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;
                
                boolean finish = eElement.getElementsByTagName("final").item(0) != null;

                
                State state = new State(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"), finish);
                stateList.add(state);
                if(finish)
                    finalStates.add(state);
            }
        }

        response = new Automaton(0, transitionList, stateList, finalStates);

        return response;

    }
}