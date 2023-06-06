import javax.tools.JavaCompiler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Computer CreateComputer() {
        Scanner scanner = new Scanner(System.in);
        Computer temp = new Computer();
        System.out.println("Введите название: ");
        temp.setName(scanner.nextLine());

        System.out.println("Введите производителя: ");
        temp.setOrigin(scanner.nextLine());

        System.out.println("Введите цену: ");
        temp.setPrice(scanner.nextInt());

        scanner.nextLine(); // consume the newline character

        System.out.println("Введите типы (через запятую): ");
        String typesInput = scanner.nextLine();
        String[] typesArray = typesInput.split(",");
        ArrayList<String> types = new ArrayList<>();
        for (String type : typesArray) {
            types.add(type.trim());
        }
        temp.setTypes(types);

        System.out.println("Введите критическое значение (true/false): ");
        temp.setCritical(scanner.nextBoolean());

        return temp;
    }
    public static void AddComputerInXmlFile(Computer comp) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        String filePath = "components.xml";

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // Загрузка существующего XML файла, если он существует
        Document doc;
        File xmlFile = new File(filePath);
        if (xmlFile.exists()) {
            doc = docBuilder.parse(xmlFile);
        } else {
            doc = docBuilder.newDocument();
        }

        Element rootElement;
        if (doc.getDocumentElement() == null) {
            rootElement = doc.createElement("Devices");
            doc.appendChild(rootElement);
        } else {
            rootElement = doc.getDocumentElement();
        }

        Element device = doc.createElement("Device");
        rootElement.appendChild(device);

        Element name = doc.createElement("Name");
        name.setTextContent(comp.getName());
        device.appendChild(name);

        Element origin = doc.createElement("Origin");
        origin.setTextContent(comp.getOrigin());
        device.appendChild(origin);

        Element price = doc.createElement("Price");
        price.setTextContent(Integer.toString(comp.getPrice()));
        device.appendChild(price);

        Element types = doc.createElement("Types");
        for (String type : comp.getTypes()) {
            Element typeElement = doc.createElement("Type");
            typeElement.setTextContent(type);
            types.appendChild(typeElement);
        }
        device.appendChild(types);

        Element critical = doc.createElement("Critical");
        critical.setTextContent(Boolean.toString(comp.isCritical()));
        device.appendChild(critical);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);

        System.out.println("XML файл обновлен");
    }

    public static void CreateXmlFile() throws TransformerException, ParserConfigurationException {

        ArrayList<Computer> computers = new ArrayList<>();
        computers.add(new Computer("Компьютер Dell", "Германия", 100, Arrays.asList("Периферийный", "Мультимедийый"), true));
        computers.add(new Computer("Компьютер Asus", "Франция", 200, Arrays.asList("Периферийный"), false));
        computers.add(new Computer("Компьютер Apple", "Америка", 300, Arrays.asList("Устройство ввода-вывода"), true));

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Devices");
        doc.appendChild(rootElement);

        for (Computer component : computers) {
            Element device = doc.createElement("Device");
            rootElement.appendChild(device);

            Element name = doc.createElement("Name");
            name.setTextContent(component.getName());
            device.appendChild(name);

            Element origin = doc.createElement("Origin");
            origin.setTextContent(component.getOrigin());
            device.appendChild(origin);

            Element price = doc.createElement("Price");
            price.setTextContent(Integer.toString(component.getPrice()));
            device.appendChild(price);

            Element types = doc.createElement("Types");
            for (String type : component.getTypes()) {
                Element typeElement = doc.createElement("Type");
                typeElement.setTextContent(type);
                types.appendChild(typeElement);
            }
            device.appendChild(types);

            Element critical = doc.createElement("Critical");
            critical.setTextContent(Boolean.toString(component.isCritical()));
            device.appendChild(critical);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("components.xml"));
        transformer.transform(source, result);

        System.out.println("XML файл создан.");
    }

    public static void ReadXmlFile() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("components.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("Device");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String name = element.getElementsByTagName("Name").item(0).getTextContent();
                String origin = element.getElementsByTagName("Origin").item(0).getTextContent();
                int price = Integer.parseInt(element.getElementsByTagName("Price").item(0).getTextContent());
                NodeList typeList = element.getElementsByTagName("Type");
                ArrayList<String> types = new ArrayList<>();
                for (int j = 0; j < typeList.getLength(); j++) {
                    types.add(typeList.item(j).getTextContent());
                }
                boolean critical = Boolean.parseBoolean(element.getElementsByTagName("Critical").item(0).getTextContent());

                Computer component = new Computer(name, origin, price, types, critical);

                System.out.println("Компьютер:");
                System.out.println("Название: " + component.getName());
                System.out.println("Производитель : " + component.getOrigin());
                System.out.println("Цена: " + component.getPrice());
                System.out.println("Тип: " + component.getTypes());
                System.out.println("Критерии: " + component.isCritical());
                System.out.println();
            }
        }
    }
    public static void ConvertXmlDocument() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        try {
            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer transformer = tFact.newTransformer(new StreamSource("Computer.xsl"));
            transformer.transform(new StreamSource("components.xml"), new
                    StreamResult("PC.html"));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
    while (true)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свой выбор: 1 - Записать созданные , 2 - Прочитать, 3 - Записать один компьютер");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                CreateXmlFile();
                break;
            case 2:
                ReadXmlFile();
                break;
            case 3:
                AddComputerInXmlFile(CreateComputer());
                break;
            case 4:
                ConvertXmlDocument();
                break;
            default:
                break;
        }
    }

    }
}