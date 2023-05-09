//Imports para manipular XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Map;


public class Main{
    
    public static void main(String[] args) throws Exception{
        //Definir dados
        
        //ler automato
        Automaton automaton = lerXml();

        bloom(automaton.getStateList(), automaton.getAlphabet(), automaton.getTransitionList(), automaton.getStateList().get(0), automaton.getFinalStates());

        System.out.println("end");

    }

    public static Automaton bloom(Map<Integer, State> states, ArrayList<String> alphabet, ArrayList<Transition> transitions, State init, Map<Integer, State> finalStates){
        //Definir dados
        Automaton result = new Automaton();

        Map<Integer, State> reachableStates = getReachableStates(init.getId(), transitions, states);
        
        Map<Integer, State> newStates = new HashMap<Integer, State>();
        ArrayList<Transition> newTransitions = new ArrayList<Transition>();

        //Verificar casos especiais
        if(finalStates.size() == 0){

            newStates.put(init.getId(), init);

            //A nova lista de transições será baseada no alfabeto
            //criando transições apenas para o estado inicial (fazer um loop no estado inicial)
            for(String letter : alphabet){
                newTransitions.add(new Transition(letter, init.getId(), init.getId()));
            }
            
            result = new Automaton(0, newTransitions, newStates, null, alphabet);

        }else{
            //usar o newState como variável auxiliar para verificação
            newStates = removeStates(states, finalStates);

            if(newStates.size() == 0){
                
            newStates.put(init.getId(), init);
            
            //A nova lista de transições será baseada no alfabeto
            //criando transições apenas para o estado inicial (fazer um loop no estado inicial)
            for(String letter : alphabet){
                newTransitions.add(new Transition(letter, init.getId(), init.getId()));
            }
            
            result = new Automaton(0, newTransitions, newStates,  newStates, alphabet);

            }
        }



        System.out.println("end");

        return result;

    }
    
    public static Map<Integer, State> removeStates(Map<Integer, State> states, Map<Integer, State> removeStates){
        //Definir dados
        Map<Integer, State> result = new HashMap<Integer, State>(states);

        removeStates.forEach((key, value)->{
            result.remove(key);
        });

        return result;
    }
    
    public static Map<Integer, State> getReachableStates(int mainState, ArrayList<Transition> transitions, Map<Integer, State> states) {
        //Definir dados
        Map<Integer, State> result = new HashMap<Integer, State>();

        for(int i = 0; i < transitions.size(); i++) {
            if(transitions.get(i).getFrom() == mainState ){
                result.put(transitions.get(i).getTo(), states.get(transitions.get(i).getTo()));
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
        Map<Integer,State> stateList = new HashMap<Integer,State>();
        Map<Integer,State> finalStates = new HashMap<Integer,State>();
        ArrayList<String> alphabet = null;

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
                stateList.put(state.getId(), state);

                if(finish)
                    finalStates.put(state.getId(), state);
            }
        }

        alphabet = findAlphabet(transitionList);

        response = new Automaton(0, transitionList, stateList, finalStates, alphabet);

        return response;

    }
}