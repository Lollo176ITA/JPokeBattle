package main.java.com.jpokebattle.logic;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonLoader {
    private static final String POKEMON_DATA_FILE = "src/main/java/com/jpokebattle/logic/pokemon_data.xml";

    public static Map<String, PokemonSpecies> loadPokemonSpecies() {
        Map<String, PokemonSpecies> speciesMap = new HashMap<>();

        try {
            File inputFile = new File(POKEMON_DATA_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("pokemon");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    PokemonType type = PokemonType.valueOf(eElement.getElementsByTagName("type").item(0).getTextContent());
                    int baseHealth = Integer.parseInt(eElement.getElementsByTagName("baseHealth").item(0).getTextContent());
                    int baseAttack = Integer.parseInt(eElement.getElementsByTagName("baseAttack").item(0).getTextContent());
                    int baseDefense = Integer.parseInt(eElement.getElementsByTagName("baseDefense").item(0).getTextContent());
                    int baseSpeed = Integer.parseInt(eElement.getElementsByTagName("baseSpeed").item(0).getTextContent());

                    List<Move> moves = new ArrayList<>();
                    NodeList moveList = eElement.getElementsByTagName("move");

                    for (int count = 0; count < moveList.getLength(); count++) {
                        Node moveNode = moveList.item(count);

                        if (moveNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element moveElement = (Element) moveNode;

                            String moveName = moveElement.getElementsByTagName("name").item(0).getTextContent();
                            PokemonType moveType = PokemonType.valueOf(moveElement.getElementsByTagName("type").item(0).getTextContent());
                            int movePower = Integer.parseInt(moveElement.getElementsByTagName("power").item(0).getTextContent());
                            int moveAccuracy = Integer.parseInt(moveElement.getElementsByTagName("accuracy").item(0).getTextContent());
                            int moveMaxPP = Integer.parseInt(moveElement.getElementsByTagName("maxPP").item(0).getTextContent());
                            boolean isDamaging = Boolean.parseBoolean(moveElement.getElementsByTagName("isDamaging").item(0).getTextContent());

                            moves.add(new Move(moveName, moveType, movePower, moveAccuracy, moveMaxPP, isDamaging));
                        }
                    }

                    String evolution = eElement.getElementsByTagName("evolution").item(0).getTextContent();

                    PokemonSpecies species = new PokemonSpecies(name, type, baseHealth, baseAttack, baseDefense, baseSpeed, moves, evolution);
                    speciesMap.put(name, species);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return speciesMap;
    }
}

