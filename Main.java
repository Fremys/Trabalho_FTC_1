//Imports para manipular XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.*;


public class Main{

    public static void main(String[] args) throws Exception{
        //Definir dados

        //ler automato
        Automaton automaton = lerXml();

        System.out.println("end");

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
        Transition[] transitionList = new Transition[nListTrans.getLength()];
        State[] stateList = new State[nListState.getLength()];

        
        // System.out.println(nListTrans.getLength());
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
                transitionList[i] = transition;
            }
        };

        //Salvar os estados

        for(int j = 0; j < nListState.getLength(); j++){
            Node nNode = nListState.item(j);

            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;
                
                State state = new State(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"));
                stateList[j] = state;
            }
        }

        response = new Automaton(0, transitionList, stateList);

        return response;

    }
}